package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class VideoConverterTest {

    @Test
    public void convertVideoShouldCreateConvertedFile() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/archive/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(new File(filePath).getAbsolutePath(), "mpeg",
                "720", true, 30, 1280, 720, false);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "Perrito.mpeg";
        assertEquals(expected, actual);
    }

    @Test(expected = ConverterException.class)
    public void convertVideoShouldThrowConverterExceptionWithNullParameter() throws ConverterException {
        VideoConverter videoConverter = new VideoConverter(null);
        videoConverter.convertVideo();
    }
}