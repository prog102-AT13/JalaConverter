package org.fundacion.jala.converter.core.facade.strategy.converters;

import org.fundacion.jala.converter.core.exceptions.ConverterException;

public interface IConverterStrategy {
    public String converter() throws ConverterException;
}
