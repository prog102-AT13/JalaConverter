/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.metadata;

import java.io.File;

public class ExportTypeFile {
    private File addressExportFile;
    private String nameFileComplete;
    private String nameFileExport;
    private String nameFileCompleteToExport;

    public ExportTypeFile(final String nameFileComplete, final String nameExport, final TypeFileExport typeExport, final File addressFileExport) {
        this.nameFileComplete = nameFileComplete;
        this.addressExportFile = addressFileExport;
        buildFileName(nameExport);
        buildFileType(typeExport);
    }

    /**
     * Get parameter nameFileCompleteToExport
     *
     * @return nameFileCompleteToExport with code in order to run in Exiftool.
     */
    public String getNameFileCompleteToExport() {
        return nameFileCompleteToExport;
    }

    /**
     * Defines name that the file are exported.
     *
     * @param nameExport define name of file which it is exported.
     */
    private void buildFileName(final String nameExport) {
        if ("Default" == nameExport || "" == nameExport || "Default".equals(nameExport)) {
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
     * Defines name that the file are exported.
     * set nameFileExport.
     * e.g. DragonBall.mp4 --> DragonBall.xmp
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
     * Defines name that the file are exported.
     * set nameFileExport.
     * e.g. DragonBall.mp4 --> NameSet.xmp
     */
    private void setNameFileExport(final String newName) {
        this.nameFileExport = newName;
    }

    /**
     * Define file are exported with type Txt.
     * set nameFileCompleteToExport.
     */
    private void exportFileTxt() {
        nameFileCompleteToExport = " > " + "\"" + addressExportFile.getAbsolutePath() + "\\" + nameFileExport + ".txt" + "\"";
    }

    /**
     * Define file are exported with type Html.
     * set nameFileCompleteToExport.
     */
    private void exportFileHtml() {
        nameFileCompleteToExport = " -h > " + "\"" + addressExportFile.getAbsolutePath() + "\\" + nameFileExport + ".html" + "\"";
    }

    /**
     * Define file are exported with type XMP.
     * set exportFileXMP.
     */
    private void exportFileXMP() {
        nameFileCompleteToExport = " -X > " + "\"" + addressExportFile.getAbsolutePath() + "\\" + nameFileExport + ".xmp" + "\"";
    }
}

