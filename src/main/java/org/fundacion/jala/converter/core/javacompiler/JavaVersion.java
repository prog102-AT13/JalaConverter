/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jessicka Moya Andrade
 */
package org.fundacion.jala.converter.core.javacompiler;

/**
 * This enum defines possible Java versions.
 */
public enum JavaVersion {
    JAVA_11("javac", "java");

    private final String compiler;
    private final String executor;

    JavaVersion(final String newCompiler, final String newExecutor) {
        this.compiler = newCompiler;
        this.executor = newExecutor;
    }

    /**
     * Gets the compiler command according to the Java version.
     *
     * @return the compiler command according to the Java version.
     */
    public String getCompiler() {
        return compiler;
    }

    /**
     * Gets the executor command according to the Java version.
     *
     * @return the executor command according to the Java version.
     */
    public String getExecutor() {
        return executor;
    }
}
