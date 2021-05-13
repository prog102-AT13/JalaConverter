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
import org.fundacion.jala.converter.core.exceptions.CompilerException;
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
     * @throws CompilerException if process is interrupted.
     */
    public String javaCompiler(final JavaParameter newJavaParameter) throws CompilerException {
        LOGGER.info("start");
        javaParameter = newJavaParameter;
        LOGGER.info("Execute Try");
        String commandCompile = "";
        String commandExecute = "";
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            commandCompile = javaParameter.getJavaVersion().getCompiler() + " "
                    + javaParameter.getFilePath();
            commandExecute = javaParameter.getJavaVersion().getExecutor() + " "
                    + javaParameter.getFilePath();
        } else {
            commandCompile = "sudo " + javaParameter.getJavaVersion().getCompiler() + " "
                    + javaParameter.getFilePath();
            commandExecute ="sudo " + javaParameter.getJavaVersion().getExecutor() + " "
                    + javaParameter.getFilePath();
        }
        System.out.println(commandCompile);
        System.out.println(commandExecute);
        try {
            Process process = Runtime.getRuntime().exec(commandCompile);;
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        } catch (IOException exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return String.valueOf(new CompilerException(exception));
        } finally {
            try {
                LOGGER.info("Close bufferedReader Stream");
                bufferedReader.close();
            } catch (IOException exception) {
                LOGGER.error("Close Stream error" + exception.getLocalizedMessage());
                throw new CompilerException(exception);
            }
        }
        try {
            Process process = Runtime.getRuntime().exec(commandExecute);;
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
            return String.valueOf(new CompilerException(exception));
        } finally {
            try {
                LOGGER.info("Close bufferedReader Stream");
                bufferedReader.close();
            } catch (IOException exception) {
                LOGGER.error("Close Stream error" + exception.getLocalizedMessage());
                throw new CompilerException(exception);
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

    /**
     * Compiles a java project.
     *
     * @param newJavaParameter for all the parameters needed for Java Compiler.
     * @return the result of execution in console.
     */
    public String javaProjectCompiler(final JavaParameter newJavaParameter) {
        LOGGER.info("start");
        final String JAVA_COMPILER = newJavaParameter.getJavaVersion().getCompiler();
        final String JAVA_EXE = newJavaParameter.getJavaVersion().getExecutor();
        try {
            javaParameter = newJavaParameter;
            LOGGER.info("Execute Try");
            String command = "cd " + javaParameter.getFilePath() + " && " + JAVA_COMPILER
                    + " Main.java && " + JAVA_EXE + " Main";
            ProcessBuilder processBuilder = null;
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("windows")) {
                processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            } else {
                processBuilder = new ProcessBuilder("bash", "-c", command);
            }
            Process process = processBuilder.start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while ((resultOfExecution = bufferedReader.readLine()) != null) {
                result += resultOfExecution + "\n";
            }
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
}