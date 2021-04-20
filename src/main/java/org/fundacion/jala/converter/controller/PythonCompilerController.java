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
import org.fundacion.jala.converter.facade.CompilerFacade;
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

    /**
     * Endpoint for compile python from a string
     */
    @PostMapping("/compilePython")
    public String compilePython(final @RequestParam("code") String code) throws IllegalStateException, IOException {
        LOGGER.info("start");
        if (!code.isBlank() || !code.equals(null)){
//            PythonCompiler pythonCompiler = new PythonCompiler();
            CompilerFacade python = new CompilerFacade();
            String filePath = Transform.toFile(code, "filetocompile", "py");
            LOGGER.info("finish");
            return python.facadePythonCompile(Python.V3, filePath);
//            return pythonCompiler.compiler(Python.V3, filePath);
        }
        return "";
    }
}
