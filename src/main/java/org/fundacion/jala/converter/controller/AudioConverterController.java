/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @colaborathor Cristian Choque Quispe
 */
package org.fundacion.jala.converter.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.Asset;
import org.fundacion.jala.converter.models.facade.ConverterFacade;
import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fundacion.jala.converter.models.AssetSQL.insertAssetData;
import static org.fundacion.jala.converter.models.AssetSQL.listAsset;
import static org.fundacion.jala.converter.service.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;
import static org.fundacion.jala.converter.service.ZipService.*;

@RestController
@RequestMapping("/api")
public class AudioConverterController {
    @Autowired
    private FileStorageService fileStorageService;
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for audio converter
     */
    @PostMapping("/convertAudio")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("format") String format,
                             final @RequestParam("bitrate") String bitrate,
                             final @RequestParam("volume") String volume,
                             final @RequestParam("hz") String hz,
                             final @RequestParam("audiochannel") String audioChannel,
                             final @RequestParam("checksum") String checksum,
                             final @RequestParam("metadata") String metadata) throws IllegalStateException, IOException, InterruptedException {
        String filename;
        String storagePath;
        String checksumLocal = checksum;
        final int waitTime = 6000;
        boolean exist = false;
        final int userID = 1;
        List<Asset> assets = listAsset();
        List<String> resultTitle = getTitles(checksum, assets);
        List<String> resultPath = getPath(checksum, assets);

        exist = resultTitle.size() > 0;

        if (exist) {
            filename = resultTitle.get(0);
            storagePath = resultPath.get(0) + filename;
        } else {
            filename = file.getOriginalFilename();
            storagePath = fileStorageService.uploadFile(file);
            try {
                LOGGER.info("Execute Try");
                checksumLocal = getFileChecksum(storagePath);
                LOGGER.info("finish");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                LOGGER.error("Execute Exception" + e.getLocalizedMessage());
            }
        }
        String outputFilename= ConverterFacade.getAudioConverter(new AudioParameter(storagePath, format, bitrate, hz, volume, audioChannel));
        String outputPath = FileStorageService.getOutputPath(filename);
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        extractMetadata(metadata, outputFilename, fileStorageService);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);

        if (!(resultTitle.size() > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, userID);
        }
        if (metadata.equals("true")) {
            ArrayList<String> zipList = new ArrayList<>();
            zipList.add(pathFile + outputFilename);
            zipList.add(pathFile + nameWithoutExtension + "txt");
            Thread.sleep(waitTime);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
        } else {
            Thread.sleep(waitTime);
            zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
            System.out.println();
        }
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + nameWithoutExtension + "zip";
        return downloadLink;
    }

    private List<String> getPath(final String checksum, final List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                    .map(asset -> asset.getPath())
                    .collect(Collectors.toList());
    }

    private List<String> getTitles(final String checksum, final List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                    .map(asset -> asset.getTitle())
                    .collect(Collectors.toList());
    }
}
