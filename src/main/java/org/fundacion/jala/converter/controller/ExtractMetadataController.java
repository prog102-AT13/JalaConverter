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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.PaoPaoException;
import org.fundacion.jala.converter.core.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.core.facade.ExtractFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
     * @return a string of path to download files.
     */
    @PostMapping("/extractMetadata")
    @ApiOperation(value = "Extracts a file's metadata", notes = "Provide the file to extract its metadata",
            authorizations = {@Authorization(value = "JWT")})
    public String uploadFile(final @RequestPart("fileToExtract") MultipartFile fileToExtract,
                             final @RequestParam("moreInfo") Boolean isMoreInfo,
                             final @RequestParam("nameExport") String nameExport,
                             final @RequestParam("format") String format) {
        LOGGER.info("start");
        String filename = null;
        try {
            filename = ExtractFacade.getMetadataExtract(fileToExtract, isMoreInfo, nameExport, format);
        } catch (PaoPaoException exception) {
            return exception.getMessage();
        }
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkMetadata(filename, format);
    }
}
