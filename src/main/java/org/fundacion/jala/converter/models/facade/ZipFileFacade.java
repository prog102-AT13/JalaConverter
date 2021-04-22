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

public class ZipFileFacade {

    private ZipFileFacade() {
    }

    /**
     * Compress files of Audio
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum
     * @param metadata if add metadata of audio into zip
     * @param storagePath path and name of file to compress
     * @throws IOException
     * @throws InterruptedException
     */
    public static void getZipFileAudio(ParameterOutputChecksum parameterOutputChecksum, String metadata, String storagePath) throws IOException, InterruptedException {
        getZipFile(parameterOutputChecksum, metadata, storagePath, false);
    }

    /**
     * Compress files of video
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum
     * @param metadata if add metadata of video into zip
     * @param storagePath path and name of file to compress
     * @param thumbnail if add thumbnail of video into zip
     * @throws IOException
     * @throws InterruptedException
     */
    public static void getZipFileVideo(ParameterOutputChecksum parameterOutputChecksum, String metadata, boolean thumbnail, String storagePath) throws IOException, InterruptedException {
        getZipFile(parameterOutputChecksum, metadata, storagePath, thumbnail);
    }

    /**
     * Compress files
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum
     * @param metadata if add metadata into zip
     * @param storagePath path and name of file to compress
     * @param thumbnail if add thumbnail of video into zip
     * @throws IOException
     * @throws InterruptedException
     */
    private static void getZipFile(ParameterOutputChecksum parameterOutputChecksum, String metadata, String storagePath, boolean thumbnail) throws IOException, InterruptedException {
        String checksumLocal = parameterOutputChecksum.getChecksumLocal();
        String outputFilename = parameterOutputChecksum.getOutputFilename();
        int resultTitleSize = parameterOutputChecksum.getResultTitleSize();
        String filename = parameterOutputChecksum.getFilename();
        final int waitTime = 6000;
        final int userID = 1;
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);

        if (!(resultTitleSize > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, userID);
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
            Thread.sleep(waitTime);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
        } else {
            Thread.sleep(waitTime);
            zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
            System.out.println();
        }
    }
}
