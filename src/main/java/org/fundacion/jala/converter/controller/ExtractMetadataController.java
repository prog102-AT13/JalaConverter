/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.service.ExtractMetadata;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ExtractMetadataController {
    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    FileStorageService fileStorageService;

    /**
     * Endpoint for extract metadata
     */
    @PostMapping("/extractMetadata")
    public String uploadFile(@RequestParam("fileToExtract") String fileToExtract,
                             @RequestParam("fileToExport") String fileToExport) throws IllegalStateException, IOException {
        LOGGER.info("start");
        ExtractMetadata extractMetadata = new ExtractMetadata(new File(fileToExtract), new File(fileToExport));
        extractMetadata.extractMetadata();
        File file = new File(fileToExtract);
        String filename = file.getName();
        String storagePath = filename;
        String outputPath = FileStorageService.getOutputPath(filename);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + filename;
        LOGGER.info("finish");
        return downloadLink;
    }

    /**
     * Endpoint for extract metadata
     */
    @PostMapping("/extractMetadataMoreOption")
    public String uploadFile(@RequestParam("fileToExtract") String fileToExtract,
                             @RequestParam("fileToExport") String fileToExport,
                             @RequestParam("MoreInfo") Boolean isMoreInfo,
                             @RequestParam("NameExport") String nameExport) throws IllegalStateException, IOException {
        LOGGER.info("start");
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setFileToExtract(new File(fileToExtract));
        objectMetadata.setFileToExport(new File(fileToExport));
        objectMetadata.setMoreInfo(isMoreInfo);
        objectMetadata.setNameExport(nameExport);
        ExtractMetadata extractMetadata = new ExtractMetadata(objectMetadata);
        extractMetadata.extractMetadata();
        File file = new File(fileToExtract);
        String filename = file.getName();
        String storagePath = filename;
        String outputPath = FileStorageService.getOutputPath(filename);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + filename;
        LOGGER.info("finish");
        return downloadLink;
    }
}
