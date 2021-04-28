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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.PaoPaoException;
import org.fundacion.jala.converter.core.parameter.JavaParameter;
import org.fundacion.jala.converter.core.facade.CompilerFacade;
import org.fundacion.jala.converter.core.javacompiler.JavaVersion;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

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
     * @throws IllegalStateException when method invoked at an illegal time.
     * @throws IOException is a exception when invalid input is provided.
     */
    @PostMapping("/compileJava")
    public String compileJava(final @RequestParam("code") String code) throws IllegalStateException, IOException {
        LOGGER.info("start");
        if (!code.isBlank() || !code.equals(null)) {
            String filePath = Transform.toFile(code, "Main", "java");
            LOGGER.info("finish");
            try {
                return CompilerFacade.facadeJavaCompile(new JavaParameter(JavaVersion.JAVA_11, filePath));
            } catch (PaoPaoException exception) {
                exception.printStackTrace();
            }
        }
        return "";
    }
}
