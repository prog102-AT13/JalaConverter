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
package org.fundacion.jala.converter.core.javacompiler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.parameter.JavaParameter;
import org.fundacion.jala.converter.core.results.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class compiles a java file.
 */
public class JavaCompiler {
    private BufferedReader bufferedReader;
    private JavaParameter javaParameter;
    private Result result;

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Compiles a java file.
     *
     * @param newJavaParameter for all the parameters needed for Java Compiler.
     * @return the result of execution in console.
     */
    public String javaCompiler(final JavaParameter newJavaParameter) {
        LOGGER.info("start");
        try {
            javaParameter = newJavaParameter;
            LOGGER.info("Execute Try");
            String command = javaParameter.getJavaVersion().getCompiler() + " " + "\""
                    + javaParameter.getFilePath() + "\" " + "&& "
                    + javaParameter.getJavaVersion().getExecutor() + " "
                    + "\"" + javaParameter.getFilePath() + "\"";
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while ((resultOfExecution = bufferedReader.readLine()) != null) {
                result += resultOfExecution + "\n";
            }
            this.result = new Result();
            this.result.setTextContent(result);
            LOGGER.info("finish");
            return result;
        } catch (IOException exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return exception.getMessage();
        } finally {
            try {
                LOGGER.info("Close bufferedReader Stream");
                bufferedReader.close();
            } catch (IOException e) {
                LOGGER.error("Close Stream error" + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Returns the result object for the operation.
     *
     * @return compilerResult
     */
    public Result getResult() {
        return result;
    }
}