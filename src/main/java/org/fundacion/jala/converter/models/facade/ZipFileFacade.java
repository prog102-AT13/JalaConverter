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
package org.fundacion.jala.converter.models.facade;

import java.io.IOException;
import java.util.ArrayList;
import static org.fundacion.jala.converter.models.AssetSQL.insertAssetData;
import static org.fundacion.jala.converter.service.ZipService.zipFile;
import static org.fundacion.jala.converter.service.ZipService.zipFiles;

/**
 * Class to do and call facade of ZipFile.
 */
public class ZipFileFacade {

    private ZipFileFacade() {
    }

    /**
     * Compresses files of Audio
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum.
     * @param metadata if add metadata of audio into zip.
     * @param storagePath path and name of file to compress.
     * @throws IOException when invalid path is given in zipFiles.
     * @throws InterruptedException is exception if process is interrupted.
     */
    public static void getZipFileAudio(final ParameterOutputChecksum parameterOutputChecksum, final String metadata,
                                       final String storagePath) throws IOException, InterruptedException {
        getZipFile(parameterOutputChecksum, metadata, storagePath, false);
    }

    /**
     * Compresses files of video.
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum.
     * @param metadata if add metadata of video into zip.
     * @param storagePath path and name of file to compress.
     * @param thumbnail if add thumbnail of video into zip.
     * @throws IOException when invalid path is given in zipFiles.
     * @throws InterruptedException is exception if process is interrupted.
     */
    public static void getZipFileVideo(final ParameterOutputChecksum parameterOutputChecksum, final String metadata,
                                       final boolean thumbnail, final String storagePath)
            throws IOException, InterruptedException {
        getZipFile(parameterOutputChecksum, metadata, storagePath, thumbnail);
    }

    /**
     * Compresses files.
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum.
     * @param metadata if add metadata into zip.
     * @param storagePath path and name of file to compress.
     * @param thumbnail if add thumbnail of video into zip.
     * @throws IOException when invalid path is given in zipFiles.
     * @throws InterruptedException is exception if process is interrupted.
     */
    private static void getZipFile(final ParameterOutputChecksum parameterOutputChecksum, final String metadata,
                                   final String storagePath, final boolean thumbnail)
            throws IOException, InterruptedException {
        String checksumLocal = parameterOutputChecksum.getChecksumLocal();
        String outputFilename = parameterOutputChecksum.getOutputFilename();
        int resultTitleSize = parameterOutputChecksum.getResultTitleSize();
        String filename = parameterOutputChecksum.getFileName();
        final int WAIT_TIME = 6000;
        final int USER_ID = 1;
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);
        if (!(resultTitleSize > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, USER_ID);
        }
        if (metadata.equals("true") || thumbnail) {
            ArrayList<String> zipList = new ArrayList<>();
            zipList.add(pathFile + outputFilename);
            if (metadata.equals("true")) {
                zipList.add(pathFile + nameWithoutExtension + "txt");
            }
            if (thumbnail) {
                zipList.add(pathFile + nameWithoutExtension + "png");
            }
            Thread.sleep(WAIT_TIME);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
        } else {
            Thread.sleep(WAIT_TIME);
            zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
        }
    }
}

