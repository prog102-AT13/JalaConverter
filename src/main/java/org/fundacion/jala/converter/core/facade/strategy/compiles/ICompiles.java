package org.fundacion.jala.converter.core.facade.strategy.compiles;

import org.fundacion.jala.converter.core.exceptions.CompilerException;

public interface ICompiles {
    public String compiler() throws CompilerException;
}
