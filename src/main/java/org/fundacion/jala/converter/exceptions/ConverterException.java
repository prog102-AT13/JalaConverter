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

public class ConverterException extends PaoPaoException{
    private static final String DEFAULT_MESSAGE = "Invalid Parameter";
    private static final String FIELD_ERROR = "Invalid input = %s, on field = %s";

    public ConverterException() {
        super(DEFAULT_MESSAGE);
    }

    public ConverterException(final String message) {
        super(message);
    }

    public ConverterException(final String message, final Throwable exception) {
        super(message, exception);
    }

    public ConverterException(final Throwable exception) {
        super(exception);
    }

    public ConverterException(final String input, final String field) {
        super(String.format(FIELD_ERROR, input, field));
    }
}
