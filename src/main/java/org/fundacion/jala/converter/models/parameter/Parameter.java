/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
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
     * @return the file's path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param newFilePath a string with the path
     */
    public void setFilePath(final String newFilePath) {
        this.filePath = newFilePath;
    }
}
