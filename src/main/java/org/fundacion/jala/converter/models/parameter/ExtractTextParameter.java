/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Rodrigo Caceres Velasco
 */
package org.fundacion.jala.converter.models.parameter;

import org.springframework.stereotype.Service;

/**
 * This class is the options of the extract text parameters.
 */
@Service
public class ExtractTextParameter extends Parameter {
    private String language;
    private String resultFile;

    public ExtractTextParameter(final String newFilePath) {
        super(newFilePath);
    }

    public ExtractTextParameter(final String newFilePath, final String newLanguage, final String newResultFile) {
        super(newFilePath);
        this.language = newLanguage;
        this.resultFile = newResultFile;
    }

    public ExtractTextParameter() {
    }

    /**
     * Obtains a String with the set language to be extracted.
     *
     * @return the language of the text.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set String with the file's language.
     *
     * @param newLanguage is a new language of the text.
     */
    public void setLanguage(final String newLanguage) {
        this.language = newLanguage;
    }

    /**
     * Obtains a String with the name of the result file.
     *
     * @return name of the result file.
     */
    public String getResultFile() {
        return resultFile;
    }

    /**
     * Sets String with the file's name.
     *
     * @param newResultFile is a String with the file's name.
     */
    public void setResultFile(final String newResultFile) {
        this.resultFile = newResultFile;
    }
}
