/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ExtractText {

    private String language;
    private String pathFile;
    private String nameOutputFile;
    private static final Logger LOGGER = LogManager.getLogger();

    public ExtractText(final String language, final String pathFile) {
        this.language = language;
        this.pathFile = pathFile;
    }

    public ExtractText(final String language, final String pathFile, final String nameOutputFile) {
        this.language = language;
        this.pathFile = pathFile;
        this.nameOutputFile = nameOutputFile;
    }

    /**
     *
     * @return a string with the value of the selected language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @return a string with the path of the images
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     *
     * @return a string with the name of file generate
     */
    public String getNameOutputFile() {
        return nameOutputFile;
    }

    /**
     *  extract text for a image
     */
    public void extractText() {
        LOGGER.info("start");
        System.out.println("Loaded");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(System.getProperty("user.dir") + "\\tessdata");
        tesseract.setLanguage(this.getLanguage());
        try {
            LOGGER.info("Execute Try");
            String text =  tesseract.doOCR(new File(this.getPathFile()));
            if (this.getNameOutputFile() != null) {
                safeInfo(this.getNameOutputFile(), text);
            }
            System.out.println(text);
        } catch (TesseractException e) {
            LOGGER.error("Execute Tesseract Exception" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        System.out.println("finished");
        LOGGER.info("finish");
    }

    /**
     * Safe extracted text on a file .txt
     * @param name String with the name with which the file will be created
     * @param text String containing the text extracted from the image
     */
    private void safeInfo(final String name, final String text) {
        LOGGER.info("start");
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        try {
            LOGGER.info("Execute Try");
            file = new File(System.getProperty("user.dir") + "\\archive\\" + name + ".txt");
            fileWriter =  new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.write(text);
            printWriter.close();
            bufferedWriter.close();
        } catch (Exception e) {
            LOGGER.error("Execute Exception to Safe text in a file");
            e.printStackTrace();
        }
        LOGGER.info("finish");
    }
}
