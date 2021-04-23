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

public class ProjectRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = "http://localhost:8080/api/makeProject";
    private final String projectId = "projectID";
    private final String projectName = "projectName";
    private final String type = "type";

    /**
     * Project Request Form stores parameters for an project request.
     */
    public ProjectRequestForm() {
    }

    /**
     * Adds id parameter.
     *
     * @param id is project id.
     */
    public void addProjectId(final String id) {
        addParameters(new Parameter(projectId, id, false));
    }

    /**
     * Adds name parameter.
     *
     * @param name is project name.
     */
    public void addProjectName(final String name) {
        addParameters(new Parameter(projectName, name, false));
    }

    /**
     * Adds type parameter.
     *
     * @param projectType represents what kind of files project has.
     */
    public void addType(final String projectType) {
        addParameters(new Parameter(type, projectType, false));
    }

    /**
     * Gets the body parameters.
     *
     * @return a list that contains all parameters of project.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter represents all attributes of project.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url.
     *
     * @return the url of project.
     */
    @Override
    public String getURL() {
        return url;
    }
}
