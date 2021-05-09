package org.fundacion.jala.converter.core.facade.strategy.compiles;

import org.fundacion.jala.converter.controller.Transform;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.core.javacompiler.JavaVersion;
import org.fundacion.jala.converter.core.parameter.JavaParameter;

public class JavaCompilerStrategy implements ICompiles{
    private JavaCompiler javaCompiler;
    private String code;
    public JavaCompilerStrategy(String code){
        this.code=code;
    }

    @Override
    public String compiler() throws CompilerException {
        if (!code.isBlank() || !code.equals(null)) {
            javaCompiler = new JavaCompiler();
            String filePath = Transform.toFile(code, "Main", "java");
            return javaCompiler.javaCompiler(new JavaParameter(JavaVersion.JAVA_11, filePath, "Main"));
        }
        return "";
    }
}
