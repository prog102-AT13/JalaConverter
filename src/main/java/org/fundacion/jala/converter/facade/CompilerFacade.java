package org.fundacion.jala.converter.facade;

import org.fundacion.jala.converter.service.javacompiler.JavaCompiler;
import org.fundacion.jala.converter.service.javacompiler.JavaVersion;
import org.fundacion.jala.converter.service.pythoncompiler.PythonCompiler;
import org.fundacion.jala.converter.service.pythoncompiler.Python;

public class CompilerFacade {
    private String result;
    private JavaCompiler javaCompiler;
    private PythonCompiler pythonCompiler;

    public CompilerFacade() {
    }

    public String facadeJavaCompile(JavaVersion javaVersion, String filePath) {
        javaCompiler = new JavaCompiler();
        result = javaCompiler.javaCompiler(javaVersion, filePath);
        return result;
    }

    public String facadePythonCompile(Python pythonVersion, String filePath) {
        pythonCompiler = new PythonCompiler();
        result = pythonCompiler.compiler(pythonVersion, filePath);
        return result;
    }

}
