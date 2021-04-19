/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */
package org.fundacion.jala.converter.view.Models;

public class Parameter {
    private String key;
    private String value;
    private boolean isFile;

    /**
     * Creates a parameter for a request body with the key and value fields.
     * @param newKey String with the new key
     * @param newValue String with the new value
     */
    public Parameter(final String newKey, final String newValue, final boolean isAFile) {
        this.key = newKey;
        this.value = newValue;
        this.isFile = isAFile;
    }

    /**
     * Gets the key
     * @return key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets attribute key.
     * @param newKey
     */
    public void setKey(final String newKey) {
        this.key = newKey;
    }

    /**
     * Gets the value
     * @return value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets attribute value.
     * @param newValue
     */
    public void setValue(final String newValue) {
        this.value = newValue;
    }

    /**
     * Indicates if is a file
     * @return isFile value.
     */
    public boolean isFile() {
        return isFile;
    }
}
