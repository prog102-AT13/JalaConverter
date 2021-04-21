/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
/**
 * @author Paola Aguilar
 */
package org.fundacion.jala.converter.models.parameter;

import org.fundacion.jala.converter.service.javacompiler.JavaVersion;

public class JavaParameter extends Parameter {
    private JavaVersion javaVersion;

    public JavaParameter(final JavaVersion javaVersion, final String filePath) {
        super(filePath);
        this.javaVersion = javaVersion;
    }

    /**
     * Gets the version for Java version.
     * @return javaVersion Java version
     */
    public JavaVersion getJavaVersion() {
        return javaVersion;
    }
}
