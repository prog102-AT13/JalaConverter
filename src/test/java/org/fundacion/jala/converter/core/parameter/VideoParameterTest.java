package org.fundacion.jala.converter.core.parameter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class VideoParameterTest {

    @Test
    public void setOutputFormatShouldChangeOutputValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setOutputFormat("avi");
        String actual = videoParameter.getOutputFormat();
        String expected = "avi";
        assertEquals(expected, actual);
    }

    @Test
    public void setResolutionShouldChangeResolutionValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setResolution("1080");
        String actual = videoParameter.getResolution();
        String expected = "1080";
        assertEquals(expected, actual);
    }

    @Test
    public void setWidthShouldChangeWidthValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setWidth(720);
        int actual = videoParameter.getWidth();
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void setHeightShouldChangeHeightValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setHeight(360);
        int actual = videoParameter.getHeight();
        int expected = 360;
        assertEquals(expected, actual);
    }

    @Test
    public void setFrameRateShouldChangeFrameRateValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setFrameRate(60);
        int actual = videoParameter.getFrameRate();
        int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    public void getOutputFormatShouldReturnOutputFormat() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        String actual = videoParameter.getOutputFormat();
        String expected = "mpeg";
        assertEquals(expected, actual);
    }

    @Test
    public void getResolutionShouldReturnResolution() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        String actual = videoParameter.getResolution();
        String expected = "720";
        assertEquals(expected, actual);
    }

    @Test
    public void getWidthShouldReturnWidth() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getWidth();
        int expected = 1280;
        assertEquals(expected, actual);
    }

    @Test
    public void getHeightShouldReturnHeight() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getHeight();
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void hasAudioShouldReturnAudio() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        boolean actual = videoParameter.hasAudio();
        assertFalse(actual);
    }

    @Test
    public void getFrameRateShouldReturnFrameRate() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getFrameRate();
        int expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    public void hasThumbnailShouldReturnThumbnail() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        boolean actual = videoParameter.hasThumbnail();
        assertTrue(actual);
    }
}