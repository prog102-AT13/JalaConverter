/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * This class converts a String to a file.
 */
public class Transform {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Converts the code that is written as a string to a file with a python extension.
     *
     * @param code is a string ready to be converted.
     * @param fileName is the name of the file converted.
     * @param extension is python extension.
     * @return path where will be created the file.
     */
    public static String toFile(final String code, final String fileName, final String extension) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String path = "/archive/storage/" + fileName + "." + extension;
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

    /**
     * Converts the code that is written as a string to a file with a python extension.
     *
     * @param code It is a string ready to be converted
     * @return path where will be created the file
     */
    public static String createFile(final String code, final String fileName, final String extension,
                                    final String pathProject) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String path = pathProject + System.getProperty("file.separator") + fileName + "." + extension;
            File file = new File(path);
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
