package org.fundacion.jala.converter.controller.response;

public class PaoPaoResponse {
    private String status;

    public PaoPaoResponse(final String initialStatus) {
        this.status = initialStatus;
    }

    /**
     * Gets the response status
     * @return a String with the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the response status.
     * @param newStatus a String to change the status.
     */
    public void setStatus(final String newStatus) {
        this.status = status;
    }
}