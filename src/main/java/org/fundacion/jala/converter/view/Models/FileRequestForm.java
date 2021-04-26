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

/**
 * This class represents a form with a list of file parameters.
 */
public class FileRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private String url = "http://localhost:8080/api/projects/{id}/file";
    private final String FILE_NAME = "fileName";
    private final String CODE = "code";
    private final String FILE_EXTENSION = "extension";

    public FileRequestForm() {
    }

    /**
     * Adds title parameter.
     *
     * @param title represents title that is assigned to the file.
     */
    public void addFileTitle(final String title) {
        addParameters(new Parameter(FILE_NAME, title, false));
    }

    /**
     * Adds inputCode parameter.
     *
     * @param inputCode represents code that is assigned to the file.
     */
    public void addCode(final String inputCode) {
        addParameters(new Parameter(CODE, inputCode, false));
    }

    /**
     * Adds extension parameter.
     *
     * @param extension represents extension that is assigned to the file.
     */
    public void addFileExtension(final String extension) {
        addParameters(new Parameter(FILE_EXTENSION, extension, false));
    }

    /**
     * Gets the body parameters.
     *
     * @return a list that contains all parameters of file.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter represents parameter that is assigned to the file.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url.
     *
     * @return a String with the file's url.
     */
    @Override
    public String getURL() {
        return url;
    }

    /**
     * Sets project id to point the correct endpoint.
     *
     * @param idProj represents id of project.
     */
    public void setUrl(final String idProj) {
        url = "http://localhost:8080/api/projects/" + idProj + "/file";
    }
}

