/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.service;

public final class AudioConverter {
    private String format = "";
    private String bitrate = "";
    private String hz = "";
    private String volume = "";
    private RunCommand runCommand = new RunCommand();
    private final int ONE_HUNDRED = 1000;

    /**
     * Create command for audio converter
     * @param pathFile
     */
    public void audioConverter(final String pathFile) {
        String adaptedPath = "'" + pathFile + "'";
        String ffmpeg = "ffmpeg -i ";
        String bitrate = formatBitrate();
        String hz = formatHz();
        String volume = formatVolume();
        String output = adaptedPath.substring((adaptedPath.lastIndexOf("/") + 1), adaptedPath.lastIndexOf(".") + 1) + getFormat() + "'";
        String pathOutput = adaptedPath.substring(0, (adaptedPath.lastIndexOf("storage"))) + "output/";
        String overwrite = " -y";
        String command = ffmpeg + adaptedPath + bitrate + hz + volume + pathOutput + output + overwrite;
        System.out.println(command);
        runCommand.run(command);
    }

    /**
     * Create parameter for volume
     * @return
     */
    private String formatVolume() {
        if (!getVolume().equals("") && !getVolume().equals("1")) {
            return " -filter:a 'volume=" + getVolume() + "' ";
        }
        return "";
    }

    /**
     * Create parameter for Hz
     * @return
     */
    private String formatHz() {
        if (!getHz().equals("")) {
            if (getHz().equals("20")){
                return " -ar 22050 ";
            }
            if (getHz().equals("44")){
                return " -ar 44100 ";
            }
            if (getHz().equals("48")){
                return " -ar 48000 ";
            }
        }
        return "";
    }

    /**
     * Create parameter for bitrate
     * @return
     */
    private String formatBitrate() {
        if (!getBitrate().equals("")) {
            return " -ab " + (Integer.parseInt(getBitrate()) * ONE_HUNDRED) + " ";
        }
        return "";
    }

    private String getFormat() {
        return format;
    }

    public void setFormat(final String newFormat) {
        this.format = newFormat;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(final String newBitrate) {
        this.bitrate = newBitrate;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(final String newVolume) {
        this.volume = newVolume;
    }

    public String getHz() {
        return hz;
    }

    public void setHz(final String newHz) {
        this.hz = newHz;
    }
}
