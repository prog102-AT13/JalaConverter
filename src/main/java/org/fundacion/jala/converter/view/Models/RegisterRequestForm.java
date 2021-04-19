package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

public class RegisterRequestForm implements IrequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String URL = "http://localhost:8080/register";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    /**
     * Adds username parameter to bodyParameters
     * @param username a String with the username
     */
    public void addUsername(final String username) {
        addParameters(new Parameter(USERNAME, username, false));
    }

    /**
     * Adds password parameter to bodyParameters
     * @param password a String with the password
     */
    public void addPassword(final String password) {
        addParameters(new Parameter(PASSWORD, password, false));
    }
    /**
     * Gets the parameters list
     * @return a list with the parameters
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds a parameter to the parameters list
     * @param parameter a Parameter to add
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the URL of the endpoint
     * @return a String with the URL
     */
    @Override
    public String getURL() {
        return URL;
    }
}
