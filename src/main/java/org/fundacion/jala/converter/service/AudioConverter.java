/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
/**
 * @author Edson
 * @collaborator Paola Aguilar
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
     * Create command for audio converter
     */
    public void audioConverter() {
        String relativePath = "cd archive/ && ";
        String ffmpeg = "ffmpeg -i ";
        String bitrate = formatBitrate();
        String hz = formatHz();
        String volume = formatVolume();
        String audioChannel = formatAudioChannel();
        String input = pathFile.substring(pathFile.lastIndexOf(System.getProperty("file.separator")) + 1);
        setOutputFileName(pathFile.substring((pathFile.lastIndexOf(System.getProperty("file.separator")) + 1), pathFile.lastIndexOf(".") + 1) + getFormat());
        String overwrite = " -y";
        String command = relativePath + ffmpeg + input + audioChannel + bitrate + hz + volume + getOutputFileName()
                + overwrite;
        System.out.println(command);
        runCommand.run(command);
    }

    /**
     * Sets new outputFileName of the audio converter
     * @param newOutputFileName
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets name of the output filename
     * @return a string of output filename
     */
    public String getOutputFileName() {
        return this.outputFileName;
    }

}
