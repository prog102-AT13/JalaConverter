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
import org.fundacion.jala.converter.service.pythoncompiler.Python;
import org.fundacion.jala.converter.service.pythoncompiler.PythonCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class JavaCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for compile java
     */
    @PostMapping("/compileJava")
    public String compileJava2(final @RequestParam("code") String code) throws IllegalStateException, IOException {
        LOGGER.info("start");
        if (!code.isBlank() || !code.equals(null)){
            JavaCompiler javaCompiler = new JavaCompiler();
            String filePath = Transform.toFile(code, "Main", "java");
            LOGGER.info("finish");
            return javaCompiler.javaCompiler(JavaVersion.JAVA_11, filePath);
        }
        return "";
    }
}
