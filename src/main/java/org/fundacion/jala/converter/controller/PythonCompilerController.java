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
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.pythoncompiler.Python;
import org.fundacion.jala.converter.service.pythoncompiler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PythonCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    /**
     * Endpoint for compile python
     */
    @PostMapping("/compilePython")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("version") String version) throws IllegalStateException, IOException {
        LOGGER.info("start");
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        storagePath = "\"" + storagePath + "\"";
        PythonCompiler pythonCompiler = new PythonCompiler();
        LOGGER.info("finish");
        return pythonCompiler.compiler(Python.V3, storagePath);
    }

    /**
     * Endpoint for proving compile python
     */
    @GetMapping("/compilePython2")
    public String uploadFile2() {
        PythonCompiler pythonCompiler = new PythonCompiler();
        return pythonCompiler.compiler(Python.V3, System.getProperty("user.dir") + "/archive/helloworld.py");
    }
}
