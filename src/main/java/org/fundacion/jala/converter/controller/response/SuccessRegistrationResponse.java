/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.controller.response;

public class SuccessRegistrationResponse extends PaoPaoResponse {
    private String username;
    private String password;

    public SuccessRegistrationResponse(final String initialStatus, final String newUsername, final String newPassword) {
        super(initialStatus);
        this.username = newUsername;
        this.password = newPassword;
    }

    /**
     * Gets the username.
     *
     * @return a String with username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param newUsername a String with username to change.
     */
    public void setUsername(final String newUsername) {
        this.username = newUsername;
    }

    /**
     * Gets the password.
     *
     * @return a String with the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param newPassword a String with the password to change.
     */
    public void setPassword(final String newPassword) {
        this.password = newPassword;
    }
}
