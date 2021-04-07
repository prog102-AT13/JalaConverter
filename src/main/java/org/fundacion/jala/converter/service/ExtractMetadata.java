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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractMetadata {
    private final String addressExiftool = "cd thirdparty\\window\\exiftool\\12.2.2_exiftool/";
    private String exportFile = "";
    private File fileToExtract;
    private String moreInformation = " ";
    private ExportTypeFile exportTypeFile;

    public ExtractMetadata(ObjectMetadata extractMetadata) {
        this.fileToExtract = extractMetadata.getFileToExtract();
        if (extractMetadata.getMoreInfo()) setMoreInformation();
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), extractMetadata.getNameExport(), extractMetadata.getTypeFileExport(),extractMetadata.getFileToExport());
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    public ExtractMetadata(final File fileExtract, final File fileExport ) {
        this.fileToExtract = fileExtract;
        setMoreInformation();
        exportTypeFile = new ExportTypeFile(fileToExtract.getName(), "Default", TypeFileExport.TXT, fileExport);
        exportFile = exportTypeFile.getNameFileCompleteToExport();
        extractMetadata();
    }

    /**
     * Code assembly in order to run in Exiftool.
     */
    public void extractMetadata() {
        try {
            String command = "cmd /c " + addressExiftool+ " && exiftool.exe " + "\"" +  fileToExtract.getAbsolutePath() + "\"" + moreInformation + exportFile;
            //String command = "cmd /c " + "dir";
            Process process = Runtime.getRuntime().exec(command);

            System.out.println(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            while ((resultOfExecution = br.readLine()) != null) {
                System.out.println(resultOfExecution);
                System.out.println("Success");
            }
            } catch (IOException e){
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
