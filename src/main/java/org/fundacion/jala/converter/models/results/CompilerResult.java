package org.fundacion.jala.converter.models.results;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * *  This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

public class CompilerResult implements Result {
    public String textExtracted;
    public String consoleOutput;
    public int processID;
    public String filename;
    public String thumbnailFilename;

    /**
     * Returns the text extracted from a file.
     * @return String textExtracted.
     */
    public String getTextExtracted() {
        return textExtracted;
    }

    /**
     * Returns the output from a compiled file.
     * @return String consoleOutput.
     */
    public String getConsoleOutput() {
        return consoleOutput;
    }

    /**
     * Returns the processId from a compiling process.
     * @return String processId.
     */
    public int getProcessId() {
        return processID;
    }

    /**
     * Returns the filename from a processed file.
     * @return String filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Returns the filename from a thumbnail image.
     * @return String thumbnailFilename.
     */
    public String getThumbnailFilename() {
        return thumbnailFilename;
    }

    /**
     * Sets the text for the output for a compiled file.
     * @param consoleOutput
     */
    public void setConsoleOutput(String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    /**
     * Sets the process Id for a compiled file.
     * @param processID
     */
    public void setProcessID(int processID) {
        this.processID = processID;
    }

    /**
     * Sets the filename of a result processed file.
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
