/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

/**
 * @author Jessicka Moya Andrade
 */
package org.fundacion.jala.converter.exceptions;

public class ConverterException extends PaoPaoException{
    private final static String DEFAULT_MESSAGE = "Invalid Parameter";
    private final static String FIELD_ERROR = "Invalid input = %s, on field = %s";

    public ConverterException() {
        super(DEFAULT_MESSAGE);
    }

    public ConverterException(String message) {
        super(message);
    }

    public ConverterException(String message, Throwable exception) {
        super(message, exception);
    }

    public ConverterException(Throwable exception) {
        super(exception);
    }

    public ConverterException(String input, String field) {
        super(String.format(FIELD_ERROR, input, field));
    }
}
