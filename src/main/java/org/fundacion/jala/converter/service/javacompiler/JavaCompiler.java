/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jessicka Moya Andrade
 */
package org.fundacion.jala.converter.service.javacompiler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.parameter.JavaParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class compiles a java file.
 */
public class JavaCompiler {
    private BufferedReader bufferedReader;
    private JavaParameter javaParameter;
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
            System.out.println("COMANDO JAVA " + command);
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
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

    /**
     * Compiles a java file.
     *
     * @param newJavaParameter for all the parameters needed for Java Compiler.
     * @return the result of execution in console.
     */
    public String projectJavaCompiler(final JavaParameter newJavaParameter) {
        LOGGER.info("start");
//        final String JAVA_COMPILER = System.getProperty("user.dir") + "\\thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\javac.exe";
        final String JAVA_COMPILER = System.getProperty("user.dir") + "\\" + newJavaParameter.getJavaVersion().getCompiler();
//        final String JAVA_EXE = System.getProperty("user.dir") + "\\thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\java.exe";
        final String JAVA_EXE = System.getProperty("user.dir") + "\\" + newJavaParameter.getJavaVersion().getExecutor();
//        System.out.println("USER DIR " + System.getProperty("user.dir"));
//        System.out.println("RUTA DEL THIRDPARTY COMPILER" + newJavaParameter.getJavaVersion().getCompiler());
//        System.out.println("RUTA DEL THIRDPARTY EXECUTOR" + newJavaParameter.getJavaVersion().getExecutor());
        try {
            javaParameter = newJavaParameter;
            LOGGER.info("Execute Try");
            String comnand = "cd " + javaParameter.getFilePath() + " && " + JAVA_COMPILER + " Main.java && " + JAVA_EXE + " Main";
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", comnand);
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