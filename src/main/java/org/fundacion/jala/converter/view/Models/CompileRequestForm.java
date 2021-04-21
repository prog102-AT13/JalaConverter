/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */

package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

public class CompileRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = "http://localhost:8080/api/compilePython";
    private final String code = "code";

    /**
     * Project Request Form stores parameters for an project request
     */
    public CompileRequestForm() {
    }

    /**
     * Adds inputCode parameter
     * @param inputCode
     */
    public void addCode(final String inputCode) {
        addParameters(new Parameter(code, inputCode, false));
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
     * Adds parameters to bodyParameters
     * @param parameter
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url
     * @return url
     */
    @Override
    public String getURL() {
        return url;
    }
}
