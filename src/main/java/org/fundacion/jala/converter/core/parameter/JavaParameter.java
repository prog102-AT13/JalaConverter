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
package org.fundacion.jala.converter.core.parameter;

import org.fundacion.jala.converter.core.javacompiler.JavaVersion;

/**
 * This class has the options from the java parameters.
 */
public class JavaParameter extends Parameter {
    private JavaVersion javaVersion;

    public JavaParameter(final JavaVersion newJavaVersion, final String filePath) {
        super(filePath);
        this.javaVersion = newJavaVersion;
    }

    /**
     * Gets the version for Java version.
     *
     * @return javaVersion Java version.
     */
    public JavaVersion getJavaVersion() {
        return javaVersion;
    }
}