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
import org.fundacion.jala.converter.models.facade.ExtractFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;

/**
 * This class calls endpoint to extract metadata.
 */
@RestController
@RequestMapping("/api")
public class ExtractMetadataController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Creates endpoint to extract metadata.
     *
     * @param fileToExtract is a file to extract.
     * @param isMoreInfo is more information about the file.
     * @param nameExport is a name of file to export.
     * @param format is the format to file.
     * @return path to download files.
     * @throws IllegalStateException is a exception if process is Illegal.
     * @throws IOException is a exception when invalid input is provided.
     */
    @PostMapping("/extractMetadata")
    public String uploadFile(final @RequestParam("fileToExtract") MultipartFile fileToExtract,
                             final @RequestParam("moreInfo") Boolean isMoreInfo,
                             final @RequestParam("nameExport") String nameExport,
                             final @RequestParam("format") String format) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename = ExtractFacade.getMetadataExtract(fileToExtract, isMoreInfo, nameExport, format);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + filename + "." + format;
        LOGGER.info("finish");
        return downloadLink;
    }
}
