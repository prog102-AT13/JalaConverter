package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.ImageParameter;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ImageConverterTest {

    private static String rutePath() {
        String path = System.getProperty("user.dir");
        String pathResource = "\\archive";
        String resourceDir = path + File.separator + pathResource + File.separator;
        return resourceDir;
    }

    @Test
    public void getOutputFilenameTest() {
        ImageParameter imageParameter = new ImageParameter();
        imageParameter.setFilePath("/file.ext");
        ImageConverter imageConverter = new ImageConverter(imageParameter);
        imageConverter.setOutputFileName("file.ext");
        String expected = "file.ext";
        String actual = imageConverter.getOutputFileName();
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldCreateTheConvertedFile() throws ConverterException {
        ImageParameter imageParameter = new ImageParameter(rutePath() + "imageTest.jpg", "png",
                320, true);
        ImageConverter imageConverter = new ImageConverter(imageParameter);
        imageConverter.convertImage();
        File file = new File(rutePath() + "imageTest.jpg");
        assertTrue(file.exists());
    }

    @Test
    public void ItShouldSetGrayScale() {
        ImageParameter imageParameter = new ImageParameter(rutePath() + "imageTest.jpg", "png",
                320, true);
        imageParameter.setGrayScale(false);
        boolean expected = imageParameter.hasGrayScale();
        assertFalse(expected);
    }

    @Test
    public void ItShouldSetWidth() {
        ImageParameter imageParameter = new ImageParameter(rutePath() + "imageTest.jpg", "png",
                320, true);
        imageParameter.setWidth(640);
        int actual = imageParameter.getWidth();
        int expected = 640;
        assertEquals(actual, expected);
    }

    @Test
    public void ItShouldSetOutputFormat() {
        ImageParameter imageParameter = new ImageParameter(rutePath() + "imageTest.jpg", "png",
                320, true);
        imageParameter.setOutputFormat("jpeg");
        String actual = imageParameter.getOutputFormat();
        String expected = "jpeg";
        assertEquals(actual, expected);
    }
}