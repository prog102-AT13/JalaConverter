/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.javacompiler.JavaVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class JavaCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    FileStorageService fileStorageService;

    /**
     * Endpoint for compile java
     */
    @PostMapping("/compileJava")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("version") String version) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        JavaCompiler javaCompiler = new JavaCompiler();
        LOGGER.info("finish");
        return javaCompiler.javaCompiler(JavaVersion.JAVA_11, storagePath);
    }
}
