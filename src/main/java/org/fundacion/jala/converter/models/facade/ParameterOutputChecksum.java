/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.models.facade;

/**
 * Parameter output when checksum are called.
 */
public class ParameterOutputChecksum {
    private String checksumLocal;
    private String outputFilename;
    private int resultTitleSize;
    private String fileName;

    public ParameterOutputChecksum(final String checksumLocal, final String outputFilename, final int resultTitleSize,
                                   final String fileName) {
        this.checksumLocal = checksumLocal;
        this.outputFilename = outputFilename;
        this.resultTitleSize = resultTitleSize;
        this.fileName = fileName;
    }

    /**
     * Gets checksum local.
     *
     * @return string with checksum Local.
     */
    public String getChecksumLocal() {
        return checksumLocal;
    }

    /**
     * Gets Out put Filename.
     *
     * @return string with out put Filename.
     */
    public String getOutputFilename() {
        return outputFilename;
    }

    /**
     * Gets number of file to compress.
     *
     * @return int with number of file to compress.
     */
    public int getResultTitleSize() {
        return resultTitleSize;
    }

    /**
     * Gets name of archive with converts.
     *
     * @return name of archive to converts.
     */
    public String getFileName() {
        return fileName;
    }
}

