package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.exceptions.ChecksumException;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.javacompiler.JavaVersion;
import org.fundacion.jala.converter.core.parameter.JavaParameter;
import org.fundacion.jala.converter.core.parameter.PythonParameter;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CompilerFacadeTest {

    @Test
    public void facadeJavaCompile() throws CompilerException {
        assertTrue("".equals(CompilerFacade.facadeJavaCompile("")));
    }

    @Test
    public void facadePythonCompile() throws CompilerException {
        assertEquals("", CompilerFacade.facadePythonCompile(""));
    }

    @Test
    public void facadeNodejsCompile() throws CompilerException {
        assertEquals("", CompilerFacade.facadeNodejsCompile(""));
    }

}