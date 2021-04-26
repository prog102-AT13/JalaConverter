/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.models;

/**
 * This class creates an authentication request with the username and password.
 */
public class AuthenticationRequest {
    private String username;
    private String password;

    public AuthenticationRequest(final String newUsername, final String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }

    /**
     * Gets the username.
     *
     * @return String that is username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param newUsername is a new user name to set the new value.
     */
    public void setUsername(final String newUsername) {
        this.username = newUsername;
    }

    /**
     * Gets the password.
     *
     * @return String that is password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param newPassword is a new password to set new value.
     */
    public void setPassword(final String newPassword) {
        this.password = newPassword;
    }
}
