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

package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.fundacion.jala.converter.core.results.Result;
import org.springframework.stereotype.Service;

@Service
public final class AudioConverter {
    private AudioParameter parameter;
    private String outputFileName = "";
    private RunCommand runCommand = new RunCommand();
    private Result result;

    public AudioConverter(final AudioParameter audioParameter) {
        this.parameter = audioParameter;
    }

    /**
     * Create command for audio converter
     */
    public void audioConverter() {
        String relativePath = "cd archive/ && ";
        String ffmpeg = "ffmpeg -i ";
        String bitrate = parameter.formatBitrate();
        String hz = parameter.formatHz();
        String volume = parameter.formatVolume();
        String audioChannel = parameter.formatAudioChannel();
        String input = parameter.getFilePath().substring(parameter.getFilePath().lastIndexOf(System.getProperty("file.separator")) + 1);
        setOutputFileName(parameter.getFilePath().substring((parameter.getFilePath().lastIndexOf(System.getProperty("file.separator")) + 1),
                parameter.getFilePath().lastIndexOf(".") + 1) + parameter.getFormat());
        String overwrite = " -y";
        String command = relativePath + ffmpeg + input + bitrate + hz + audioChannel + volume + getOutputFileName()
                + overwrite;
        runCommand.run(command);
    }

    /**
     * Sets new outputFileName of the audio converter
     * @param newOutputFileName
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.result = new Result();
        result.setFilename(newOutputFileName);
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets name of the output filename
     * @return a string of output filename
     */
    public String getOutputFileName() {
        return this.outputFileName;
    }

    /**
     * Returns the object result for the operation.
     * @return converterResult.
     */
    public Result getResult() {
        return result;
    }

}
