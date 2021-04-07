/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.javacompiler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCompiler {
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * @param javaVersion has the commands according to java version
     * @param filePath represents the path of the file to compile
     * @return the result of execution in console
     */
    public String javaCompiler(final JavaVersion javaVersion, final String filePath){
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String command = javaVersion.getCompiler() + " " + filePath + "&&" + javaVersion.getExecutor() + " " + filePath;
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while((resultOfExecution = bufferedReader.readLine()) != null){
                result += resultOfExecution + "\n";
            }
            LOGGER.info("finish");
            return result;
        } catch (IOException exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return exception.getMessage();
        }
    }
}
