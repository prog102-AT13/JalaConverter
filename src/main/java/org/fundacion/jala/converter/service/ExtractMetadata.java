/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service;

import org.fundacion.jala.converter.service.metadata.ExportTypeFile;
import org.fundacion.jala.converter.service.metadata.TypeFileExport;

import java.io.File;
import java.io.IOException;

public class ExtractMetadata {
   // final static String ADDRESS = "cd src\\main\\java\\org\\fundacion\\jala\\converter\\service\\metadata\\exiftoolApp/ "
    private final String addressExiftool = "cd thirdparty\\windows\\exiftool\\12.2.2_exiftool/ ";
    private String exportFile = "";
    private File file;
    private String moreInformation = " ";
    private ExportTypeFile exportTypeFile;

    public ExtractMetadata(ObjectMetadata extractMetadata) {
        this.file = extractMetadata.getFile();
        if (extractMetadata.getMoreInfo()) setMoreInformation();
        exportTypeFile = new ExportTypeFile(file.getName(), extractMetadata.getNameExport(), extractMetadata.getTypeFileExport());
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    public ExtractMetadata(File file) {
        this.file = file;
        setMoreInformation();
        exportTypeFile = new ExportTypeFile(file.getName(), "Default", TypeFileExport.XMP);
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    /**
     * Code assembly in order to run in Exiftool.
     */
    public void extractMetadata() {
        try {
            String command = "cmd /c " + addressExiftool + " && exiftool.exe " + "\"" + file + "\"" + moreInformation + exportFile;
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(command);
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("Fail");
        }
    }

    /**
     * The method permit Exiftool get more information about metadata of file.
     * set parameter moreInformation.
     */
    private void setMoreInformation() {
        this.moreInformation = " -api largefilesupport=1 -" + "ee";
    }
}
