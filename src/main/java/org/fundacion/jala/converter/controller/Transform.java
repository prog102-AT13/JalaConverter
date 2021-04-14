package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Transform {
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * Converts the code that is written as a string to a file with a python extension
     * @param code It is a string ready to be converted
     * @return path where will be created the file
     */
    public static String toFile(final String code) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String fileName = "filetocompile.py";
            String path = "/archive/storage/" + fileName;
            File file = new File(System.getProperty("user.dir") + path);
            System.out.println(file.getAbsoluteFile());
            System.out.println("======================");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(code);
            bufferedWriter.close();
            LOGGER.info("finish");
            System.out.println(file.getAbsoluteFile());
            return file.getAbsolutePath();
        } catch (Exception exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return exception.getMessage();
        }
    }

    /**
     * Converts the code that is written as a string to a file with a python extension
     * @param code It is a string ready to be converted
     * @return path where will be created the file
     */
    public static String toFile2(final String code) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String fileName = "Main.java";
            String path = "/archive/storage/" + fileName;
            File file = new File(System.getProperty("user.dir") + path);
            System.out.println(file.getAbsoluteFile());
            System.out.println("======================");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(code);
            bufferedWriter.close();
            LOGGER.info("finish");
            System.out.println(file.getAbsoluteFile());
            return file.getAbsolutePath();
        } catch (Exception exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return exception.getMessage();
        }
    }
}
