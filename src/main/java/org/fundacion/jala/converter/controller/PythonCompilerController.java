/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.facade.CompilerFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

/**
 * This class compiles a Python project.
 */
@RestController
@RequestMapping("/api")
public class PythonCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Creates endpoint to compile Python code.
     *
     * @param code is a String with the code to compile.
     * @return String with the compilation result.
     * @throws IllegalStateException when method invoked at an illegal time.
     * @throws IOException is a exception when invalid input is provided.
     */
    @PostMapping("/compilePython")
    public String compilePython(final @RequestParam("code") String code) throws IllegalStateException {
        return CompilerFacade.facadePythonCompile(code);
    }
}
