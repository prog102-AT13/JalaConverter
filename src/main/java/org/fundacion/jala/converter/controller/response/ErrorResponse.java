package org.fundacion.jala.converter.controller.response;

public class ErrorResponse extends PaoPaoResponse {
    private String message;

    public ErrorResponse(final String initialStatus, final String initialMessage) {
        super(initialStatus);
        this.message = initialMessage;
    }

    /**
     * Gets the response's message.
     * @return a String with the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the response's message.
     * @param newMessage a String to change the message.
     */
    public void setMessage(final String newMessage) {
        this.message = newMessage;
    }
}
