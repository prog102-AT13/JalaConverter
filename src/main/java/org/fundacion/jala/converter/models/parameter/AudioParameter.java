/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales
 * @version 1.0
 */
package org.fundacion.jala.converter.models.parameter;

import org.springframework.stereotype.Service;

@Service
public class AudioParameter extends Parameter {

    private String format;
    private String bitrate;
    private String hz;
    private String volume;
    private String audioChannels;

    public AudioParameter() {
        super();
    }

    public AudioParameter(final String newFilePath) {
        super(newFilePath);
    }

    public AudioParameter(final String newFilePath, final String newFormat, final String newBitrate, final String newHz, final String newVolume, final String newAudioChannels) {
        super(newFilePath);
        this.format = newFormat;
        this.bitrate = newBitrate;
        this.hz = newHz;
        this.volume = newVolume;
        this.audioChannels = newAudioChannels;
    }

    /**
     * @return file's extension
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param newFormat string with the file's extension
     */
    public void setFormat(final String newFormat) {
        this.format = newFormat;
    }

    /**
     * @return a bitrate of the file
     */
    public String getBitrate() {
        return bitrate;
    }

    /**
     * @param newBitrate with the bitrate
     */
    public void setBiteRate(final String newBitrate) {
        this.bitrate = newBitrate;
    }

    /**
     * @return a string with hz
     */
    public String getHz() {
        return hz;
    }

    /**
     * @param newHz a string with hz
     */
    public void setHz(final String newHz) {
        this.hz = newHz;
    }

    /**
     * @return a string with a volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param newVolume a string with a volume
     */
    public void setVolume(final String newVolume) {
        this.volume = newVolume;
    }

    /**
     * @return a string with audi channels
     */
    public String getAudioChannels() {
        return audioChannels;
    }

    /**
     * @param newAudioChannels a string with audi channel
     */
    public void setAudioChannels(final String newAudioChannels) {
        this.audioChannels = newAudioChannels;
    }
}