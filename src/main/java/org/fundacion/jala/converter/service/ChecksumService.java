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
package org.fundacion.jala.converter.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ChecksumService {
    private static final int BYTES = 1024;
    /**
     * Gets the file's checksum
     * @param filePath the file's direction
     * @return a String with the checksum
     * @throws IOException when invalid file's path
     * @throws NoSuchAlgorithmException when invalid algorithm is provided
     */
    public static String getFileChecksum(final String filePath) throws IOException, NoSuchAlgorithmException {
        File file = new File(filePath);
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] byteArray = new byte[BYTES];
        int bytesCount = 0;
        while ((bytesCount = fileInputStream.read(byteArray)) != -1) {
            md5Digest.update(byteArray, 0, bytesCount);
        }
        fileInputStream.close();
        byte[] bytes = md5Digest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    /**
     * Verifies if two file's have the same checksum
     * @param firstFilePath first file's path
     * @param checksum a String with the checksum
     * @return a Boolean with the response
     * @throws IOException when invalid path
     * @throws NoSuchAlgorithmException when invalid algorithm provided
     */
    private static Boolean repeatedChecksum(final String firstFilePath, final String checksum) throws IOException, NoSuchAlgorithmException {
        return (checksum.equals(getFileChecksum(firstFilePath)));
    }
}
