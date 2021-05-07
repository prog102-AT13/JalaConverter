/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ZipException;
import org.junit.AfterClass;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;
import static org.fundacion.jala.converter.core.ZipService.zipProcess;
import static org.fundacion.jala.converter.core.ZipService.zipFile;
import static org.fundacion.jala.converter.core.ZipService.zipFiles;
import static org.junit.Assert.assertTrue;

public class ZipServiceTest {

    private static String rutePath() {
        String path = System.getProperty("user.dir");
        String pathResource = "\\src\\test\\resource";
        String resourceDir = path + File.separator + pathResource + File.separator;
        return resourceDir;
    }

    @AfterClass
    public static void deleteFile() {
        File zipArchive = new File(rutePath() + "archive1.zip");
        File zipProcess = new File(rutePath() + "process.zip");
        File zipFail = new File(rutePath() + "fail.zip");
        File zipArchives = new File(rutePath() + "archives.zip");
        zipArchives.delete();
        zipArchive.delete();
        zipFail.delete();
        zipProcess.delete();
    }

    @Test
    public void itShouldCreateZip() throws FileNotFoundException, ZipException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(rutePath() + "process.zip"));
        zipProcess(rutePath() + "archive1.txt", zipOutputStream);
        File file = new File(rutePath() + "process.zip");
        assertTrue(file.exists());
    }

    @Test(expected = ZipException.class)
    public void itShouldThrowExceptionToZipProcess() throws FileNotFoundException, ZipException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(rutePath() + "fail.zip"));
        zipProcess("\\resource&Test\\ archive1.txt", zipOutputStream);
    }

    @Test
    public void itShouldCreateZipWithOnlyFileInside() throws ZipException {
        zipFile(rutePath() + "archive1.txt", rutePath() + "archive1.zip");
        File file = new File(rutePath() + "archive1.zip");
        assertTrue(file.exists());
    }

    @Test(expected = ZipException.class)
    public void itShouldThrowsZipExceptionWhenCreateZipWithOnlyFileWithInvalidPath() throws ZipException {
        ZipService zipService = new ZipService();
        zipService.zipFile(rutePath() + "archive1.txt", "\\resourceTest");
    }

    @Test
    public void itShouldCreateZipWithTwoFileInside() throws ZipException {
        ArrayList<String> zipList = new ArrayList<>();
        zipList.add(rutePath() + "archive1.txt");
        zipList.add(rutePath() + "archive2.txt");
        zipFiles(zipList, rutePath() + "archives.zip");
        File file = new File(rutePath() + "archives.zip");
        assertTrue(file.exists());
    }

    @Test(expected = ZipException.class)
    public void itShouldThrowsZipExceptionWhenCreateZipWithTwoFileWithInvalidOutPutPath() throws ZipException {
        ArrayList<String> zipList = new ArrayList<>();
        zipList.add(rutePath() + "archive1.txt");
        zipList.add(rutePath() + "archive2.txt");
        zipFiles(zipList, "\\resource34Test\\archivesFailt.zip");
    }

    @Test(expected = ZipException.class)
    public void itShouldThrowsZipExceptionWhenCreateZipWithTwoFileWithInvalidPathFile() throws ZipException {
        ArrayList<String> zipList = new ArrayList<>();
        zipList.add(rutePath() + "archive1.txt");
        zipList.add(rutePath() + "archive2d.txt");
        zipFiles(zipList, "\\resource34Test\\archivesFailt.zip");
    }
}
