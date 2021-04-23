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
 * This class creates the compiler's exceptions.
 */
public class CompilerException extends PaoPaoException {
    private static final String DEFAULT_MESSAGE = "Compile Error";

    public CompilerException() {
        super(DEFAULT_MESSAGE);
    }

    public CompilerException(final String message) {
        super(message);
    }

    public CompilerException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public CompilerException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
