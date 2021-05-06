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

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.fundacion.jala.converter.core.parameter.ImageParameter;
import org.fundacion.jala.converter.core.AudioConverter;
import org.fundacion.jala.converter.core.VideoConverter;
import org.fundacion.jala.converter.core.ImageConverter;
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
     * @return a String of output filename.
     */
    public static String getAudioConverter(final AudioParameter audioParameter) {
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter();
        return audioConverter.getOutputFileName();
    }

    /**
     * Obtains video converted with file name.
     *
     * @param videoParameter is a object with parameter of video to convert.
     * @return a String of output filename.
     * @throws ConverterException if process is interrupted.
     */
    public static String getVideoConverter(final VideoParameter videoParameter) throws ConverterException {
        VideoConverter converter = new VideoConverter(videoParameter);
        converter.convertVideo();
        return converter.getOutputFileName();
    }

    /**
     * Obtains image converted with file name.
     *
     * @param imageParameter is a object with parameter of image to convert.
     * @return a String of output filename.
     * @throws ConverterException if process is interrupted.
     */
    public static String getImageConverter(final ImageParameter imageParameter) throws IOException, ConverterException {
        ImageConverter converter = new ImageConverter(imageParameter);
        converter.convertImage();
        return converter.getOutputFileName();
    }
}
