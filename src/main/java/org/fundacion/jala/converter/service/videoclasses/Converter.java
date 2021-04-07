/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.videoclasses;

import org.springframework.stereotype.Service;

@Service
public class Converter {
    private String startFirstCommand = "ffmpeg -i ";
    private VideoParameter parameter;
    private String format;
    private String output;
    private String pathOutput;
    private String outputFileName;
    private static final int WAIT_TIME = 5000;
    private static final int INIT_NUMBER = 20;

    public Converter(final VideoParameter videoParameter) {
        this.parameter = videoParameter;
    }

    /**
     * Converts the input video
     * @param pathFile string with the input path
     */
    public void convertVideo(final String pathFile) {
        String adaptPath = "\"" + pathFile + "\"";
        format = parameter.getOutputFormat();
        output = adaptPath.substring((adaptPath.lastIndexOf("\\") + 1), adaptPath.lastIndexOf(".") + 1) + format;
        setOutputFileName(output);
        pathOutput = adaptPath.substring(0, (adaptPath.lastIndexOf("archive"))) + "archive\\";
        String fCommand = startFirstCommand + adaptPath + " ";
        String parameters = changeResolution() + changeFrameRate() + removeAudio();
        String theCommand = fCommand + parameters + pathOutput + output  + "\"" + generateATumbnail() + " -y";
        System.out.println(theCommand);
        try {
            Process petition = Runtime.getRuntime().exec("cmd /c " + theCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(WAIT_TIME);
            if (parameter.hasMetaData()) {
                generateMetaDataJsonFormat();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the resolution and aspect ratio of the input video
     * @return resolution command
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
            resolutionCommand = "-vf \"scale=" + scale + aspectRatio + scale + ":-1:-1:color=white\"";
            return resolutionCommand;
        }
        return "";
    }

    /**
     * Generates a json file with the output video metadata
     */
    private void generateMetaDataJsonFormat() {
        String startCommand = "ffprobe -v quiet -print_format json -show_format -show_streams ";
        String outputCommand = pathOutput + output + "\"" + " > " + pathOutput + output + ".json\"";
        String jsonCommand = startCommand + outputCommand;
        System.out.println(jsonCommand);
        try {
            Process petition = Runtime.getRuntime().exec("cmd /c" + jsonCommand);
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
        String tumbnailCommand;
        if (tumbnail) {
            tumbnailCommand = " -ss 00:00:01 -vframes 1 " + pathOutput + "VideoTumbnail.png\"";
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
        String audioCommand;
        if (audio) {
            audioCommand = "-an ";
            return audioCommand;
        }
        return "";
    }

    /**
     * Changes the input video frame rate
     * @return frame command
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
     * Sets the output file name
     * @param newOutputFileName String with the output file name
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets the output file name
     * @return outputFileName
     */
    public String getOutputFileName() {
        return outputFileName;
    }
}
