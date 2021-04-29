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

/**
 * This class creates an ErrorResponse that extends from PaoPaoResponse
 */
public class ErrorResponse extends PaoPaoResponse {
    private String message;

    public ErrorResponse(final String initialStatus, final String initialMessage) {
        super(initialStatus);
        this.message = initialMessage;
    }

    /**
     * Gets the response's message.
     *
     * @return a String with the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the response's message.
     *
     * @param newMessage a String to change the message.
     */
    public void setMessage(final String newMessage) {
        this.message = newMessage;
    }
}
