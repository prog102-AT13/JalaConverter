/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.core.parameter;

/**
 * This class are the options for the audio parameters.
 */
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
     *
     * @param newOutputFormat is a String with the output format.
     */
    public void setOutputFormat(final String newOutputFormat) {
        this.outputFormat = newOutputFormat;
    }

    /**
     * Sets the resolution of the output video.
     *
     * @param newResolution is a String with the video resolution.
     */
    public void setResolution(final String newResolution) {
        this.resolution = newResolution;
    }

    /**
     * Sets the width of the output video.
     *
     * @param newWidth is a int with the video width.
     */
    public void setWidth(final int newWidth) {
        this.width = newWidth;
    }

    /**
     * Sets the height of the output video.
     *
     * @param newHeight is a int with the video height
     */
    public void setHeight(final int newHeight) {
        this.height = newHeight;
    }

    /**
     * Sets the audio of the output video.
     *
     * @param newAudio is a boolean that indicates if the video needs audio.
     */
    public void setAudio(final boolean newAudio) {
        this.audio = newAudio;
    }

    /**
     * Sets the frame rate of the output video.
     *
     * @param newFrameRate is a int with the video frame rate.
     */
    public void setFrameRate(final int newFrameRate) {
        this.frameRate = newFrameRate;
    }

    /**
     * Sets the thumbnail of the output video.
     *
     * @param newThumbnail is a boolean that indicates if the video needs thumbnail.
     */
    public void setThumbnail(final boolean newThumbnail) {
        this.thumbnail = newThumbnail;
    }

    /**
     * Gets the name of the output video.
     *
     * @return output Format of the video file.
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Gets the resolution of the output video.
     *
     * @return resolution of the video file.
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Gets the width of the output video.
     *
     * @return width of the video file.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the output video.
     *
     * @return height of the video file.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the audio of the output video.
     *
     * @return audio of the video file.
     */
    public boolean hasAudio() {
        return audio;
    }

    /**
     * Gets the frame rate of the output video.
     *
     * @return frame rate of the video file.
     */
    public int getFrameRate() {
        return frameRate;
    }

    /**
     * Gets the thumbnail of the output video.
     *
     * @return thumbnail of the video file.
     */
    public boolean hasThumbnail() {
        return thumbnail;
    }
}
