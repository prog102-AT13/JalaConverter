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
package org.fundacion.jala.converter.service.pythoncompiler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class PythonCompiler {
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * @param compilerVersion has command according version
     * @param filePath represents what file we want to compile
     * @return the result of execution in console
     */
    public String compiler(final Python compilerVersion, final String filePath) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String command = compilerVersion.getVersion() + " " + filePath;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReaderr = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while ((resultOfExecution = bufferedReaderr.readLine()) != null) {
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
     * Converts the code that is written as a string to a file with a python extension
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
