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

import org.apache.commons.io.IOUtils;
import org.fundacion.jala.converter.core.exceptions.FileStorageException;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.fundacion.jala.converter.core.FileStorageService.getOutputPath;
import static org.fundacion.jala.converter.core.FileStorageService.getOutputPathWithoutFileName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class is unit test for FileStorageService class
 */
public class FileStorageServiceTest {
    FileStorageService fileStorageService = new FileStorageService();

    @Test
    public void uploadFile_MultipartFileRight_path() throws IOException, FileStorageException {
        File file = new File("archive//archive.txt");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("archive", file.getName(), "text/archive",
                IOUtils.toByteArray(input));
        String actual = fileStorageService.uploadFile(multipartFile);
        String expected = file.getAbsolutePath();
        assertEquals(expected, actual);
    }

    @Test(expected = FileStorageException.class)
    public void uploadFile_MultipartFileEmpty_throwException() throws FileStorageException {
        String result = fileStorageService.uploadFile(null);
    }

    @Test(expected = FileStorageException.class)
    public void downloadFile_InvalidPath_throwsRuntimeException() throws FileStorageException {
        Resource actual = fileStorageService.downloadFile("fileName");
    }

    @Test
    public void downloadFile_validPath_objectResource() throws FileStorageException {
        Resource actual = fileStorageService.downloadFile("archive.txt");
        assertNotNull(actual);
    }

    @Test(expected = FileStorageException.class)
    public void downloadFile_Space_throwsRuntimeException() throws FileStorageException {
        Resource actual = fileStorageService.downloadFile(" ");
    }

    @Test
    public void getOutputPath_nameInput_pathToArchiveAndNameFile() {
        File file = new File("archive");
        String actual = getOutputPath("testPath");
        String expected = file.getAbsolutePath() + "\\\\testPath";
        assertEquals(expected, actual);
    }

    @Test
    public void getOutputPathWithoutFileName_empty_pathToArchive() {
        String actual = getOutputPathWithoutFileName("");
        File file = new File("archive");
        String expected = file.getAbsolutePath() + "\\\\";
        assertEquals(expected, actual);
    }

    @Test
    public void getArchivePath_fileName_pathToArchive() {
        File file = new File("archive/testPath2");
        String actual = fileStorageService.getArchivePath("testPath2");
        String expected = file.getAbsolutePath();
        assertEquals(expected, actual);
    }
}