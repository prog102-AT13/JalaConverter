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
import org.fundacion.jala.converter.models.facade.CompilerFacade;
import org.fundacion.jala.converter.models.parameter.PythonEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.fundacion.jala.converter.models.parameter.PythonParameter;
import org.fundacion.jala.converter.service.PythonCompiler;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PythonCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Endpoint for compile python from a string
     */
    @PostMapping("/compilePython")
    public String compilePython(final @RequestParam("code") String code) throws IllegalStateException {
        return CompilerFacade.facadePythonCompile(code);
    }
}
