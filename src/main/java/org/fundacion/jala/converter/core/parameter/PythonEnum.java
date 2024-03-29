/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.core.parameter;

/**
 * This class refers to binary file for python.
 */
public enum PythonEnum {

    V2("\"" + System.getProperty("user.dir") + "/thirdparty/python3/python.exe" + "\""),
    V3("\"" + System.getProperty("user.dir") + "/thirdparty/python3/python.exe" + "\"");

    public String version;

    private PythonEnum(final String versionCommand) {
        this.version = versionCommand;
    }

    /**
     * Obtains the version of python to compiler.
     *
     * @return the execution command according to the version.
     */
    public String getVersion() {
        return version;
    }
}
