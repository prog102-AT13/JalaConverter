package org.fundacion.jala.converter.core.facade.strategy.converters;

import org.fundacion.jala.converter.core.ImageConverter;
import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.ImageParameter;

public class ImageConverterStrategy implements IConverterStrategy{
    private ImageParameter imageParameter;

    public ImageConverterStrategy(ImageParameter imageParameter) {
        this.imageParameter = imageParameter;
    }

    @Override
    public String converter() throws ConverterException {
        ImageConverter converter = new ImageConverter(imageParameter);
        converter.convertImage();
        return converter.getOutputFileName();
    }
}