/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
/**
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.parameter.PythonParameter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PythonCompiler {
    private PythonParameter pythonParameter;
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * @param newPythonParameter gets all the parameters needed for Python.
     * @return the result of execution in console
     */
    public String compiler(final PythonParameter newPythonParameter) {
        LOGGER.info("start");
        try {
            this.pythonParameter = newPythonParameter;
            LOGGER.info("Execute Try");
            String command = pythonParameter.getPythonEnum().getVersion() + " " + pythonParameter.getFilePath();
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
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
        }
    }

    /**
     * Converts the code that is written as a string to a file with a python extension.
     * @param code It is a string ready to be converted
     * @return path where will be created the file
     */
    public String makePythonFile(final String code) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String fileName = "filetocompile.py";
            String path = "/archive/storage/" + fileName;
            File file = new File(System.getProperty("user.dir") + path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(code);
            bufferedWriter.close();
            LOGGER.info("finish");
            return file.getAbsolutePath();
        } catch (Exception exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return exception.getMessage();
        }
    }
}
