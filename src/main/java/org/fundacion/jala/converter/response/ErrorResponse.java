/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jessicka Moya Andrade
 */
package org.fundacion.jala.converter.response;

/**
 * This class creates the application's responses.
 */
public class ErrorResponse extends PaoPaoResponse {
    private String errorMessage;

    public ErrorResponse(final String initialStatus, final String initialErrorMessage) {
        super(initialStatus);
        this.errorMessage = initialErrorMessage;
    }

    /**
     * Gets the response error message.
     *
     * @return a String with the current error message.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the response error message.
     *
     * @param newErrorMessage is a String to change the error message.
     */
    public void setErrorMessage(final String newErrorMessage) {
        this.errorMessage = newErrorMessage;
    }
}
