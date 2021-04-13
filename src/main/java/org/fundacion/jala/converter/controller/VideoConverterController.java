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
//import static org.fundacion.jala.converter.models.Insert.insertData;

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
                             @RequestParam("tumbnail") String tumbnail,
                             @RequestParam("framerate") String frameRate,
                             @RequestParam("width") String width,
                             @RequestParam("height") String height,
                             @RequestParam("audio") String audio,
                             @RequestParam("metadata") String metaData
    ) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
//        videoParameter.setOutputFormat(outputFormat);
//        videoParameter.setResolution(resolution);
//        videoParameter.setTumbnail(tumbnail);
//        videoParameter.setFrameRate(frameRate);
//        videoParameter.setWidth(width);
//        videoParameter.setHeight(height);
//        videoParameter.setAudio(audio);
//        videoParameter.setMetaData(metaData);
//        converter.convertVideo(storagePath);

        //--------------------------------
//        insertData(Integer.parseInt(audio), outputFormat, resolution, tumbnail, Integer.parseInt(metaData), width, frameRate, height);
//        insertData(7, "Pablo Perez", "pasword1", "token1", 4, "Project1", "/folder1/folder2/", "movie");

        //--------------------------------




        String outputPath = FileStorageService.getOutputPath(filename);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String downloadLink = baseUrl + "/api/download/" + "converter.getOutputFileName()";
        return downloadLink;
    }
}
