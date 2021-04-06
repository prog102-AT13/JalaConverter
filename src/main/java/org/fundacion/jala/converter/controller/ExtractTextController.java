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
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.fundacion.jala.converter.service.ExtractText;


@RestController
@RequestMapping("/api")
public class ExtractTextController {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private FileStorageService fileStorageService;
    /**
     * Endpoint for extract text
     */
    @PostMapping("/extractText")
    public String uploadFile(final @RequestParam("file")MultipartFile file,
                             final @RequestParam("language") String language) throws IllegalStateException, IOException {
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
     * Endpoint for extract text
     */
    @GetMapping("/text")
    public ResponseEntity<String> extractText() {
        LOGGER.info("start");
        ExtractText extractText1 = new ExtractText("eng", "images/img1.jpg");
        extractText1.extractText();
        LOGGER.info("finish");
        return ResponseEntity.ok("Extract Complete");
    }
    /**
     * Endpoint for extract text
     */
    @GetMapping("/textInFile")
    public ResponseEntity<String> extractTextInFile() {
        LOGGER.info("start");
        ExtractText extractText2 = new ExtractText("eng", "images/img1.png", "nombre");
        extractText2.extractText();
        LOGGER.info("finish");
        return ResponseEntity.ok("Extract text and generate file Complete");
    }
}
