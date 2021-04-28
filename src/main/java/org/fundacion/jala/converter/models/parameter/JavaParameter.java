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

import org.fundacion.jala.converter.service.javacompiler.JavaVersion;

/**
 * This class has the options from the java parameters.
 */
public class JavaParameter extends Parameter {
    private JavaVersion javaVersion;
    private String nameFile;

    public JavaParameter(final JavaVersion newJavaVersion, final String filePath, final String newNameFile) {
        super(filePath);
        this.javaVersion = newJavaVersion;
        this.nameFile = newNameFile;
    }

    /**
     * Gets the version for Java version.
     *
     * @return javaVersion Java version.
     */
    public JavaVersion getJavaVersion() {
        return javaVersion;
    }

    /**
     * Gets the file's name.
     *
     * @return a String with file's name.
     */
    public String getNameFile() {
        return nameFile;
    }
}
