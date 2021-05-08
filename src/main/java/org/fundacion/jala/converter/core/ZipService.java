/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ZipException;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class zips a file or group of files.
 */
public class ZipService {
    private static final int BYTES = 1024;

    /**
     * Makes the process for zipping a file.
     *
     * @param filePath ta String with the file's direction.
     * @param zipOutputStream Object with an output stream filter to write the zip file.
     * @throws ZipException when invalid path is given.
     */
    public static void zipProcess(final String filePath, final ZipOutputStream zipOutputStream) throws ZipException {
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bytes = new byte[BYTES];
            int length;
            while ((length = fileInputStream.read(bytes)) >= 0) {
                zipOutputStream.write(bytes, 0, length);
            }
            fileInputStream.close();
        } catch (IOException exception) {
            throw new ZipException(exception);
        }

    }

    /**
     * Creates a zip file of a file.
     *
     * @param filePath a String with the file's direction.
     * @param outputPath a String with the destination's direction.
     * @throws ZipException if process is interrupted.
     */
    public static void zipFile(final String filePath, final String outputPath) throws ZipException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputPath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            zipProcess(filePath, zipOutputStream);
            zipOutputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
            throw new ZipException(exception);
        }
    }

    /**
     * Creates a zip file of a group of files.
     *
     * @param filesPaths an arraylist with the files paths.
     * @param outputPath the destination's direction.
     * @throws ZipException if process is interrupted.
     */
    public static void zipFiles(final ArrayList<String> filesPaths, final String outputPath) throws ZipException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputPath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            for (String filePath : filesPaths) {
                zipProcess(filePath, zipOutputStream);
            }
            zipOutputStream.close();
            fileOutputStream.close();
        } catch (IOException exception) {
            throw new ZipException(exception);
        }
    }
}
