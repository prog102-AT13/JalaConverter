/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales
 * @version 1.0
 */

package org.fundacion.jala.converter.models.parameter;

import org.springframework.stereotype.Service;

@Service
public class Parameter {
    private String filePath;

    public Parameter(final String newFilePath) {
        this.filePath = newFilePath;
    }

    public Parameter() {
    }

    /**
     * Returns a string with the path
     * @return the file's path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file's path
     * @param newFilePath a string with the path
     */
    public void setFilePath(final String newFilePath) {
        this.filePath = newFilePath;
    }
}
