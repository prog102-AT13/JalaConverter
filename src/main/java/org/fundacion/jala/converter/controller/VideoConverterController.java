/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz
 * @colaborathor Paola Aguilar
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.Asset;
import org.fundacion.jala.converter.models.facade.ConverterFacade;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.models.parameter.VideoParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import static org.fundacion.jala.converter.service.ZipService.zipFile;
import static org.fundacion.jala.converter.service.ZipService.zipFiles;

@RestController
@RequestMapping("/api")
public class VideoConverterController {
    @Autowired
    private FileStorageService fileStorageService;
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for convertVideo
     */
    @PostMapping("/convertVideo")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("outputformat") String outputFormat,
                             final @RequestParam("resolution") String resolution,
                             final @RequestParam("thumbnail") boolean thumbnail,
                             final @RequestParam("framerate") int frameRate,
                             final @RequestParam("width") int width,
                             final @RequestParam("height") int height,
                             final @RequestParam("audio") boolean audio,
                             final @RequestParam("checksum") String checksum,
                             final @RequestParam("metadata") String metadata
    ) throws IllegalStateException, IOException, InterruptedException {
        final int waitTime = 6000;
        String filename;
        String storagePath;
        String checksumLocal = checksum;
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
        String outputFilename = ConverterFacade.getVideoConverter(new VideoParameter(storagePath, outputFormat,
                resolution, thumbnail, frameRate, width, height, audio));
        extractMetadata(metadata, outputFilename, fileStorageService);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        if (!(resultTitle.size() > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, userID);
        }
        if (metadata.equals("true") || thumbnail) {
            ArrayList<String> zipList = new ArrayList<>();
            zipList.add(pathFile + outputFilename);
            if (metadata.equals("true")) {
                zipList.add(pathFile + nameWithoutExtension + "txt");
            }
            if (thumbnail) {
                zipList.add(pathFile + nameWithoutExtension + "png");
            }
            Thread.sleep(waitTime);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
        } else {
            Thread.sleep(waitTime);
            zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
        }
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + nameWithoutExtension + "zip";
        return downloadLink;
    }

    /**
     * Obtains the path of the file
     * @param checksum
     * @param assets
     * @return
     */
    private List<String> getPath(final String checksum, final List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                .map(asset -> asset.getPath())
                .collect(Collectors.toList());
    }

    /**
     * Obtains the name of the file
     * @param checksum
     * @param assets
     * @return
     */
    private List<String> getTitles(final String checksum, final List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                .map(asset -> asset.getTitle())
                .collect(Collectors.toList());
    }
}
