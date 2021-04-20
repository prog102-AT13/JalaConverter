package org.fundacion.jala.converter.exceptions;

public class MetadataException extends PaoPaoException {
    private final static String DEFAULT_MESSAGE = "Metadata Error";

    public MetadataException() {
        super(DEFAULT_MESSAGE);
    }

    public MetadataException(String message) {
        super(message);
    }

    public MetadataException(Throwable exception) {
        super(DEFAULT_MESSAGE, exception);
    }

    public MetadataException(String message, Throwable exception) {
        super(message, exception);
    }
}
