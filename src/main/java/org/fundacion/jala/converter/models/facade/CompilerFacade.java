/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Caceres Velasco
 * * @version 1.0
 */
package org.fundacion.jala.converter.models.facade;

import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.javacompiler.JavaVersion;
import org.fundacion.jala.converter.service.pythoncompiler.PythonCompiler;
import org.fundacion.jala.converter.service.pythoncompiler.Python;

public class CompilerFacade {

    private static String result;
    private static JavaCompiler javaCompiler;
    private static PythonCompiler pythonCompiler;

    public CompilerFacade() {
    }

    /**
     * The method to convert Audio.
     *
     * @param javaVersion the version to be used in the compiler.
     * @param filePath    is the path of file to convert.
     * @return a string of the result on runtime console.
     */
    public static String facadeJavaCompile(final JavaVersion javaVersion, final String filePath) {
        javaCompiler = new JavaCompiler();
        result = javaCompiler.javaCompiler(javaVersion, filePath);
        return result;
    }

    /**
     * The method to convert Audio.
     *
     * @param pythonVersion the version to be used in the compiler.
     * @param filePath      is the path of file to convert.
     * @return a string of the result on runtime console.
     */
    public String facadePythonCompile(final Python pythonVersion, final String filePath) {
        pythonCompiler = new PythonCompiler();
        result = pythonCompiler.compiler(pythonVersion, filePath);
        return result;
    }

}
