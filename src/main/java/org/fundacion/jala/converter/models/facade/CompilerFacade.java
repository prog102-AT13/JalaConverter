/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Rodrigo Caceres Velasco
 */
package org.fundacion.jala.converter.models.facade;

import org.fundacion.jala.converter.models.parameter.JavaParameter;
import org.fundacion.jala.converter.models.parameter.PythonParameter;
import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.PythonCompiler;

/**
 * This class calls facade of compiler.
 */
public class CompilerFacade {
    private static String result;
    private static JavaCompiler javaCompiler;
    private static PythonCompiler pythonCompiler;

    public CompilerFacade() {
    }

    /**
     * Compiles a Java project.
     *
     * @param javaParameter the version to be used in the compiler.
     * @return a string of the result on runtime console.
     */
    public static String facadeJavaCompile(final JavaParameter javaParameter) {
        javaCompiler = new JavaCompiler();
//        result = javaCompiler.javaCompiler(javaParameter);
        result = javaCompiler.projectJavaCompiler(javaParameter);
        return result;
    }

    /**
     * Compiles a Python project.
     *
     * @param pythonParameter the version to be used in the compiler.
     * @return a string of the result on runtime console.
     */
    public static String facadePythonCompile(final PythonParameter pythonParameter) {
        pythonCompiler = new PythonCompiler();
        result = pythonCompiler.compiler(pythonParameter);
        return result;
    }
}
