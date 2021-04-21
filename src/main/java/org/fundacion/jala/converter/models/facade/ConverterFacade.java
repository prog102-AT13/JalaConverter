/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.models.facade;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.models.parameter.VideoParameter;
import org.fundacion.jala.converter.service.AudioConverter;
import org.fundacion.jala.converter.service.VideoConverter;

public class ConverterFacade {

    private ConverterFacade() {
    }

    /**
     * The method to convert Audio.
     * @param audioParameter is a object with parameter of audio to convert
     * @return a string of output filename
     */
    public static String getAudioConverter(final AudioParameter audioParameter) {
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter();
        return audioConverter.getOutputFileName();
    }

    /**
     * The method to convert Video.
     * @param videoParameter is a object with parameter of video to convert
     * @return string of output filename
     */
    public static String getVideoConverter(final VideoParameter videoParameter) {
        VideoConverter converter = new VideoConverter(videoParameter);
        converter.convertVideo();
        return converter.getOutputFileName();
    }
}
