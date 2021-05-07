package org.fundacion.jala.converter.core.parameter;

import org.fundacion.jala.converter.core.javacompiler.JavaVersion;
import org.junit.Test;
import static org.junit.Assert.*;

public class JavaParameterTest {

    @Test
    public void shouldReturnFileName(){
        JavaParameter javaParameter = new JavaParameter(JavaVersion.JAVA_11,null,"Main");
        String expected = "Main";
        String actual = javaParameter.getNameFile();
        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnJavaVersion(){
        JavaParameter javaParameter = new JavaParameter(JavaVersion.JAVA_11,null,"Main");
        JavaVersion expected = JavaVersion.JAVA_11;
        JavaVersion actual = javaParameter.getJavaVersion();
        assertEquals(expected,actual);
    }
}
