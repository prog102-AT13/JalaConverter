package org.fundacion.jala.converter.core.facade.strategy.compiles;

import org.fundacion.jala.converter.controller.Transform;
import org.fundacion.jala.converter.core.NodeJsCompiler;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.NodeJsParameter;

public class NodejsCompileStrategy implements ICompiles{
    private static NodeJsCompiler nodeJsCompiler;
private String code;

    public NodejsCompileStrategy(String code) {
        this.code=code;
    }

    @Override
    public String compiler() throws CompilerException {
        if (!code.isBlank() || !code.equals(null)) {
            nodeJsCompiler = new NodeJsCompiler();
            String filePath = Transform.toFile(code, "nodeFile", "js");
            return nodeJsCompiler.nodeCompiler(new NodeJsParameter(filePath));
        }
        return "";
    }
}
