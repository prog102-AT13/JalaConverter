package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.junit.Test;

import static org.junit.Assert.*;

public class VideoConverterTest {

    @Test
    public void convertVideoShouldCreateConvertedFile() {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/Perrito.mp4";
        VideoConverter videoConverter = new VideoConverter(new VideoParameter(filePath, "mpeg", "720", true, 30, 1280, 720, false));
        String actual = videoConverter.getResult().getFilename();
        String expected = "Perrito.mpeg";
        assertEquals(expected, actual);
    }

    @Test(expected = ConverterException.class)
    public void convertVideoShouldThrowConverterExceptionWithNullParameter() throws ConverterException {
        VideoConverter videoConverter = new VideoConverter(null);
        videoConverter.convertVideo();
    }

    @Test(expected = ConverterException.class)
    public void convertVideoShouldThrowConverterExceptionWithEmptyFilePath() throws ConverterException {
        VideoConverter videoConverter = new VideoConverter(new VideoParameter("", "mpeg", "720", true, 30, 1280, 720, false));
        videoConverter.convertVideo();
    }
}