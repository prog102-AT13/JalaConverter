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
package org.fundacion.jala.converter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.service.metadata.ExportTypeFile;
import org.fundacion.jala.converter.service.metadata.TypeFileExport;
import java.io.File;
import java.io.IOException;

/**
 * This class gets a file's metadata.
 */
public class ExtractMetadata {
    private final String addressExiftool = "cd thirdparty\\windows\\exiftool\\12.2.2_exiftool/";
    private String exportFile = "";
    private File fileToExtract;
    private String moreInformation = " ";
    private ExportTypeFile exportTypeFile;
    private static final Logger LOGGER = LogManager.getLogger();

    public ExtractMetadata(final ObjectMetadata extractMetadata) {
        this.fileToExtract = extractMetadata.getFileToExtract();
        if (extractMetadata.getMoreInfo()) setMoreInformation();
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), extractMetadata.getNameExport(),
                         extractMetadata.getTypeFileExport(), extractMetadata.getFileToExport());
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    public ExtractMetadata(final File fileExtract, final File fileExport) {
        this.fileToExtract = fileExtract;
        setMoreInformation();
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), "Default", TypeFileExport.TXT,
                         fileExport);
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    /**
     * Assembles the command to run in Exiftool.
     */
    public void extractMetadata() {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String command = "cmd /c " + addressExiftool + " && exiftool.exe " + "\""
                             + fileToExtract.getAbsolutePath() + "\"" + moreInformation + exportFile;
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            LOGGER.error("Execute Exception to Safe text in a file");
            e.printStackTrace();
        }
        LOGGER.info("finish");
    }

    /**
     * Adds more information about metadata's file.
     */
    private void setMoreInformation() {
        this.moreInformation = " -api largefilesupport=1 -" + "ee";
    }

    /**
     * Extracts metadata from a file.
     *
     * @param metadata a String with metadata request.
     * @param outputFileName a String with the new file's name.
     * @param fileStorageService an object to create the path.
     */
    public static void extractMetadata(final String metadata, final String outputFileName,
                                       final FileStorageService fileStorageService) {
        String outputPath = fileStorageService.getOutputPath(outputFileName);
        String outputPathWithoutFileName = fileStorageService.getOutputPathWithoutFileName(outputFileName);
        if (metadata.equals("true")) {
            ExtractMetadata extractMetadata = new ExtractMetadata(new File(outputPath),
                    new File(outputPathWithoutFileName));
            extractMetadata.extractMetadata();
        }
    }
}
