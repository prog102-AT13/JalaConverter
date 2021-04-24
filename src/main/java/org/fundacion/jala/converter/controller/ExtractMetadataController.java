/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.models.facade.ExtractFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ExtractMetadataController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for extract metadata
     */
    @PostMapping("/extractMetadata")
    public String uploadFile(final @RequestParam("fileToExtract") MultipartFile fileToExtract,
                             final @RequestParam("moreInfo") Boolean isMoreInfo,
                             final @RequestParam("nameExport") String nameExport,
                             final @RequestParam("format") String format) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename = ExtractFacade.getMetadataExtract(fileToExtract, isMoreInfo, nameExport, format);
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkMetadata(filename, format);
    }
}

