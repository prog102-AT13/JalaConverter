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
     * @param key
     * @param value
     */
    public Parameter(String key, String value, boolean isFile) {
        this.key = key;
        this.value = value;
        this.isFile = isFile;
    }

    /**
     * @return key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets attribute key.
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets attribute value.
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return isFile value.
     */
    public boolean isFile() {
        return isFile;
    }
}
