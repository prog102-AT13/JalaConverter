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

public class MetadataException extends PaoPaoException {
    private static final String DEFAULT_MESSAGE = "Metadata Error";

    public MetadataException() {
        super(DEFAULT_MESSAGE);
    }

    public MetadataException(final String message) {
        super(message);
    }

    public MetadataException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public MetadataException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
