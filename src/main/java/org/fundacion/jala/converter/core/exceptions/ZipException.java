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
package org.fundacion.jala.converter.core.exceptions;

/**
 * This class creates the zip's exceptions.
 */
public class ZipException extends PaoPaoException {
    private static final String DEFAULT_MESSAGE = "Zip Error";

    public ZipException() {
        super(DEFAULT_MESSAGE);
    }

    public ZipException(final String message) {
        super(message);
    }

    public ZipException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public ZipException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
