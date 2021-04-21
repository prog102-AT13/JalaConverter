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

public class ExtractTextRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = dotenv.get("HTTP_URL_EXTRACT_TEXT");
    private final String file = "file";
    private final String format = "language";

    public ExtractTextRequestForm() {
    }

    /**
     * Adds filepath parameter
     * @param filepathValue
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(file, filepathValue, true));
    }

    /**
     * Adds language format parameter
     * @param languageFormat
     */
    public void addLanguageFormat(final String languageFormat) {
        addParameters(new Parameter(format, languageFormat, false));
    }

    /**
     * Gets the body parameters
     * @return bodyParameters
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     * @param parameter
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the URL
     * @return URL
     */
    @Override
    public String getURL() {
        return url;
    }
}
