/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class AudioConverter {
    private String format = "";
    private String bitrate = "";
    private String hz = "";
    private String volume = "";
    private RunCommand runCommand = new RunCommand();

    public String audioConverter(final String file) {
        String ffmpeg = "ffmpeg -i";
        String bitrate = formatBitrate();
        String hz = formatHz();
        String volume = formatVolume();
        String output = file.substring((file.lastIndexOf("/") + 1),file.lastIndexOf(".")+1) + this.format;
        String overwrite = " -y";
        String command = ffmpeg + file + bitrate + hz + volume + file + output + overwrite;
        runCommand.run(command);
        System.out.println(command);
        return command;
    }

    public String formatVolume(){
        if(!getBitrate().equals("")) {
            return " -filter:a 'volume=" + getVolume() + "' ";
        }
        return "";
    }

    public String formatHz(){
        if(!getBitrate().equals("")) {
            return " -ar " + (Integer.parseInt(getHz()) * 1000) + " ";
        }
        return "";
    }

    public String formatBitrate() {
        if(!getBitrate().equals("")) {
            return " -ab " + (Integer.parseInt(getBitrate()) * 1000) + " ";
        }
        return "";
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }


    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getHz() {
        return hz;
    }

    public void setHz(String hz) {
        this.hz = hz;
    }

}
