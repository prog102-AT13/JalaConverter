/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jessicka Moya Andrade
 */
package org.fundacion.jala.converter.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.PaoPaoException;
import org.fundacion.jala.converter.core.facade.CompilerFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class compiles a Java project.
 */
@RestController
@RequestMapping("/api")
public class JavaCompilerController {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Creates endpoint to compile java code.
     *
     * @param code is a String with the code to compile.
     * @return String with the compilation result.
     */
    @PostMapping("/compileJava")
    @ApiOperation(value = "Compiles java code", notes = "Provide the java code to compile",
            authorizations = {@Authorization(value = "JWT")})
    public String compileJava(final @RequestParam("code") String code) {
        try {
            return CompilerFacade.facadeJavaCompile(code);
        } catch (PaoPaoException exception) {
            return exception.getMessage();
        }
    }
}
