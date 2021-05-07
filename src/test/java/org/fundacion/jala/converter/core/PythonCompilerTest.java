package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.PythonEnum;
import org.fundacion.jala.converter.core.parameter.PythonParameter;
import org.junit.Test;

import static org.junit.Assert.*;

public class PythonCompilerTest {

    @Test(expected = NullPointerException.class)
    public void shouldReturnException() throws CompilerException {
        PythonCompiler pythonCompiler = new PythonCompiler();
        pythonCompiler.compiler(null);
    }

    @Test
    public void shouldCompileAPythonFile() throws CompilerException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/CompilersResources/Python/Main.py";
        PythonParameter pythonParameter = new PythonParameter(filePath, PythonEnum.V3);
        PythonCompiler pythonCompiler = new PythonCompiler();
        String expected = "Hello World" + "\n";
        String actual = pythonCompiler.compiler(pythonParameter);
        assertEquals(expected, actual);
    }

    @Test
    public void makePythonFile() throws CompilerException{
        String fileName = "filetocompile.py";
        String path = "\\archive\\storage\\" + fileName;
        PythonCompiler pythonCompiler = new PythonCompiler();
        String actual = pythonCompiler.makePythonFile("print(\"Hello world\")");
        String expected = System.getProperty("user.dir") + path;
        assertEquals(expected, actual);
    }

    @Test
    public void getResult() {
    }
}