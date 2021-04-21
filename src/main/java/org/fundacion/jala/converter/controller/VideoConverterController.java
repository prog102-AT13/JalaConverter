/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz
 * @colaborathor Paola Aguilar
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.models.facade.ConverterFacade;
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

@RestController
@RequestMapping("/api")
public class VideoConverterController {
    @Autowired
    private FileStorageService fileStorageService;

    /**
     * Endpoint for convertVideo
     */
    @PostMapping("/convertVideo")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("outputformat") String outputFormat,
                             final @RequestParam("resolution") String resolution,
                             final @RequestParam("thumbnail") boolean thumbnail,
                             final @RequestParam("framerate") int frameRate,
                             final @RequestParam("width") int width,
                             final @RequestParam("height") int height,
                             final @RequestParam("audio") boolean audio,
                             final @RequestParam("metadata") String metadata
    ) throws IllegalStateException, IOException {
        String outputFilename = ConverterFacade.getVideoConverter(new VideoParameter(fileStorageService
                .uploadFile(file), outputFormat,
                resolution, thumbnail, frameRate, width, height, audio));
        extractMetadata(metadata, outputFilename, fileStorageService);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + "converter.getOutputFileName()";
        return downloadLink;
    }
}
