package org.fundacion.jala.converter.core.facade.strategy.compiles;

import org.fundacion.jala.converter.controller.Transform;
import org.fundacion.jala.converter.core.PythonCompiler;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.PythonEnum;
import org.fundacion.jala.converter.core.parameter.PythonParameter;

public class PythonCompileStrategy implements ICompilesStrategy {
    private PythonCompiler pythonCompiler;
    private String code;

    public PythonCompileStrategy(String code) {
        this.code=code;
    }
    @Override
    public String compiler() throws CompilerException {
        if (!code.isBlank() || !code.equals(null)) {
            pythonCompiler = new PythonCompiler();
            String filePath = Transform.toFile(code, "filetocompile", "py");
            return pythonCompiler.compiler(new PythonParameter(filePath, PythonEnum.V3));
        }
        return "";
    }
}
