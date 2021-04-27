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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.core.facade.ExtractFacade;
import org.fundacion.jala.converter.core.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

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
     * @return path to download files.
     * @throws IllegalStateException is a exception if process is Illegal.
     * @throws IOException is a exception when invalid input is provided.
     */
    @PostMapping("/extractText")
    public String extractText(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("language") String language) throws IllegalStateException, IOException {
        LOGGER.info("start");
        ExtractFacade.getTextExtract(file,language);
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkExtractText(file);
    }
}
