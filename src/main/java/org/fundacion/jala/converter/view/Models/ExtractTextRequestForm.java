/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */

package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class shows the extract text form.
 */
public class ExtractTextRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String URL = dotenv.get("HTTP_URL_EXTRACT_TEXT");
    private final String FILE = "file";
    private final String FORMAT = "language";

    public ExtractTextRequestForm() {
    }

    /**
     * Adds filepath parameter.
     *
     * @param filepathValue Sting with the file's path.
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(FILE, filepathValue, true));
    }

    /**
     * Adds language format parameter.
     *
     * @param languageFormat String with format's language.
     */
    public void addLanguageFormat(final String languageFormat) {
        addParameters(new Parameter(FORMAT, languageFormat, false));
    }

    /**
     * Gets the body parameters.
     *
     * @return a List<Parameter> with body's parameters.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter Object Parameter.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the URL.
     *
     * @return a String with the file's url.
     */
    @Override
    public String getURL() {
        return URL;
    }
}
