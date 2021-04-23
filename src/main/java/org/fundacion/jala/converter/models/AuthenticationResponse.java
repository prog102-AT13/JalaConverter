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
 * This class creates an authentication response with the json web token.
 */
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(final String jsonWebToken) {
        this.jwt = jsonWebToken;
    }

    /**
     * Gets the java web token (jwt).
     *
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }
}
