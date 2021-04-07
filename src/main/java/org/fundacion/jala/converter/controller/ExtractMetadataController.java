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
import org.fundacion.jala.converter.service.metadata.TypeFileExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        String outputPath = FileStorageService.getOutputPath(filename);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" +  filename;
        LOGGER.info("finish");
        return downloadLink;
    }

    /**
     * Endpoint for extract metadata
     */
    @GetMapping("/metadata")
    public ResponseEntity<String> extractMetadataDefaultName() {

        LOGGER.info("start");
        File file=new File("Images/img7.jpg");
        ExtractMetadata extractMetadata = new ExtractMetadata(file);
        extractMetadata.extractMetadata();
        LOGGER.info("finish");
        return ResponseEntity.ok("Extract metadata Complete");
    }

    /**
     * Endpoint for extract metadata
     */
    @GetMapping("/metadataMoreOption")
    public ResponseEntity<String> extractMetadata() {
        LOGGER.info("start");
        File file=new File("Images/img7.jpg");
        ObjectMetadata objectMetadata=new ObjectMetadata();
        objectMetadata.setFile(file);
        objectMetadata.setMoreInfo(true);
        objectMetadata.setNameExport("ImangenTest");
        objectMetadata.setTypeFileExport(TypeFileExport.TXT);
        ExtractMetadata extractMetadata = new ExtractMetadata(objectMetadata);
        extractMetadata.extractMetadata();
        LOGGER.info("finish");
        return ResponseEntity.ok("Extract metadata Complete");
    }
}
