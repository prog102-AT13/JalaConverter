/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */
package org.fundacion.jala.converter.core;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.core.results.Result;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This class extracts the text of a image.
 */
public class ExtractText {
    private String language;
    private String pathFile;
    private String nameOutputFile;
    private Result result;
    private final String TXT_EXTENSION = ".txt";
    private static final Logger LOGGER = LogManager.getLogger();

    public ExtractText(final ExtractTextParameter extractTextParameter) {
        this.language = extractTextParameter.getLanguage();
        this.pathFile = extractTextParameter.getFilePath();
        this.nameOutputFile = extractTextParameter.getResultFile();
    }

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
     * Returns the language to be extracted.
     *
     * @return a String with the value of the selected language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Returns the path file.
     *
     * @return a String with the path of the images.
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * Returns the output name.
     *
     * @return a String with the name of file generate.
     */
    public String getNameOutputFile() {
        return nameOutputFile;
    }

    /**
     *  Extracts the text of an image.
     */
    public void extractText() {
        LOGGER.info("start");
        System.out.println("Loaded");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(System.getProperty("user.dir") + "\\thirdparty\\tessdata");
        tesseract.setLanguage(this.getLanguage());
        try {
            LOGGER.info("Execute Try");
            String text = tesseract.doOCR(new File(this.getPathFile()));
            if (this.getNameOutputFile() != null) {
                safeInfo(this.getNameOutputFile(), text);
            }
            result = new Result();
            result.setTextContent(text);
            System.out.println(text);
        } catch (TesseractException e) {
            LOGGER.error("Execute Tesseract Exception" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        System.out.println("finished");
        LOGGER.info("finish");
    }

    /**
     * Saves the extracted text on a file .txt.
     *
     * @param name a String with the name with which the file will be created.
     * @param text a String containing the text extracted from the image.
     */
    private void safeInfo(final String name, final String text) {
        LOGGER.info("start");
        File file;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        try {
            LOGGER.info("Execute Try");
            file = new File(System.getProperty("user.dir") + "\\archive\\" + name + TXT_EXTENSION);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.write(text);
            printWriter.close();
            bufferedWriter.close();
            result.setFilename(name + TXT_EXTENSION + "  ");
        } catch (Exception e) {
            LOGGER.error("Execute Exception to Safe text in a file");
            e.printStackTrace();
        }
        LOGGER.info("finish");
    }

    /**
     * Returns the object result for the operation.
     * @return extractorResult.
     */
    public Result getResult() {
        return result;
    }
}

