/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Edson Añawaya Rios
 */
package org.fundacion.jala.converter.service;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.springframework.stereotype.Service;

@Service
public final class AudioConverter {
    private AudioParameter parameter;
    private String outputFileName = "";
    private RunCommand runCommand = new RunCommand();

    public AudioConverter(final AudioParameter audioParameter) {
        this.parameter = audioParameter;
    }

    /**
     * Creates a command for audio converter.
     */
    public void audioConverter() {
        String relativePath = "cd archive/ && ";
        String ffmpeg = "ffmpeg -i ";
        String bitrate = parameter.formatBitrate();
        String hz = parameter.formatHz();
        String volume = parameter.formatVolume();
        String audioChannel = parameter.formatAudioChannel();
        String input = parameter.getFilePath().substring(parameter.getFilePath()
                       .lastIndexOf(System.getProperty("file.separator")) + 1);
        setOutputFileName(parameter.getFilePath().substring((parameter.getFilePath()
                         .lastIndexOf(System.getProperty("file.separator")) + 1),
                         parameter.getFilePath().lastIndexOf(".") + 1) + parameter.getFormat());
        String overwrite = " -y";
        String command = relativePath + ffmpeg + input + audioChannel + bitrate + hz + volume + getOutputFileName()
                         + overwrite;
        System.out.println(command);
        runCommand.run(command);
    }

    /**
     * Sets a new outputFileName of the audio converter.
     *
     * @param newOutputFileName output file name to be set.
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets the name of the output filename.
     *
     * @return a String of output filename.
     */
    public String getOutputFileName() {
        return this.outputFileName;
    }

}
