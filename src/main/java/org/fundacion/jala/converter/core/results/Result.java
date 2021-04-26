/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * *  This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */
package org.fundacion.jala.converter.core.results;

/**
 * This class stores the return variables for a converter and compiler result.
 */
public class Result {
    private String filename;
    private String path;
    private String processId;
    private String textContent;

    /**
     * Returns the filename.
     *
     * @return A String that represents the filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value for the filename attribute.
     *
     * @param filename A String that represents the filename of the result.
     */
    public void setFilename(final String filename) {
        this.filename = filename;
    }

    /**
     * Returns the Path.
     *
     * @return The String that represents the Path of a file.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path A String with the path for the result.
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Returns the processId attribute.
     *
     * @return A processId String
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the processId.
     *
     * @param processId
     */
    public void setProcessId(final String processId) {
        this.processId = processId;
    }

    /**
     * Returns the content in text from a compiler or extractor.
     *
     * @return A String with the content of a text result.
     */
    public String getTextContent() {
        return textContent;
    }

    /**
     * Sets the text content for the result.
     *
     * @param textContent A String with the text content of the result.
     */
    public void setTextContent(final String textContent) {
        this.textContent = textContent;
    }
}
