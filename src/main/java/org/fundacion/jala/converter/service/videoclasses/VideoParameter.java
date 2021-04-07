/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.videoclasses;

public class VideoParameter {
    private String inputPath;
    private String outputFormat;
    private String resolution;
    private boolean tumbnail;
    private static final int FRAME_R_DEFAULT = 30;
    private int frameRate = FRAME_R_DEFAULT;
    private int width;
    private int height;
    private boolean audio;
    private boolean metaData;

    /**
     * Sets the name of the input video
     * @param newInputPath String with the input path
     */
    public void setInputPath(final String newInputPath) {
        this.inputPath = newInputPath;
    }

    /**
     * Sets the name of the output video
     * @param newOutputFormat String with the output format
     */
    public void setOutputFormat(final String newOutputFormat) {
        this.outputFormat = newOutputFormat;
    }

    /**
     * Sets the resolution of the output video
     * @param newResolution String with the video resolution
     */
    public void setResolution(final String newResolution) {
        this.resolution = newResolution;
    }

    /**
     * Sets the width of the output video
     * @param newWidth int with the video width
     */
    public void setWidth(final int newWidth) {
        this.width = newWidth;
    }

    /**
     * Sets the height of the output video
     * @param newHeight int with the video height
     */
    public void setHeight(final int newHeight) {
        this.height = newHeight;
    }

    /**
     * Sets the audio of the output video
     * @param newAudio boolean that indicates if the video has to have audio or not
     */
    public void setAudio(final boolean newAudio) {
        this.audio = newAudio;
    }

    /**
     * Sets the frame rate of the output video
     * @param newFrameRate int with the video frame rate
     */
    public void setFrameRate(final int newFrameRate) {
        this.frameRate = newFrameRate;
    }

    /**
     * Sets the tumbnail of the output video
     * @param newTumbnail boolean that indicates if the video has to have tumbnail
     */
    public void setTumbnail(final boolean newTumbnail) {
        this.tumbnail = newTumbnail;
    }

    /**
     * Sets the width of the output video
     * @param newMetaData boolean that indicates if the video has to have metadata file
     */
    public void setMetaData(final boolean newMetaData) {
        this.metaData = newMetaData;
    }

    /**
     * Gets the name of the input video
     */
    public String getInputPath() {
        return inputPath;
    }

    /**
     * Gets the name of the output video
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Gets the resolution of the output video
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Gets the width of the output video
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the output video
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the audio of the output video
     */
    public boolean hasAudio() {
        return audio;
    }

    /**
     * Gets the frame rate of the output video
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Gets the tumbnail of the output video
     */
    public boolean hasTumbnail() {
        return tumbnail;
    }

    /**
     * Gets the metadata of the output video
     */
    public boolean hasMetaData() {
        return metaData;
    }
}
