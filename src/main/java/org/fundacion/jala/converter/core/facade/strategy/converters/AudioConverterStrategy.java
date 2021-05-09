package org.fundacion.jala.converter.core.facade.strategy.converters;

import org.fundacion.jala.converter.core.AudioConverter;
import org.fundacion.jala.converter.core.parameter.AudioParameter;

public class AudioConverterStrategy implements IConverterStrategy {
    private AudioParameter audioParameter;

    public AudioConverterStrategy(AudioParameter audioParameter) {
        this.audioParameter = audioParameter;
    }

    @Override
    public String converter() {
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter();
        return audioConverter.getOutputFileName();
    }
}
