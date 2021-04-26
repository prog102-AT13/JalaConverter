/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */
package org.fundacion.jala.converter.core.parameter;

import org.springframework.stereotype.Service;

/**
 * This class has the options of the audio parameters.
 */
@Service
public class AudioParameter extends Parameter {
    private String format;
    private String bitrate;
    private String frecuency;
    private String volume;
    private String audioChannels;
    private final int ONE_HUNDRED = 1000;
    private final String K20_HERTZ = "20";
    private final String K44_HERTZ = "44";
    private final String K48_HERTZ = "48";
    private final String MONO_CHANNEL = "1";
    private final String STEREO_CHANNEL = "2";
    private final String TWO_POINT_ONE_CHANNEL = "3";
    private final String FOUR_POINT_ZERO_CHANNEL = "4";
    private final String FIVE_POINT_ZERO_CHANNEL = "5";
    private final String FIVE_POINT_ONE_CHANNEL = "6";
    private final String SIX_POINT_ONE_CHANNEL = "7";
    private final String SEVEN_POINT_ONE_CHANNEL = "8";

    public AudioParameter() {
    }

    public AudioParameter(final String newFilePath, final String newFormat,
                          final String newBitrate, final String newFrecuency, final String newVolume,
                          final String newAudioChannels) {
        super(newFilePath);
        this.format = newFormat;
        this.bitrate = newBitrate;
        this.frecuency = newFrecuency;
        this.volume = newVolume;
        this.audioChannels = newAudioChannels;
    }

    /**
     * Creates a parameter for volume.
     *
     * @return a string with format for volume.
     */
    public String formatVolume() {
        if (!getVolume().equals("") && !getVolume().equals("1")) {
            return " -filter:a 'volume=" + getVolume() + "' ";
        }
        return "";
    }

    /**
     * Creates a parameter for frecuency.
     *
     * @return a string with format for frecuency in hz.
     */
    public String formatHz() {
        if (!getFrecuency().equals("")) {
            if (getFrecuency().equals(K20_HERTZ)) {
                return " -ar 22050 ";
            }
            if (getFrecuency().equals(K44_HERTZ)) {
                return " -ar 44100 ";
            }
            if (getFrecuency().equals(K48_HERTZ)) {
                return " -ar 48000 ";
            }
        }
        return "";
    }

    /**
     * Creates a parameter for bitrate.
     *
     * @return a string with format for bitrate.
     */
    public String formatBitrate() {
        if (!getBitrate().equals("")) {
            return " -ab " + (Integer.parseInt(getBitrate()) * ONE_HUNDRED) + " ";
        }
        return "";
    }

    /**
     * Gets the audio channels.
     *
     * @return a String with the value.
     */
    public String getAudioChannels() {
        return audioChannels;
    }

    /**
     * Sets the new audio channels.
     *
     * @param newAudioChannels the value to set.
     */
    public void setAudioChannels(final String newAudioChannels) {
        this.audioChannels = newAudioChannels;
    }

    /**
     * Creates a parameter for audio channels.
     *
     * @return a String with format for audio channels.
     */
    public String formatAudioChannel() {
        switch (getAudioChannels()) {
            case "mono":
                return " -ac " + MONO_CHANNEL + " ";
            case "stereo":
                return " -ac " + STEREO_CHANNEL + " ";
            case "2.1":
                return " -ac " + TWO_POINT_ONE_CHANNEL + " ";
            case "4.0":
                return " -ac " + FOUR_POINT_ZERO_CHANNEL + " ";
            case "5.0":
                return " -ac " + FIVE_POINT_ZERO_CHANNEL + " ";
            case "5.1":
                return " -ac " + FIVE_POINT_ONE_CHANNEL + " ";
            case "6.1":
                return " -ac " + SIX_POINT_ONE_CHANNEL + " ";
            case "7.1":
                return " -ac " + SEVEN_POINT_ONE_CHANNEL + " ";
            default:
                return "";
        }
    }

    /**
     * Obtains the format of audio converter.
     *
     * @return a string of format of audio converter.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets new format of the audio converter.
     *
     * @param newFormat is a new format to audio.
     */
    public void setFormat(final String newFormat) {
        this.format = newFormat;
    }

    /**
     * Obtains bitrate of audio converter.
     *
     * @return a string of bitrate of audio converter.
     */
    public String getBitrate() {
        return bitrate;
    }

    /**
     * Sets new bitrate of the audio converter.
     *
     * @param newBitrate is a new bit rate to the audio.
     */
    public void setBitrate(final String newBitrate) {
        this.bitrate = newBitrate;
    }

    /**
     * Obtains volume of audio converter.
     *
     * @return a string of volume of audio converter.
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Sets new volume of the audio converter.
     *
     * @param newVolume is a new volumen to the audio.
     */
    public void setVolume(final String newVolume) {
        this.volume = newVolume;
    }

    /**
     * Obtains the frecuency of audio converter.
     *
     * @return a string of frecuency of audio converter.
     */
    public String getFrecuency() {
        return frecuency;
    }

    /**
     * Sets new frecuency of the audio converter.
     *
     * @param newFrecuency is a new frecuency of the audio.
     */
    public void setFrecuency(final String newFrecuency) {
        this.frecuency = newFrecuency;
    }
}
