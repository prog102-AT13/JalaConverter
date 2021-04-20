package org.fundacion.jala.converter.exceptions;

public class CompilerException extends PaoPaoException{
    private final static String DEFAULT_MESSAGE = "Compile Error";

    public CompilerException() {
        super(DEFAULT_MESSAGE);
    }

    public CompilerException(String message) {
        super(message);
    }

    public CompilerException(Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public CompilerException(String message, Throwable exception) {
        super(message, exception);
    }
}
