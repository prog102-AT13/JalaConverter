package org.fundacion.jala.converter.response;

public class ErrorResponse extends PaoPaoResponse{
    private String errorMessage;

    public ErrorResponse(String status, String errorMessage) {
        super(status);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
