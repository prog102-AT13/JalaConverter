package org.fundacion.jala.converter.models.results;
/**
 *  Copyright (c) 2021 Fundacion Jala.
 *   *  This software is the confidential and proprietary information of Fundacion Jala
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

public interface Result {

    /**
     * Returns the text extracted from a file.
     * @return String textExtracted.
     */
    public String getTextExtracted();

    /**
     * Returns the output from a compiled file.
     * @return String consoleOutput.
     */
    public String getConsoleOutput();

    /**
     * Returns the processId from a compiling process.
     * @return String processId.
     */
    public int getProcessId();

    /**
     * Returns the filename from a processed file.
     * @return String filename.
     */
    public String getFilename();

    /**
     * Returns the filename from a thumbnail image.
     * @return String thumbnailFilename.
     */
    public String getThumbnailFilename();
}
