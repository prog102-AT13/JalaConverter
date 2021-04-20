/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.Asset;
import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.AudioConverter;
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
    @Autowired
    private AudioConverter audioConverter;
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for audio converter
     */
    @PostMapping("/convertAudio")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("format") String format,
                             @RequestParam("bitrate") String bitrate,
                             @RequestParam("volume") String volume,
                             @RequestParam("hz") String hz,
                             @RequestParam("audiochannel") String audioChannel,
                             @RequestParam("checksum") String checksum,
                             @RequestParam("metadata") String metadata) throws IllegalStateException, IOException, InterruptedException {
        String filename;
        String storagePath;
//        checksum = "6ca5290ffb6fcb298b89d3d1efe3009e";
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println(format);
        System.out.println(bitrate);
        System.out.println(volume);
        System.out.println(hz);
        System.out.println(audioChannel);
        System.out.println(checksum);
        System.out.println(metadata);
        String checksumLocal = checksum;
        final int WAIT_TIME = 6000;
        boolean exist = false;
        final int USER_ID = 2;
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


        audioConverter = new AudioConverter(new AudioParameter(storagePath, format, bitrate, hz, volume, audioChannel));
        audioConverter.audioConverter(storagePath);
        String outputFilename = audioConverter.getOutputFileName();
        String outputPath = FileStorageService.getOutputPath(filename);
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        extractMetadata(metadata, outputFilename, fileStorageService);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);

        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("***************************************************");
        System.out.println("output fila name : " + outputFilename);
        System.out.println("output path : " + outputPath);
        System.out.println("name without extension : " + nameWithoutExtension);
        System.out.println("path file : " + pathFile);

        if (!(resultTitle.size() > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, USER_ID);
        }
        if (metadata.equals("true")) {
            ArrayList<String> zipList = new ArrayList<>();
            zipList.add(pathFile + outputFilename);
            zipList.add(pathFile + nameWithoutExtension + "txt");
            Thread.sleep(WAIT_TIME);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
        } else {
            Thread.sleep(WAIT_TIME);
            zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
            System.out.println();
        }
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + nameWithoutExtension + "zip";
        System.out.println("**********************");
        System.out.println(downloadLink);
        return downloadLink;
    }

    private List<String> getPath(String checksum, List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                    .map(asset -> asset.getPath())
                    .collect(Collectors.toList());
    }

    private List<String> getTitles(String checksum, List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum))
                    .map(asset -> asset.getTitle())
                    .collect(Collectors.toList());
    }
}
