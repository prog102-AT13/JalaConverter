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
package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.fundacion.jala.converter.core.AudioConverter;
import org.fundacion.jala.converter.core.VideoConverter;
import java.io.IOException;

/**
 * This class calls facade of converter.
 */
public class ConverterFacade {

    private ConverterFacade() {
    }

    /**
     * Obtains audio converted with file name.
     *
     * @param audioParameter is a object with parameter of audio to convert.
     * @return a string of output filename.
     */
    public static String getAudioConverter(final AudioParameter audioParameter) {
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter();
        return audioConverter.getOutputFileName();
    }

    /**
     * Obtains audio converted with file name.
     *
     * @param videoParameter is a object with parameter of video to convert.
     * @return string of output filename.
     */
    public static String getVideoConverter(VideoParameter videoParameter) throws IOException {
        VideoConverter converter = new VideoConverter(videoParameter);
        converter.convertVideo();
        return converter.getOutputFileName();
    }
}