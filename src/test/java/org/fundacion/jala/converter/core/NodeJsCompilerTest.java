package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeJsCompilerTest {

    @Test(expected = NullPointerException.class)
    public void nodeJsTest() throws CompilerException {
        NodeJsCompiler nodeJsCompiler = new NodeJsCompiler();
        nodeJsCompiler.nodeCompiler(null);
    }

}