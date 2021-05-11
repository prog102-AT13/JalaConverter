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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.MetadataException;
import org.fundacion.jala.converter.core.results.Result;
import org.fundacion.jala.converter.core.metadata.ExportTypeFile;
import org.fundacion.jala.converter.core.metadata.TypeFileExport;
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
    private Result result;
    private String filename;

    public ExtractMetadata(final ObjectMetadata extractMetadata) throws MetadataException {
        this.fileToExtract = extractMetadata.getFileToExtract();
        if (extractMetadata.getMoreInfo()) {
            setMoreInformation();
        }
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), extractMetadata.getNameExport(),
                         extractMetadata.getTypeFileExport(), extractMetadata.getFileToExport());
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    public ExtractMetadata(final File fileExtract, final File fileExport) throws MetadataException {
        if (fileExport == null || fileExtract == null) {
            throw new MetadataException();
        }
        this.fileToExtract = fileExtract;
        filename = fileToExtract.getName();
        setMoreInformation();
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), "Default", TypeFileExport.TXT,
                         fileExport);
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    /**
     * Assembles the command to run in Exiftool.
     *
     * @throws MetadataException if process is interrupted.
     */
    public void extractMetadata() throws MetadataException {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            String command = "exiftool" + "\""
                             + fileToExtract.getAbsolutePath() + "\"" + moreInformation + exportFile;
            Process process = Runtime.getRuntime().exec(command);
            result = new Result();
            result.setFilename(this.filename);
        } catch (IOException exception) {
            LOGGER.error("Execute Exception to Safe text in a file");
            throw new MetadataException(exception);
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
     * Returns the object result for the operation.
     *
     * @return extractorResult.
     */
    public Result getResult() {
        return result;
    }
}
