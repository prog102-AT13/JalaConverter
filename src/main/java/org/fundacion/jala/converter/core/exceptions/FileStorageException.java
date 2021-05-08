/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.core.exceptions;

/**
 * This class creates the fileStorage's exceptions.
 */
public class FileStorageException extends PaoPaoException{
    private static final String DEFAULT_MESSAGE = "Path doesn't exist or malformed";

    public FileStorageException() {
        super(DEFAULT_MESSAGE);
    }

    public FileStorageException(final String message) {
        super(message);
    }

    public FileStorageException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public FileStorageException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
