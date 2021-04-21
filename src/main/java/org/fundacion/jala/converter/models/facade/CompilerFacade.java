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

import org.fundacion.jala.converter.models.parameter.JavaParameter;
import org.fundacion.jala.converter.models.parameter.PythonParameter;
import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.javacompiler.JavaVersion;
import org.fundacion.jala.converter.service.PythonCompiler;
import org.fundacion.jala.converter.models.parameter.PythonEnum;

public class CompilerFacade {

    private static String result;
    private static JavaCompiler javaCompiler;
    private static PythonCompiler pythonCompiler;

    public CompilerFacade() {
    }

    /**
     * The method to convert Audio.
     *
     * @param javaParameter the version to be used in the compiler.
     * @return a string of the result on runtime console.
     */
    public static String facadeJavaCompile(JavaParameter javaParameter) {
        javaCompiler = new JavaCompiler();
        result = javaCompiler.javaCompiler(javaParameter);
        return result;
    }

    /**
     * The method to convert Audio.
     *
     * @param pythonParameter the version to be used in the compiler.
     * @return a string of the result on runtime console.
     */
    public static String facadePythonCompile(PythonParameter pythonParameter) {
        pythonCompiler = new PythonCompiler();
        result = pythonCompiler.compiler(pythonParameter);
        return result;
    }

}