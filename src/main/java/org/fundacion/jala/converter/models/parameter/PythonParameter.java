/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Ximena Aguilar Quiñones
 */
package org.fundacion.jala.converter.models.parameter;

/**
 * This class is to python parameter.
 */
public class PythonParameter extends Parameter {
    private PythonEnum pythonEnum;

    public PythonParameter(final String pathFile, final PythonEnum compilerVersion) {
        super(pathFile);
        this.pythonEnum = compilerVersion;
    }

    /**
     * Gets the enum for Python version.
     *
     * @return pythonEnum Python version.
     */
    public PythonEnum getPythonEnum() {
        return pythonEnum;
    }
}
