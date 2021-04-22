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

public class ParameterOutputChecksum {
    private String checksumLocal;
    private String outputFilename;
    private int resultTitleSize;
    private String filename;

    public ParameterOutputChecksum(String checksumLocal, String outputFilename, int resultTitleSize, String filename) {
        this.checksumLocal = checksumLocal;
        this.outputFilename = outputFilename;
        this.resultTitleSize = resultTitleSize;
        this.filename=filename;
    }

    /**
     * Gets checksum local
     *
     * @return string with checksum Local
     */
    public String getChecksumLocal() {
        return checksumLocal;
    }

    /**
     * Gets Out put Filename
     *
     * @return string with out put Filename
     */
    public String getOutputFilename() {
        return outputFilename;
    }

    /**
     * Gets number of file to compress
     *
     * @return int with number of file to compress
     */
    public int getResultTitleSize() {
        return resultTitleSize;
    }

    /**
     * Gets name of archive with converts
     *
     * @return name of archive to converts
     */
    public String getFilename() {
        return filename;
    }
}
