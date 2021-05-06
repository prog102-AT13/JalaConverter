/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.ChecksumException;
import org.fundacion.jala.converter.core.exceptions.PaoPaoException;
import org.fundacion.jala.converter.core.exceptions.ZipException;
import org.fundacion.jala.converter.core.facade.ChecksumFacade;
import org.fundacion.jala.converter.core.facade.ConverterFacade;
import org.fundacion.jala.converter.core.facade.ParameterOutputChecksum;
import org.fundacion.jala.converter.core.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.core.facade.ZipFileFacade;
import org.fundacion.jala.converter.core.FileStorageService;
import org.fundacion.jala.converter.core.parameter.ImageParameter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * This class calls endpoint for image.
 */
@RestController
@RequestMapping("/api")
public class ImageConverterController {
    private ParameterOutputChecksum parameterOutputChecksum;
    private static final Logger LOGGER = LogManager.getLogger();
    private FileStorageService fileStorageService = new FileStorageService();

    /**
     * Calls endpoint to convertImage.
     *
     * @param file is a path of file which will be converted.
     * @param outputFormat is the format with are converted of image.
     * @param width is the width with are converted of image.
     * @param grayScale if image has grayScale.
     * @param checksum is the checksum of image file.
     * @return a string of path to download files.
     * @throws IOException is a exception when invalid input is provided.
     * @throws InterruptedException is exception if process is interrupted.
     */
    @PostMapping("/convertImage")
    @ApiOperation(value = "Converts image file", notes = "Provide the image file to convert",
            authorizations = {@Authorization(value = "JWT")})
    public String uploadFile(final @RequestPart("file") MultipartFile file,
                             final @RequestParam("outputformat") String outputFormat,
                             final @RequestParam("width") int width,
                             final @RequestParam("grayscale") boolean grayScale,
                             final @RequestParam("checksum") String checksum)
            throws IOException, ChecksumException, ZipException {
        LOGGER.info("start");
        parameterOutputChecksum = ChecksumFacade.getChecksum(checksum, file);
        String outputFilename = null;
        try {
            outputFilename = ConverterFacade.getImageConverter(
                    new ImageParameter(parameterOutputChecksum.getOutputFilename(), outputFormat, width, grayScale));
        } catch (PaoPaoException exception) {
            exception.printStackTrace();
        }
        ZipFileFacade.getZipFileImage(parameterOutputChecksum, false, outputFilename);
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkConverter(outputFilename);
    }
}
