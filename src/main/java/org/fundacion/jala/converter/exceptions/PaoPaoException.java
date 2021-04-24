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
package org.fundacion.jala.converter.exceptions;

/**
 * This class creates the application's exceptions.
 */
public class PaoPaoException extends Exception {

    public PaoPaoException() {
        super();
    }

    public PaoPaoException(final String message) {
        super(message);
    }

    public PaoPaoException(final Throwable exception) {
        super(exception);
    }

    public PaoPaoException(final String message, final Throwable exception) {
        super(message, exception);
    }

}
