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
import org.fundacion.jala.converter.models.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.service.ExtractText;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;

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
        String fileOut = file.getOriginalFilename();
        String outputFileName = fileOut.substring(0, fileOut.lastIndexOf("."));
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        ExtractText extractText = new ExtractText(new ExtractTextParameter(storagePath, language, outputFileName));
        extractText.extractText();
        String outputPath = FileStorageService.getOutputPath(filename);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String outFilename = outputFileName + ".txt";
        String downloadLink = baseUrl + "/api/download/" + outFilename;
        LOGGER.info("finish");
        return downloadLink;
    }
}
