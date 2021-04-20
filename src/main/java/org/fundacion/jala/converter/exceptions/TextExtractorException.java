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
