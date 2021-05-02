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
 * This class creates the checksum exceptions.
 */
public class ChecksumException extends PaoPaoException{
    private static final String DEFAULT_MESSAGE = "Checksum Error";

    public ChecksumException() {
        super(DEFAULT_MESSAGE);
    }

    public ChecksumException(final String message) {
        super(message);
    }

    public ChecksumException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public ChecksumException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
