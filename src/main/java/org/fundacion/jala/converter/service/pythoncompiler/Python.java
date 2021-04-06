/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.pythoncompiler;

public enum Python {
    V2("python"), V3("python3");

    private String version;

    private Python (final String versionP){
        this.version = versionP;
    }

    /**
     * @return the execution command according to the version
     */
    public String getVersion() {
        return version;
    }
}
