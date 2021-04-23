/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.facade.ChecksumFacade;
import org.fundacion.jala.converter.models.facade.ConverterFacade;
import org.fundacion.jala.converter.models.facade.ParameterOutputChecksum;
import org.fundacion.jala.converter.models.facade.ZipFileFacade;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.models.parameter.VideoParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;

/**
 * Calls endpoint for video.
 */
@RestController
@RequestMapping("/api")
public class VideoConverterController {
    @Autowired
    private FileStorageService fileStorageService;
    private static final Logger LOGGER = LogManager.getLogger();
    private ParameterOutputChecksum parameterOutputChecksum;

    /**
     * Calls endpoint for convertVideo.
     */
    @PostMapping("/convertVideo")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("outputformat") String outputFormat,
                             final @RequestParam("resolution") String resolution,
                             final @RequestParam("thumbnail") boolean thumbnail,
                             final @RequestParam("framerate") int frameRate, final @RequestParam("width") int width,
                             final @RequestParam("height") int height, final @RequestParam("audio") boolean audio,
                             final @RequestParam("checksum") String checksum,
                             final @RequestParam("metadata") String metadata)
            throws IllegalStateException, IOException, InterruptedException {
        parameterOutputChecksum = ChecksumFacade.getChecksum(checksum, file);
        String outputFilename = ConverterFacade.getVideoConverter(
                new VideoParameter(parameterOutputChecksum.getOutputFilename(), outputFormat, resolution, thumbnail,
                        frameRate, width, height, audio));
        extractMetadata(metadata, outputFilename, fileStorageService);
        ZipFileFacade.getZipFileVideo(parameterOutputChecksum, metadata, thumbnail, outputFilename);
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + nameWithoutExtension + "zip";
        return downloadLink;
    }
}
