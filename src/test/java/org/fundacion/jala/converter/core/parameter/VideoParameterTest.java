package org.fundacion.jala.converter.core.parameter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class VideoParameterTest {

    @Test
    public void shouldChangeOutputValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setOutputFormat("avi");
        String actual = videoParameter.getOutputFormat();
        String expected = "avi";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeResolutionValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setResolution("1080");
        String actual = videoParameter.getResolution();
        String expected = "1080";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeWidthValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setWidth(720);
        int actual = videoParameter.getWidth();
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeHeightValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setHeight(360);
        int actual = videoParameter.getHeight();
        int expected = 360;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeFrameRateValue() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        videoParameter.setFrameRate(60);
        int actual = videoParameter.getFrameRate();
        int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnOutputFormat() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        String actual = videoParameter.getOutputFormat();
        String expected = "mpeg";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnResolution() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        String actual = videoParameter.getResolution();
        String expected = "720";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnWidth() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getWidth();
        int expected = 1280;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHeight() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getHeight();
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAudio() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        boolean actual = videoParameter.hasAudio();
        assertFalse(actual);
    }

    @Test
    public void shouldReturnFrameRate() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        int actual = videoParameter.getFrameRate();
        int expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnThumbnail() {
        VideoParameter videoParameter = new VideoParameter("resources/archive/Perrito.mp4", "mpeg",
                "720", true, 30, 1280, 720, false);
        boolean actual = videoParameter.hasThumbnail();
        assertTrue(actual);
    }
}
