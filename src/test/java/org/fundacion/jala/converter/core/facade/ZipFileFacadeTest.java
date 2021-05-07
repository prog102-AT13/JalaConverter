package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.exceptions.ZipException;
import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.fundacion.jala.converter.core.facade.ZipFileFacade.getZipFileAudio;
import static org.fundacion.jala.converter.core.facade.ZipFileFacade.getZipFileVideo;
import static org.junit.Assert.*;

public class ZipFileFacadeTest {

    private static String rutePath() {
        String path = System.getProperty("user.dir");
        String pathResource = "\\src\\test\\resource";
        return path + File.separator + pathResource + File.separator;
    }

    public void copyFile(String fileName) throws IOException {
        File from = new File(rutePath() + "reserves\\" + fileName);
        File to = new File(rutePath() + fileName);
        Files.copy(from.toPath(), to.toPath());
    }

    @After
    public void deleteFile() {
        File zipAguinaldo = new File(rutePath() + "aguinaldo.zip");
        File AguinaldoMp3 = new File(rutePath() + "aguinaldo.mp3");
        File AguinaldoMp4 = new File(rutePath() + "aguinaldo.mp4");
        zipAguinaldo.delete();
        AguinaldoMp3.delete();
        AguinaldoMp4.delete();
    }

    @Test(expected = ZipException.class)
    public void ItShouldThrowsZipExceptionWhenDontFilesToZipVideoConvert() throws ZipException, IOException {
        copyFile("aguinaldo.mp4");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as23423df31",
                rutePath() + "aguinaldo.mp4", 1, "aguinaldo.mp4");
        getZipFileVideo(parameterOutputChecksum, true, true, "aguinaldo.mp4");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }

    @Test(expected = ZipException.class)
    public void ItShouldThrowsZipExceptionWhenDontFileToZipAudioConvert() throws ZipException {
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as234df31",
                rutePath() + "aguinaldo.mp3", 1, "aguinaldo.mp3");
        getZipFileAudio(parameterOutputChecksum, false, "aguinaldo.mp3");
    }

    @Test
    public void ItShouldZipFileFromConvertedAudio() throws ZipException, IOException {
        copyFile("aguinaldo.mp3");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as234df31",
                rutePath() + "aguinaldo.mp3", 1, "aguinaldo.mp3");
        getZipFileAudio(parameterOutputChecksum, false, "aguinaldo.mp3");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }

    @Test
    public void ItShouldZipFileAndMetadataFromConvertedAudio() throws ZipException, IOException {
        copyFile("aguinaldo.mp3");
        copyFile("aguinaldo.txt");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as234df31",
                rutePath() + "aguinaldo.mp3", 1, "aguinaldo.mp3");
        getZipFileAudio(parameterOutputChecksum, true, "aguinaldo.mp3");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }

    @Test
    public void ItShouldZipFileFromConvertedVideo() throws ZipException, IOException {
        copyFile("aguinaldo.mp4");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as23423df31",
                rutePath() + "aguinaldo.mp4", 1, "aguinaldo.mp4");
        getZipFileVideo(parameterOutputChecksum, false, false, "aguinaldo.mp4");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }

    @Test
    public void ItShouldZipFileAndThumbnailFromConvertedVideo() throws ZipException, IOException {
        copyFile("aguinaldo.mp4");
        copyFile("aguinaldo.png");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as23423df31",
                rutePath() + "aguinaldo.mp4", 1, "aguinaldo.mp4");
        getZipFileVideo(parameterOutputChecksum, false, true, "aguinaldo.mp4");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }

    @Test
    public void ItShouldZipAllFileToConvertedVideo() throws ZipException, IOException {
        copyFile("aguinaldo.mp4");
        copyFile("aguinaldo.png");
        copyFile("aguinaldo.txt");
        ParameterOutputChecksum parameterOutputChecksum = new ParameterOutputChecksum("as23423df31",
                rutePath() + "aguinaldo.mp4", 1, "aguinaldo.mp4");
        getZipFileVideo(parameterOutputChecksum, true, true, "aguinaldo.mp4");
        File file = new File(rutePath() + "aguinaldo.zip");
        assertTrue(file.exists());
    }
}
