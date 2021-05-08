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

import org.fundacion.jala.converter.core.exceptions.ChecksumException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class gets a file's checksum and compares it.
 */
public class ChecksumService {
    private static final int BYTES = 1024;
    private static final String MD5_ALGORITHM = "MD5";
    private static final int HEXADECIMAL_NUMBER_255 = 0xff;
    private static final int HEXADECIMAL_NUMBER = 0x100;
    private static final int HEXADECIMAL_RADIX = 16;

    /**
     * Gets the file's checksum.
     *
     * @param filePath a String with the file's direction.
     * @return a String with the checksum.
     * @throws ChecksumException if process is interrupted.
     */
    public static String getFileChecksum(final String filePath) throws ChecksumException {
        File file = new File(filePath);
        MessageDigest md5Digest = null;
        try {
            md5Digest = MessageDigest.getInstance(MD5_ALGORITHM);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] byteArray = new byte[BYTES];
            int bytesCount = 0;
            while ((bytesCount = fileInputStream.read(byteArray)) != -1) {
                md5Digest.update(byteArray, 0, bytesCount);
            }
            fileInputStream.close();
        } catch (IOException | NoSuchAlgorithmException exception) {
            throw new ChecksumException(exception);
        }
        byte[] bytes = md5Digest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(Integer.toString((bytes[i] & HEXADECIMAL_NUMBER_255)
                    + HEXADECIMAL_NUMBER, HEXADECIMAL_RADIX).substring(1));
        }
        return stringBuilder.toString();
    }

    /**
     * Verifies if two file's have the same checksum.
     *
     * @param firstFilePath a String with the first file's path.
     * @param checksum a String with the checksum.
     * @return a Boolean with the response.
     * @throws ChecksumException if process is interrupted.
     */
    public static Boolean repeatedChecksum(final String firstFilePath, final String checksum)
            throws ChecksumException {
        return (checksum.equals(getFileChecksum(firstFilePath)));
    }
}
