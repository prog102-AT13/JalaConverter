/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.service;

import org.springframework.stereotype.Service;

@Service
public final class AudioConverter {
    private String format = "";
    private String bitrate = "";
    private String hz = "";
    private String volume = "";
    private String outputFileName = "";
    private RunCommand runCommand = new RunCommand();
    private final int ONE_HUNDRED = 1000;
    private final String K20_HERTZ = "20";
    private final String K44_HERTZ = "44";
    private final String K48_HERTZ = "48";

    /**
     * Create command for audio converter
     * @param pathFile
     */
    public void audioConverter(final String pathFile) {
        String relativePath = "cd archive/ && ";
        String ffmpeg = "ffmpeg -i ";
        String bitrate = formatBitrate();
        String hz = formatHz();
        String volume = formatVolume();
        String input = pathFile.substring(pathFile.lastIndexOf("\\") + 1);
        setOutputFileName(pathFile.substring((pathFile.lastIndexOf("\\") + 1), pathFile.lastIndexOf(".") + 1) + getFormat());
        String overwrite = " -y";
        String command = relativePath + ffmpeg + input + bitrate + hz + volume + getOutputFileName() + overwrite;
        System.out.println(command);
        runCommand.run(command);
    }
    /**
     * Set new outputFileName of the audio converter
     * @param newOutputFileName
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }
    /**
     * This is name the output filename
     * @return a string of output filename
     */
    public String getOutputFileName() {
        return this.outputFileName;
    }

    /**
     * Create parameter for volume
     * @return a string with format for volume
     */
    private String formatVolume() {
        if (!getVolume().equals("") && !getVolume().equals("1")) {
            return " -filter:a 'volume=" + getVolume() + "' ";
        }
        return "";
    }

    /**
     * Create parameter for Hz
     * @return a string with format for hz
     */
    private String formatHz() {
        if (!getHz().equals("")) {
            if (getHz().equals(K20_HERTZ)){
                return " -ar 22050 ";
            }
            if (getHz().equals(K44_HERTZ)){
                return " -ar 44100 ";
            }
            if (getHz().equals(K48_HERTZ)){
                return " -ar 48000 ";
            }
        }
        return "";
    }

    /**
     * Create parameter for bitrate
     * @return a string with format for bitrate
     */
    private String formatBitrate() {
        if (!getBitrate().equals("")) {
            return " -ab " + (Integer.parseInt(getBitrate()) * ONE_HUNDRED) + " ";
        }
        return "";
    }

    /**
     * Obtain format of audio converter
     * @return a string of format of audio converter
     */
    private String getFormat() {
        return format;
    }

    /**
     * Set new format of the audio converter
     * @param newFormat
     */
    public void setFormat(final String newFormat) {
        this.format = newFormat;
    }
    /**
     * Obtain bitrate of audio converter
     * @return a string of bitrate of audio converter
     */
    public String getBitrate() {
        return bitrate;
    }

    /**
     * Set new bitrate of the audio converter
     * @param newBitrate
     */
    public void setBitrate(final String newBitrate) {
        this.bitrate = newBitrate;
    }
    /**
     * Obtain volume of audio converter
     * @return a string of volume of audio converter
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Set new volume of the audio converter
     * @param newVolume
     */
    public void setVolume(final String newVolume) {
        this.volume = newVolume;
    }
    /**
     * Obtain hz of audio converter
     * @return a string of hz of audio converter
     */
    public String getHz() {
        return hz;
    }

    /**
     * Set new Hz of the audio converter
     * @param newHz
     */
    public void setHz(final String newHz) {
        this.hz = newHz;
    }
}
