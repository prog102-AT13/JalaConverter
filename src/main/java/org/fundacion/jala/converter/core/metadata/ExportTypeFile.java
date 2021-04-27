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
package org.fundacion.jala.converter.core.metadata;

import java.io.File;

/**
 * This class exports a metadata text file.
 */
public class ExportTypeFile {
    private File addressExportFile;
    private String nameFileComplete;
    private String nameFileExport;
    private String nameFileCompleteToExport;

    public ExportTypeFile(final String nameFileComplete,
                          final String nameExport,
                          final TypeFileExport typeExport,
                          final File addressFileExport) {
        this.nameFileComplete = nameFileComplete;
        this.addressExportFile = addressFileExport;
        buildFileName(nameExport);
        buildFileType(typeExport);
    }

    /**
     * Gets parameter nameFileCompleteToExport.
     *
     * @return nameFileCompleteToExport with code in order to run in Exiftool.
     */
    public String getNameFileCompleteToExport() {
        return nameFileCompleteToExport;
    }

    /**
     * Defines name that the files are exported.
     *
     * @param nameExport define name of file which it is exported.
     */
    private void buildFileName(final String nameExport) {
        if ("Default" == nameExport || "".equals(nameExport) || "Default".equals(nameExport)) {
            setDefaultNameFileWithTypeOfFile();
            return;
        }
        setNameFileExport(nameExport);
    }

    /**
     * Defines type that the file are exported.
     *
     * @param typeExport define type of file which it is exported.
     */
    private void buildFileType(final TypeFileExport typeExport) {
        if (typeExport == TypeFileExport.TXT) exportFileTxt();
        if (typeExport == TypeFileExport.HTML) exportFileHtml();
        if (typeExport == TypeFileExport.XMP) exportFileXMP();
    }

    /**
     * Defines name that the file are exported and sets nameFileExport.
     */
    private void setDefaultNameFileWithTypeOfFile() {
        char[] spellName = nameFileComplete.toCharArray();
        String name = "";
        boolean write = false;
        for (int i = spellName.length - 1; i >= 0; i--) {
            if (spellName[i] == '.' && !write) write = true;
            else if (write) name = spellName[i] + name;
        }
        nameFileExport = name;
    }

    /**
     * Defines name that the file are exported and sets nameFileExport.
     *
     * @param newName a String to set a new file name.
     */
    private void setNameFileExport(final String newName) {
        this.nameFileExport = newName;
    }

    /**
     * Defines file are exported with type Txt and sets nameFileCompleteToExport.
     */
    private void exportFileTxt() {
        nameFileCompleteToExport = " > " + "\"" + addressExportFile.getAbsolutePath() + "\\"
                                   + nameFileExport + ".txt" + "\"";
    }

    /**
     * Defines file are exported with type Html sets nameFileCompleteToExport.
     */
    private void exportFileHtml() {
        nameFileCompleteToExport = " -h > " + "\"" + addressExportFile.getAbsolutePath() + "\\"
                                   + nameFileExport + ".html" + "\"";
    }

    /**
     * Defines file are exported with type XMP sets exportFileXMP.
     */
    private void exportFileXMP() {
        nameFileCompleteToExport = " -X > " + "\"" + addressExportFile.getAbsolutePath() + "\\"
                                   + nameFileExport + ".xmp" + "\"";
    }
}
