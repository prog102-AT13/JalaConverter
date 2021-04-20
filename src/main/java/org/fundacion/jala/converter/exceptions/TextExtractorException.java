/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.exceptions;

public class TextExtractorException extends PaoPaoException{
    private final static String DEFAULT_MESSAGE = "Text Extractor Error";

    public TextExtractorException() {
        super(DEFAULT_MESSAGE);
    }

    public TextExtractorException(String message) {
        super(message);
    }

    public TextExtractorException(Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public TextExtractorException(String message, Throwable exception) {
        super(message, exception);
    }
}
