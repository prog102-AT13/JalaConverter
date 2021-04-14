/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.AudioConverter;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;

@RestController
@RequestMapping("/api")
public class AudioConverterController {
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private AudioConverter audioConverter;

    /**
     * Endpoint for audio converter
     */
    @PostMapping("/convertAudio")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("format") String format,
                             final @RequestParam("bitrate") String bitrate,
                             final @RequestParam("volume") String volume,
                             final @RequestParam("hz") String hz,
                             final @RequestParam("audiochannel") String audioChannel,
                             final @RequestParam("metadata") String metadata) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        audioConverter = new AudioConverter(new AudioParameter(storagePath, format, bitrate, hz, volume, audioChannel));
        audioConverter.audioConverter(storagePath);
        String outputFilename = audioConverter.getOutputFileName();
        extractMetadata(metadata, outputFilename, fileStorageService);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + outputFilename;
        return downloadLink;
    }
}
