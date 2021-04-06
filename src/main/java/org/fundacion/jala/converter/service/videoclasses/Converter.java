/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.videoclasses;

public class Converter {
    private String startFirstCommand = "ffmpeg -i ";
    private String inputNameFixed = "";
    private String outputNameFixed = "";
    private VideoParameter parameter;
    private static final int INIT_NUMBER = 20;

    public Converter(final VideoParameter vParameter) {
        this.parameter = vParameter;
        fixInputName();
        fixOutputName();
    }

    /**
     * Adds quotes to the input video name
     */
    private void fixInputName() {
        inputNameFixed = "\"" + parameter.getInputName() + "\"";
    }

    /**
     * Adds quotes to the output video name
     */
    private void fixOutputName() {
        outputNameFixed = "\"" + parameter.getOutputName() + "\"";
    }

    /**
     * Changes the resolution and aspect ratio of the input video
     * @return resolution command
     */
    private String changeResolution() {
        int width = parameter.getWidth();
        int height = parameter.getHeight();
        if (width > 0 && height > 0) {
            String scale = width + ":" + height;
            String acpectRatio = ":force_original_aspect_ratio=decrease,pad=";
            String resolutionCommand = "-vf \"scale=" + scale + acpectRatio + scale + ":-1:-1:color=white\"";
            return resolutionCommand;
        }
        return "";
    }

    /**
     * Generates a json with the output video metadata
     */
    private void generateMetaDataJsonFormat() {
        String finalDir = parameter.getDirection();
        String startCommand = "ffprobe -v quiet -print_format json -show_format -show_streams ";
        String outputCommand = outputNameFixed + " > " + outputNameFixed + ".json";
        String jsonCommand = startCommand + outputCommand;
        try {
            Process petition = Runtime.getRuntime().exec("cmd /c" + finalDir + jsonCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a input video tumbnail
     * @return tumbnail command
     */
    private String generateATumbnail() {
        boolean tumbnail = parameter.hasTumbnail();
        if (tumbnail) {
            String tumbnailCommand = " -ss 00:00:01 -vframes 1 VideoTumbnail.png";
            return tumbnailCommand;
        }
        return "";
    }

    /**
     * Removes the audio of the input video
     * @return audio command
     */
    private String removeAudio() {
        boolean audio = parameter.hasAudio();
        if (audio) {
            String audioCommand = "-an";
            return audioCommand;
        }
        return "";
    }

    /**
     * Changes the input video frame rate
     * @return
     */
    private String changeFrameRate() {
        int frameRate = parameter.getFrameRate();
        if (frameRate > INIT_NUMBER) {
            String frameCommand = " -filter:v fps=" + frameRate + " ";
            return frameCommand;
        }
        return "";
    }

    /**
     * Converts the input video
     */
    public void convertVideo() {
        String dir = parameter.getDirection();
        String fCommand = startFirstCommand + inputNameFixed + " ";
        String parameters = changeResolution() + changeFrameRate() + removeAudio();
        String theCommand = fCommand + parameters + outputNameFixed + generateATumbnail();

        try {
            Process petition = Runtime.getRuntime().exec("cmd /c" + dir + theCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (parameter.hasMetaData()) {
            generateMetaDataJsonFormat();
        }
        System.out.println(theCommand);
    }
}
