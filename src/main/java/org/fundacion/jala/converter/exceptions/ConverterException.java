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
