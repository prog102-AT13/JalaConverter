/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("metadataCLASS") boolean metadata) throws IllegalStateException, IOException {
        //fileUploadService.uploadFile(file);
        file.transferTo(new File("G:\\Files\\VideoUploads\\" + file.getOriginalFilename()));
        return "uploaded";
    }
}
