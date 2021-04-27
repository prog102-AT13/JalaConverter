package org.fundacion.jala.converter.controller.response;

public class SuccessAuthenticationResponse extends PaoPaoResponse {
    private String jwt;

    public SuccessAuthenticationResponse(final String initialStatus, final String initialJwt) {
        super(initialStatus);
        this.jwt = initialJwt;
    }

    /**
     * Gets the json web token.
     * @return a String with the token.
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * Sets the json web token.
     * @param newJwt a String to change the token.
     */
    public void setJwt(final String newJwt) {
        this.jwt = newJwt;
    }
}
