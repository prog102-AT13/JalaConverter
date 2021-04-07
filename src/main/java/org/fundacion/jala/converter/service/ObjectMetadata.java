/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service;

import org.fundacion.jala.converter.service.metadata.TypeFileExport;
import java.io.File;

public class ObjectMetadata {
    private File fileToExtract;
    private File fileToExport;
    private String nameExport;
    private TypeFileExport typeFileExport = TypeFileExport.XMP;
    private boolean moreInfo = false;

    /**
     * Get path of file to extract.
     * @return path of file which the metadata is extracted.
     */
    public File getFileToExtract() {
        return fileToExtract;
    }

    /**
     * Set path of file to extract.
     * @param file is path of file which the metadata is extracted.
     */
    public void setFileToExtract(final File file) {
        this.fileToExtract = file;
    }

    /**
     * Get path of file to extract.
     * @return path of file which the metadata is exported.
     */
    public File getFileToExport() {
        return fileToExport;
    }

    /**
     * Set path of file to extract.
     * @param file is path of file which the metadata is exported.
     */
    public void setFileToExport(final File file) {
        this.fileToExport = file;
    }

    /**
     * Get name of file which the metadata is extracted.
     * @return name of file which the metadata is extracted.
     */
    public String getNameExport() {
        return nameExport;
    }

    /**
     * Set name of file which the metadata is extracted.
     * @param nameExport is name of file which the metadata is extracted.
     */
    public void setNameExport(String nameExport) {
        this.nameExport = nameExport;
    }

    /**
     * Get type of file which the metadata is extracted.
     * @return type of file which the metadata is extracted.
     */
    public TypeFileExport getTypeFileExport() {
        return typeFileExport;
    }

    /**
     * Set type of file which the metadata is extracted.
     * @param typeFileExport is type of file which the metadata is extracted.
     */
    public void setTypeFileExport(TypeFileExport typeFileExport) {
        this.typeFileExport = typeFileExport;
    }

    /**
     * if The file metadata has more information than usual.
     * @return moreInfo of file which the metadata is extracted.
     */
    public boolean getMoreInfo() {
        return moreInfo;
    }

    /**
     * Set the file metadata has more information than usual.
     * @param moreInfo of file which the metadata is extracted.
     */
    public void setMoreInfo(boolean moreInfo) {
        this.moreInfo = moreInfo;
    }
}
