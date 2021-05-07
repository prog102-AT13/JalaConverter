package org.fundacion.jala.converter.core.javacompiler;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.JavaParameter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JavaCompilerTest {

    @Test(expected = NullPointerException.class)
    public void shouldReturnException() throws CompilerException {
        JavaCompiler javaCompiler = new JavaCompiler();
        javaCompiler.javaCompiler(null);
    }

    @Test
    public void shouldCompileAJavaFile() throws CompilerException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/CompilersResources/Java/Main.java";
        JavaParameter javaParameter = new JavaParameter(JavaVersion.JAVA_11, filePath, "Main");
        JavaCompiler javaCompiler = new JavaCompiler();
        String expected = "Hola Mundo" + "\n";
        String actual = javaCompiler.javaCompiler(javaParameter);
        assertEquals(expected, actual);
    }
}
