package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

public class FileRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = "http://localhost:8080/api/makeFile";
    private final String projectId = "projectID";
    private final String fileTitle = "fileTitle";
    private final String code = "code";
    private final String fileExtension = "extension";

    /**
     * Audio Request Form stores parameters for an audio request
     */
    public FileRequestForm() {
    }

    /**
     * Adds projId parameter
     * @param projId
     */
    public void addProjectId(final String projId) {
        addParameters(new Parameter(projectId, projId, false));
    }
    /**
     * Adds title parameter
     * @param title
     */
    public void addFileTitle(final String title) {
        addParameters(new Parameter(fileTitle, title, false));
    }
    /**
     * Adds inputCode parameter
     * @param inputCode
     */
    public void addCode(final String inputCode) {
        addParameters(new Parameter(code, inputCode, false));
    }

    /**
     * Adds extension parameter
     * @param extension
     */
    public void addFileExtension(final String extension) {
        addParameters(new Parameter(fileExtension, extension, false));
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
