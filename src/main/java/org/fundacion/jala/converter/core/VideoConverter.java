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
package org.fundacion.jala.converter.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.fundacion.jala.converter.core.results.Result;
import java.io.IOException;

/**
 * This class converts a video to an specified format.
 */
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
    private Result result;
    private String thumbnailFilename;
    private final String PNG_FORMAT = ".png";

    public VideoConverter(final VideoParameter videoParameter) {
        this.parameter = videoParameter;
    }

    /**
     * Converts the input video.
     */
    public void convertVideo() throws IOException {
        String adaptPath = "\"" + parameter.getFilePath() + "\"";
        format = parameter.getOutputFormat();
        output = adaptPath.substring((adaptPath.lastIndexOf("\\") + 1), adaptPath.lastIndexOf(".") + 1) + format;
        setOutputFileName(output);
        pathOutput = adaptPath.substring(0, (adaptPath.lastIndexOf("archive"))) + "archive\\";
        String ffmpegCommand = startFirstCommand + adaptPath + " ";
        String parameters = changeResolution() + changeFrameRate() + removeAudio();
        String theCommand = ffmpegCommand + parameters + pathOutput + output  + "\"";
        Process process = Runtime.getRuntime().exec("cmd /c " + theCommand);
        ThreadHandler errorHandler = new ThreadHandler(process.getErrorStream(), "Error Stream");
        errorHandler.start();
        ThreadHandler threadHandler = new ThreadHandler(process.getInputStream(), "Output Stream");
        threadHandler.start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            throw new IOException("process interrupted");
        }
        System.out.println("exit code: " + process.exitValue());
        if (parameter.hasThumbnail()) {
            generateAThumbnail();
        }
        result = new Result();
        result.setFilename(outputFileName);
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
    private void generateAThumbnail() throws IOException{
        String name = getOutputFileName().substring(0, getOutputFileName().lastIndexOf("."));
        String startCommand = "ffmpeg -i ";
        String outputCommand = pathOutput + output + "\"" + " -ss 00:00:01 -vframes 1 -s 128x128 " +
                               pathOutput + name + PNG_FORMAT;
        String thumbnailCommand = startCommand + outputCommand;
        Process process = Runtime.getRuntime().exec("cmd /c " + thumbnailCommand);
        ThreadHandler errorHandler = new ThreadHandler(process.getErrorStream(), "Error Stream");
        errorHandler.start();
        ThreadHandler threadHandler = new ThreadHandler(process.getInputStream(), "Output Stream");
        threadHandler.start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            throw new IOException("process interrupted");
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
            frameCommand = " -filter:v fps=" + frameRate + " ";
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

    /**
     * Returns the object result for the operation.
     *
     * @return extractorResult.
     */
    public Result getResult() {
        return result;
    }
}
