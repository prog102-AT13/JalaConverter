package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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