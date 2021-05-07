package org.fundacion.jala.converter.core;

import org.checkerframework.checker.units.qual.A;
import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.junit.Test;
import org.mockito.Mockito;

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

//    @Test
//    public void convertAudioTest() {
//        RunCommand runCommand = new RunCommand();
//        AudioConverter audioConverter = mock(AudioConverter.class);
//        //Person person = ObjectCreator.getPerson();
//        String command = "command";
//        doNothing().when(runCommand).run(command);
//        audioConverter.audioConverter();
//        verify(runCommand,times(1)).run(command);
//    }
}