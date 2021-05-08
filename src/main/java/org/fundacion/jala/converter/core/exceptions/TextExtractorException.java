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
 * This class creates the text extractor's exception.
 */
public class TextExtractorException extends PaoPaoException {
    private static final String DEFAULT_MESSAGE = "Text Extractor Error";

    public TextExtractorException() {
        super(DEFAULT_MESSAGE);
    }

    public TextExtractorException(final String message) {
        super(message);
    }

    public TextExtractorException(final Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public TextExtractorException(final String message, final Throwable exception) {
        super(message, exception);
    }
}
