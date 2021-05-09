package org.fundacion.jala.converter.core.facade.strategy.converters;

import org.fundacion.jala.converter.core.VideoConverter;
import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.fundacion.jala.converter.core.parameter.VideoParameter;

public class VideoConverterStrategy implements IConverterStrategy{
    private VideoParameter videoParameter;

    public VideoConverterStrategy(VideoParameter videoParameter) {
        this.videoParameter = videoParameter;
    }

    @Override
    public String converter() throws ConverterException {
        VideoConverter converter = new VideoConverter(videoParameter);
        converter.convertVideo();
        return converter.getOutputFileName();
    }
}
