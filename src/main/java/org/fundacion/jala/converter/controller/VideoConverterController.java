/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;

@RestController
@RequestMapping("/api")
public class VideoConverterController {
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    VideoParameter videoParameter;
    @Autowired
    Converter converter;

    /**
     * Endpoint for convertVideo
     */
    @PostMapping("/convertVideo")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("outputformat") String outputFormat,
                             @RequestParam("resolution") String resolution,
                             @RequestParam("tumbnail") boolean tumbnail,
                             @RequestParam("framerate") int frameRate,
                             @RequestParam("width") int width,
                             @RequestParam("height") int height,
                             @RequestParam("audio") boolean audio,
                             @RequestParam("metadata") String metadata
    ) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        videoParameter.setOutputFormat(outputFormat);
        videoParameter.setResolution(resolution);
        videoParameter.setTumbnail(tumbnail);
        videoParameter.setFrameRate(frameRate);
        videoParameter.setWidth(width);
        videoParameter.setHeight(height);
        videoParameter.setAudio(audio);
        converter.convertVideo(storagePath);
        String outputPath = FileStorageService.getOutputPath(filename);
        String outputFilename = converter.getOutputFileName();
        extractMetadata(metadata, outputFilename, fileStorageService);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + converter.getOutputFileName();
        return downloadLink;
    }
}
