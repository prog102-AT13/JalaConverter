package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.NodeJsParameter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeJsCompilerTest {

    @Test(expected = NullPointerException.class)
    public void nodeJsTest() throws CompilerException {
        NodeJsCompiler nodeJsCompiler = new NodeJsCompiler();
        nodeJsCompiler.nodeCompiler(null);
    }

    @Test
    public void shouldCompileAJavaFile() throws CompilerException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/CompilersResources/NodeJs/test.js";
        NodeJsParameter nodeJsParameter = new NodeJsParameter(filePath);
        NodeJsCompiler nodeJsCompiler = new NodeJsCompiler();
        String expected = "Hola Mundo" + "\n";
        String actual = nodeJsCompiler.nodeCompiler(nodeJsParameter);
        assertEquals(expected, actual);
    }
}
