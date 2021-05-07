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
package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.RunCommand;
import org.fundacion.jala.converter.core.exceptions.ZipException;
import java.util.ArrayList;
import static org.fundacion.jala.converter.models.AssetSQL.insertAssetData;
import static org.fundacion.jala.converter.core.ZipService.zipFile;
import static org.fundacion.jala.converter.core.ZipService.zipFiles;

/**
 * This class calls facade of ZipFile.
 */
public class ZipFileFacade {

    private ZipFileFacade() {
    }

    /**
     * Compresses files of Audio.
     *
     * @param parameterOutputChecksum is a object of Parameter Checksum.
     * @param metadata is a parameter if add metadata of video into zip.
     * @param outputFilename is the path's name of file to compress.
     * @throws ZipException if process is interrupted.
     */
    public static void getZipFileAudio(final ParameterOutputChecksum parameterOutputChecksum, final boolean metadata,
                                       final String outputFilename) throws ZipException {
        builtZipFile(parameterOutputChecksum, metadata, outputFilename, false);
    }

    /**
     * Compresses files of Video.
     *
     * @param parameterOutputChecksum is a object of Parameter Checksum.
     * @param metadata is a parameter if add metadata of video into zip.
     * @param outputFilename is the path's name of file to compress.
     * @param thumbnail is a parameter if add thumbnail of video into zip.
     * @throws ZipException if process is interrupted.
     */
    public static void getZipFileVideo(final ParameterOutputChecksum parameterOutputChecksum, final boolean metadata,
                                       final boolean thumbnail, final String outputFilename) throws ZipException {
        builtZipFile(parameterOutputChecksum, metadata, outputFilename, thumbnail);
    }

    /**
     * Compresses files of Image.
     *
     * @param parameterOutputChecksum is a object of Parameter Checksum.
     * @param metadata is a parameter if add metadata of image into zip.
     * @param outputFilename is the path's name of file to compress.
     * @throws ZipException when invalid path is given in zipFiles.
     */
    public static void getZipFileImage(final ParameterOutputChecksum parameterOutputChecksum, final boolean metadata,
                                       final String outputFilename)
            throws ZipException {
        builtZipFile(parameterOutputChecksum, metadata, outputFilename, false);
    }

    /**
     * Compresses any files.
     *
     * @param parameterOutputChecksum object of ParameterOutputChecksum.
     * @param metadata is a parameter if add metadata of video into zip.
     * @param outputFilename is the path's name of file to compress.
     * @param thumbnail if add thumbnail of video into zip.
     * @throws ZipException if process is interrupted.
     */
    private static void builtZipFile(final ParameterOutputChecksum parameterOutputChecksum, final boolean metadata,
                                     final String outputFilename, final boolean thumbnail) throws ZipException {
        final int USER_ID = 1;
        String checksumLocal = parameterOutputChecksum.getChecksumLocal();
        String storagePath = parameterOutputChecksum.getOutputFilename();
        int resultTitleSize = parameterOutputChecksum.getResultTitleSize();
        String filename = parameterOutputChecksum.getFileName();
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        String pathFile = storagePath.substring(0, storagePath.lastIndexOf(System.getProperty("file.separator")) + 1);
        if (!(resultTitleSize > 0)) {
            insertAssetData(filename, pathFile, checksumLocal, USER_ID);
        }
        createZip(metadata, thumbnail, pathFile, outputFilename, nameWithoutExtension);
    }

    /**
     * Creates zip.
     *
     * @param metadata if add metadata into zip.
     * @param thumbnail if add thumbnail of video into zip.
     * @param pathFile is path where zip are downloaded
     * @param outputFilename path of file to compress.
     * @param nameWithoutExtension name's zip.
     * @throws ZipException if process is interrupted.
     */
    private static void createZip(final boolean metadata, final boolean thumbnail, final String pathFile,
                                  final String outputFilename, final String nameWithoutExtension)
                                  throws ZipException {
        try {
            final int WAIT_TIME = 1000;
            if (!metadata && !thumbnail) {
                Thread.sleep(WAIT_TIME);
                zipFile(pathFile + outputFilename, pathFile + nameWithoutExtension + "zip");
                return;
            }
            ArrayList<String> zipList = new ArrayList<>();
            zipList.add(pathFile + outputFilename);
            if (metadata) {
                zipList.add(pathFile + nameWithoutExtension + "txt");
            }
            if (thumbnail) {
                zipList.add(pathFile + nameWithoutExtension + "png");
            }
            Thread.sleep(WAIT_TIME);
            zipFiles(zipList, pathFile + nameWithoutExtension + "zip");
            Thread.sleep(WAIT_TIME);
            boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
            RunCommand runCommand = new RunCommand();
            if (isWindows) {
                zipList.stream().forEach(value -> runCommand.run("del \"" + value + "\""));
            } else {
                zipList.stream().forEach(value -> runCommand.run("rm \"" + value + "\""));
            }
        } catch (InterruptedException exception) {
            throw new ZipException(exception);
        }
    }
}
