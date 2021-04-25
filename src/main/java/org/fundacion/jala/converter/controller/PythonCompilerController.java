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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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
    @ApiOperation(value = "Compiles python code", notes = "Provide the code to compile",
            authorizations = {@Authorization(value = "JWT")})
    public String compilePython(final @RequestParam("code") String code) throws IllegalStateException, IOException {
        LOGGER.info("start");
        if (!code.isBlank() || !code.equals(null)) {
            PythonCompiler pythonCompiler = new PythonCompiler();
            String filePath = Transform.toFile(code, "filetocompile", "py");
            LOGGER.info("finish");
            return CompilerFacade.facadePythonCompile(new PythonParameter(filePath, PythonEnum.V3));
        }
        return "";
    }
}
