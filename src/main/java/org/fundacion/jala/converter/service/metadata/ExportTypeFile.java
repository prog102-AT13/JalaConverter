/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.metadata;

public class ExportTypeFile {
    private String nameFileComplete;
    private String nameFileExport;
    private String nameFileCompleteToExport;

    ExportTypeFile(final String nameFileComplete, final String nameExport, final TypeFileExport typeExport) {
        this.nameFileComplete = nameFileComplete;
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
        if (nameExport == "NameWithoutType") {
            setDefaultNameFileWithoutTypeOfFile();
            return;
        }
        if (nameExport == "Default") {
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
    private void setDefaultNameFileWithoutTypeOfFile() {
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
     * e.g. DragonBall.mp4 --> DragonBall.mp4.xmp
     */
    private void setDefaultNameFileWithTypeOfFile() {
        nameFileExport = nameFileComplete;
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
        nameFileCompleteToExport = " > " + "\"" + nameFileExport + ".txt" + "\"";
    }

    /**
     * Define file are exported with type Html.
     * set nameFileCompleteToExport.
     */
    private void exportFileHtml() {
        nameFileCompleteToExport = " -h > " + "\"" + nameFileExport + ".html" + "\"";
    }

    /**
     * Define file are exported with type XMP.
     * set exportFileXMP.
     */
    private void exportFileXMP() {
        nameFileCompleteToExport = " -X > " + "\"" + nameFileExport + ".xmp" + "\"";
    }
}

