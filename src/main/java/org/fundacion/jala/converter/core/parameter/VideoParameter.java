/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
/**
 * @author Daniela Santa Cruz
 * @colaborathor Paola Aguilar
 */
package org.fundacion.jala.converter.core.parameter;

public class VideoParameter extends Parameter {
    private String outputFormat;
    private String resolution;
    private boolean thumbnail;
    private static final int FRAME_R_DEFAULT = 30;
    private int frameRate = FRAME_R_DEFAULT;
    private int width;
    private int height;
    private boolean audio;

    public VideoParameter() { }

    public VideoParameter(final String filePath, final String newOutputFormat, final String newResolution,
                          final boolean newThumbnail, final int newFrameRate, final int newWidth,
                          final int newHeight, final boolean newAudio) {
        super(filePath);
        this.outputFormat = newOutputFormat;
        this.resolution = newResolution;
        this.thumbnail = newThumbnail;
        this.frameRate = newFrameRate;
        this.width = newWidth;
        this.height = newHeight;
        this.audio = newAudio;
    }

    /**
     * Sets the name of the output video.
     * @param newOutputFormat String with the output format
     */
    public void setOutputFormat(final String newOutputFormat) {
        this.outputFormat = newOutputFormat;
    }

    /**
     * Sets the resolution of the output video.
     * @param newResolution String with the video resolution
     */
    public void setResolution(final String newResolution) {
        this.resolution = newResolution;
    }

    /**
     * Sets the width of the output video.
     * @param newWidth int with the video width
     */
    public void setWidth(final int newWidth) {
        this.width = newWidth;
    }

    /**
     * Sets the height of the output video.
     * @param newHeight int with the video height
     */
    public void setHeight(final int newHeight) {
        this.height = newHeight;
    }

    /**
     * Sets the audio of the output video.
     * @param newAudio boolean that indicates if the video needs audio
     */
    public void setAudio(final boolean newAudio) {
        this.audio = newAudio;
    }

    /**
     * Sets the frame rate of the output video.
     * @param newFrameRate int with the video frame rate
     */
    public void setFrameRate(final int newFrameRate) {
        this.frameRate = newFrameRate;
    }

    /**
     * Sets the thumbnail of the output video.
     * @param newThumbnail boolean that indicates if the video needs thumbnail
     */
    public void setThumbnail(final boolean newThumbnail) {
        this.thumbnail = newThumbnail;
    }

    /**
     * Gets the name of the output video.
     * @return outputFormat
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Gets the resolution of the output video.
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Gets the width of the output video.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the output video.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the audio of the output video.
     * @return audio
     */
    public boolean hasAudio() {
        return audio;
    }

    /**
     * Gets the frame rate of the output video.
     * @return frame rate
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Gets the thumbnail of the output video.
     * @return thumbnail
     */
    public boolean hasThumbnail() {
        return thumbnail;
    }

}
