/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */
package org.fundacion.jala.converter.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.PaoPaoException;
import org.fundacion.jala.converter.core.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.core.facade.ExtractFacade;
import org.fundacion.jala.converter.core.FileStorageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class extracts the text from an image.
 */
@RestController
@RequestMapping("/api")
public class ExtractTextController {
    private static final Logger LOGGER = LogManager.getLogger();
    private FileStorageService fileStorageService = new FileStorageService();

    /**
     * Creates endpoint to extract text.
     *
     * @param file is image file to extract text.
     * @param language is a type of language of the text.
     * @return a string of path to download files.
     */
    @PostMapping(value = "/extractText")
    @ApiOperation(value = "Extracts text from an image", notes = "Provide the image to extract its text",
            authorizations = {@Authorization(value = "JWT")})
    public String uploadFile(final @RequestPart("file") MultipartFile file,
                             final @RequestParam("language") String language) {
        LOGGER.info("start");
        try {
            ExtractFacade.getTextExtract(file, language);
        } catch (PaoPaoException exception) {
            return exception.getMessage();
        }
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkExtractText(file);
    }
}
