package org.fundacion.jala.converter.core;

import org.checkerframework.checker.units.qual.A;
import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.junit.AfterClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

public class AudioConverterTest {

    private static String rutePath() {
        String path = System.getProperty("user.dir");
        String pathResource = "\\archive";
        String resourceDir = path + File.separator + pathResource + File.separator;
        return resourceDir;
    }

    @AfterClass
    public static void deleteFile() {
        File audioTest = new File(rutePath() + "audioTest.avi");
        audioTest.delete();
    }

    @Test
    public void getOutputFilenameTest() {
        AudioParameter audioParameter = new AudioParameter();
        audioParameter.setFilePath("/file.ext");
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.setOutputFileName("file.ext");
        String expected = "file.ext";
        String actual = audioConverter.getOutputFileName();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldCreateTheConvertedFile() {
        AudioParameter audioParameter = new AudioParameter(rutePath() + "audioTest.mp3", "avi", "164", "44", "2", "mono");
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter();
        File file = new File(rutePath() + "audioTest.avi");
        assertTrue(file.exists());
    }
}