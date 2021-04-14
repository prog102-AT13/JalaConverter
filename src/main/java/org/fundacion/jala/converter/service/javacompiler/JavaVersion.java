/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.javacompiler;

public enum JavaVersion {
    JAVA_11 ("thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\javac.exe", "thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\java.exe");

    private final String compiler;
    private final String executor;

    JavaVersion(final String compiler, final String executor) {
        this.compiler = compiler;
        this.executor = executor;
    }

    /**
     * @return the compiler command according to the version
     */
    public String getCompiler() {
        return compiler;
    }

    /**
     * @return the executor command according to the version
     */
    public String getExecutor() {
        return executor;
    }
}
