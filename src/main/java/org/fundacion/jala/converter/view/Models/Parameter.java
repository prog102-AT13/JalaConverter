/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */
package org.fundacion.jala.converter.view.Models;

/**
 * This class define the parameter object.
 */
public class Parameter {
    private String key;
    private String value;
    private boolean isFile;

    public Parameter(final String newKey, final String newValue, final boolean isAFile) {
        this.key = newKey;
        this.value = newValue;
        this.isFile = isAFile;
    }

    /**
     * Gets the key.
     *
     * @return a String with key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets attribute key.
     *
     * @param newKey String with the new key.
     */
    public void setKey(final String newKey) {
        this.key = newKey;
    }

    /**
     * Gets the value.
     *
     * @return a String with value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets attribute value.
     *
     * @param newValue String with the new value.
     */
    public void setValue(final String newValue) {
        this.value = newValue;
    }

    /**
     * Indicates if is a file.
     *
     * @return a boolean isFile value.
     */
    public boolean isFile() {
        return isFile;
    }
}
