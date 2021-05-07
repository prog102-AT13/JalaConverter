package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.VideoParameter;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;

public class VideoConverterTest {

    @Test
    public void shouldCreateConvertedFileWithThumbnail() throws ConverterException {
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

    @Test
    public void shouldCreateConvertedFileWithoutThumbnail() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/archive";
        String videoPath = filePath + "/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(videoPath, "mpeg",
                "720", false, 30, 1280, 720, false);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "JalaConverter/src/test/resources/archive/Perrito.mpeg";
        File videoFile = new File(filePath + "/Perrito.mpeg");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateConvertedFileWithFrameRateChanged() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/archive";
        String videoPath = filePath + "/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(videoPath, "mpeg",
                "720", false, 60, 1280, 720, false);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "JalaConverter/src/test/resources/archive/Perrito.mpeg";
        File videoFile = new File(filePath + "/Perrito.mpeg");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateConvertedFileWithResolutionChanged() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/archive";
        String videoPath = filePath + "/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(videoPath, "mpeg",
                "720", false, 30, 720, 360, false);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "JalaConverter/src/test/resources/archive/Perrito.mpeg";
        File videoFile = new File(filePath + "/Perrito.mpeg");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateConvertedFileWithoutAudio() throws ConverterException {
        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/archive";
        String videoPath = filePath + "/Perrito.mp4";
        VideoParameter videoParameter = new VideoParameter(videoPath, "mpeg",
                "720", false, 30, 720, 360, true);
        VideoConverter videoConverter = new VideoConverter(videoParameter);
        videoConverter.convertVideo();
        String actual = videoConverter.getOutputFileName();
        String expected = "JalaConverter/src/test/resources/archive/Perrito.mpeg";
        File videoFile = new File(filePath + "/Perrito.mpeg");
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowConverterExceptionWithNullParameter() throws ConverterException {
        VideoConverter videoConverter = new VideoConverter(null);
        videoConverter.convertVideo();
    }
}
