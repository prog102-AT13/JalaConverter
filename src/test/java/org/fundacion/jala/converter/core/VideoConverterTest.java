package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class VideoConverterTest {

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
    public void convertVideoShouldCreateConvertedFile() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/archive";
        String videoPath = filePath + "/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(videoPath, "mpeg",
                "720", true, 30, 1280, 720, false);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "JalaConverter/src/test/resources/archive/Perrito.mpeg";
        File videoFile = new File(filePath + "/Perrito.mpeg");
        File thumbnailFile = new File(filePath + "/Perrito.png");
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void convertVideoShouldThrowConverterExceptionWithNullParameter() throws ConverterException {
        VideoConverter videoConverter = new VideoConverter(null);
        videoConverter.convertVideo();
    }
}