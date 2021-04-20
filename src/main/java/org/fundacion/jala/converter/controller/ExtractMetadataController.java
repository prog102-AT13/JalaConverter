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
import org.fundacion.jala.converter.models.facade.ExtractFacade;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
                             @RequestParam("moreInfo") Boolean isMoreInfo,
                             @RequestParam("nameExport") String nameExport,
                             @RequestParam("format") String format) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename =ExtractFacade.getMetadataExtract(fileToExtract,isMoreInfo,nameExport,format);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + filename+"."+format;
        LOGGER.info("finish");
        return downloadLink;
    }
}
