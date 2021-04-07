package org.fundacion.jala.converter.service.javacompiler;

public enum JavaVersion {
    JAVA_11 ("\"thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\javac.exe\"", "\"thirdparty\\windows\\javabin\\jdk-11.0.10\\bin\\java.exe\"");

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
