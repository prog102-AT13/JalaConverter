package org.fundacion.jala.converter.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipService {
    /**
     * Makes the process for zipping a file
     * @param filePath the file's direction
     * @param zipOutputStream an output stream filter to write the zip file
     * @throws IOException when invalid path is given
     */
    public static void zipProcess(final String filePath, final ZipOutputStream zipOutputStream) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fileInputStream.read(bytes)) >= 0) {
            zipOutputStream.write(bytes, 0, length);
        }
        fileInputStream.close();
    }

    /**
     * Creates a zip file of a file
     * @param filePath the file's direction
     * @param outputPath the destination's direction
     * @throws IOException when invalid path is given
     */
    public static void zipFile(String filePath, String outputPath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipProcess(filePath, zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * Creates a zip file of a group of files
     * @param filesPaths an arraylist with the files paths
     * @param outputPath the destination's direction
     * @throws IOException when invalid path is given
     */
    public static void zipFiles(ArrayList<String> filesPaths, String outputPath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        for (String filePath : filesPaths) {
            zipProcess(filePath, zipOutputStream);
        }
        zipOutputStream.close();
        fileOutputStream.close();
    }
}
