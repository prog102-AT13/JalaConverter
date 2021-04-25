/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Caceres Velasco
 * * @version 1.0
 */
package org.fundacion.jala.converter.models.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.controller.Transform;
import org.fundacion.jala.converter.models.parameter.JavaParameter;
import org.fundacion.jala.converter.models.parameter.PythonEnum;
import org.fundacion.jala.converter.models.parameter.PythonParameter;
import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.PythonCompiler;
import org.fundacion.jala.converter.service.javacompiler.JavaVersion;

/**
 * Class to do and call facade of compiler.
 */
public class CompilerFacade {

    private static JavaCompiler javaCompiler;
    private static PythonCompiler pythonCompiler;
    public CompilerFacade() {
    }

    /**
     * Compiles a Java project.
     *
     * @param code is string with code in jva.
     * @return a string of the result on runtime console.
     */
    public static String facadeJavaCompile(final String code) {
        if (!code.isBlank() || !code.equals(null)) {
            javaCompiler = new JavaCompiler();
            String filePath = Transform.toFile(code, "Main", "java");
            return javaCompiler.javaCompiler(new JavaParameter(JavaVersion.JAVA_11, filePath));
        }
        return "";
    }

    /**
     * Compiles a Python project.
     *
     * @param code is string with code in Python.
     * @return a string of the result on runtime console.
     */
    public static String facadePythonCompile(final String code) {
        if (!code.isBlank() || !code.equals(null)) {
            pythonCompiler=new PythonCompiler();
            String filePath = Transform.toFile(code, "filetocompile", "py");
            return pythonCompiler.compiler(new PythonParameter(filePath, PythonEnum.V3));
        }
        return "";
    }
}
