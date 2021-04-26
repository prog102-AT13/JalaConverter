/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.exceptions.ConverterException;
import org.fundacion.jala.converter.models.parameter.VideoParameter;
import org.springframework.stereotype.Service;

/**
 * This class converts a video to an specified format.
 */
@Service
public class VideoConverter {
    private String startFirstCommand = "ffmpeg -i ";
    private VideoParameter parameter;
    private String format;
    private String output;
    private String pathOutput;
    private String outputFileName;
    private static final int WAIT_TIME = 7000;
    private static final int INIT_NUMBER = 20;
    private static final Logger LOGGER = LogManager.getLogger();

    public VideoConverter(final VideoParameter videoParameter) {
        this.parameter = videoParameter;
    }

    /**
     * Converts the input video.
     */
    public void convertVideo() throws ConverterException {
        String adaptPath = "\"" + parameter.getFilePath() + "\"";
        format = parameter.getOutputFormat();
        output = adaptPath.substring((adaptPath.lastIndexOf("\\") + 1), adaptPath.lastIndexOf(".") + 1) + format;
        setOutputFileName(output);
        pathOutput = adaptPath.substring(0, (adaptPath.lastIndexOf("archive"))) + "archive\\";
        String ffmpegCommand = startFirstCommand + adaptPath + " ";
        String parameters = changeResolution() + changeFrameRate() + removeAudio();
        String theCommand = ffmpegCommand + parameters + pathOutput + output + "\"" + " -y";
        System.out.println(theCommand);
        try {
            LOGGER.info("Execute Try");
            Process petition = Runtime.getRuntime().exec("cmd /c " + theCommand);
            LOGGER.info("finish");
        } catch (Exception exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            throw new ConverterException(exception);
        }
        try {
            LOGGER.info("Execute Try");
            Thread.sleep(WAIT_TIME);
            generateAThumbnail();
            LOGGER.info("finish");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Changes the resolution and aspect ratio of the input video.
     *
     * @return a String with the resolution command.
     */
    private String changeResolution() {
        int width = parameter.getWidth();
        int height = parameter.getHeight();
        String scale;
        String aspectRatio;
        String resolutionCommand;
        if (width > 0 && height > 0) {
            scale = width + ":" + height;
            aspectRatio = ":force_original_aspect_ratio=decrease,pad=";
            resolutionCommand = "-vf \"scale=" + scale + aspectRatio + scale +
                                ":-1:-1:color=white\"";
            return resolutionCommand;
        }
        return "";
    }

    /**
     * Generates a input video thumbnail.
     */
    private void generateAThumbnail() {
        String name = getOutputFileName().substring(0, getOutputFileName().lastIndexOf("."));
        String startCommand = "ffmpeg -i ";
        String outputCommand = pathOutput + output + "\"" + " -ss 00:00:01 -vframes 1 -s 128x128 " +
                               pathOutput + name + ".png\"";
        String thumbnailCommand = startCommand + outputCommand;
        try {
            LOGGER.info("Execute Try");
            Process petition = Runtime.getRuntime().exec("cmd /c" + thumbnailCommand);
            LOGGER.info("finish");
        } catch (Exception exception) {
            exception.printStackTrace();
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
        }
    }

    /**
     * Removes the audio of the input video.
     *
     * @return a String with the remove audio command.
     */
    private String removeAudio() {
        boolean audio = parameter.hasAudio();
        String audioCommand;
        if (audio) {
            audioCommand = "-an ";
            return audioCommand;
        }
        return "";
    }

    /**
     * Changes the input video frame rate.
     *
     * @return a String with the frame command.
     */
    private String changeFrameRate() {
        int frameRate = parameter.getFrameRate();
        String frameCommand;
        if (frameRate > INIT_NUMBER) {
            frameCommand = " -r " + frameRate + " -y ";
            return frameCommand;
        }
        return "";
    }

    /**
     * Sets the output file name.
     *
     * @param newOutputFileName String with the output file name.
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets the output file name.
     *
     * @return a String with the outputFileName.
     */
    public String getOutputFileName() {
        return outputFileName;
    }
}
