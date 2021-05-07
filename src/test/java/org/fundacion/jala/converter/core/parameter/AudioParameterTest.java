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
    public void getFilepathTest() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFilePath("path");
        String expected = "path";
        String actual = audioParameter.getFilePath();
        assertEquals(expected, actual);
    }
    @Test
    public void formatVolumeTest() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setVolume("2");
        String expected = " -filter:a \"volume=2\" ";
        String actual = audioParameter.formatVolume();
        assertEquals(expected, actual);
    }
}