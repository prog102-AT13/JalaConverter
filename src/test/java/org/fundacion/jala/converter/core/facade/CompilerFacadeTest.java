package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.junit.Test;


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