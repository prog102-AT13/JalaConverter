/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.service.AudioConverter;
import org.fundacion.jala.converter.service.ExtractMetadata;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;

import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;

@RestController
@RequestMapping("/api")
public class AudioConverterController {
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    AudioConverter audioConverter;

    /**
     * Endpoint for audio converter
     */
    @PostMapping("/convertAudio")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("format") String format,
                             @RequestParam("bitrate") String bitrate,
                             @RequestParam("volume") String volume,
                             @RequestParam("hz") String hz,
                             @RequestParam("audiochannel") String audioChannel,
                             @RequestParam("metadata") String metadata) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        AudioConverter audio = new AudioConverter(format, bitrate, hz, volume, audioChannel);
        audio.audioConverter(storagePath);
        String outputFilename = audio.getOutputFileName();
        extractMetadata(metadata, outputFilename, fileStorageService);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + outputFilename;
        return downloadLink;
    }
}
