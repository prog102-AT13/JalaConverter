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
package org.fundacion.jala.converter.controller.response;

/**
 * This class creates an SuccessAuthenticationResponse that extends from PaoPaoResponse
 */
public class SuccessAuthenticationResponse extends PaoPaoResponse {
    private String jwt;

    public SuccessAuthenticationResponse(final String initialStatus, final String initialJwt) {
        super(initialStatus);
        this.jwt = initialJwt;
    }

    /**
     * Gets the json web token.
     *
     * @return a String with the token.
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * Sets the json web token.
     *
     * @param newJwt a String to change the token.
     */
    public void setJwt(final String newJwt) {
        this.jwt = newJwt;
    }
}
