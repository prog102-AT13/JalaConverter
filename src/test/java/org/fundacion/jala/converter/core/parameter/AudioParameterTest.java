package org.fundacion.jala.converter.core.parameter;

import org.fundacion.jala.converter.core.AudioConverter;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */

public class AudioParameterTest {

    @Test
    public void ItShouldReturnVariables() {
        AudioParameter audioParameter = new AudioParameter("path", "format", "bitrate", "frequency", "volume", "audioChannels");
        String expected = "format";
        String actual = audioParameter.getFormat();
        assertEquals(expected, actual);
    }

    @Test
    public void getFilepathTest() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFilePath("path");
        String expected = "path";
        String actual = audioParameter.getFilePath();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnFormatVolumeCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setVolume("2");
        String expected = " -filter:a \"volume=2\" ";
        String actual = audioParameter.formatVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnEmptyFrequencyCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFrequency("");
        String expected = "";
        String actual = audioParameter.formatHz();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnLowFrequencyCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFrequency("20");
        String expected = " -ar 22050 ";
        String actual = audioParameter.formatHz();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnMediumFrequencyCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFrequency("44");
        String expected = " -ar 44100 ";
        String actual = audioParameter.formatHz();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnHighFrequencyCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFrequency("48");
        String expected = " -ar 48000 ";
        String actual = audioParameter.formatHz();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnFormatBitrateCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setBitrate("64");
        String expected = " -ab " + 64 * 1000 +" ";
        String actual = audioParameter.formatBitrate();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnEmptyAudioChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("unavailable");
        String expected = "";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnOneChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("mono");
        String expected = " -ac 1 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnTwoChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("stereo");
        String expected = " -ac 2 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnThreeChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("2.1");
        String expected = " -ac 3 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnFourChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("4.0");
        String expected = " -ac 4 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnFiveChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("5.0");
        String expected = " -ac 5 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnSixChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("5.1");
        String expected = " -ac 6 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnSevenChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("6.1");
        String expected = " -ac 7 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldReturnEightChannelCommand() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setAudioChannels("7.1");
        String expected = " -ac 8 ";
        String actual = audioParameter.formatAudioChannel();
        assertEquals(expected, actual);
    }
}