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

import org.fundacion.jala.converter.core.metadata.TypeFileExport;
import java.io.File;

/**
 * This class creates a metadata object.
 */
public class ObjectMetadata {
    private File fileToExtract;
    private File fileToExport;
    private String nameExport;
    private TypeFileExport typeFileExport = TypeFileExport.XMP;
    private boolean moreInfo = false;

    /**
     * Gets file's path to be extracted.
     *
     * @return path's file to be extracted.
     */
    public File getFileToExtract() {
        return fileToExtract;
    }

    /**
     * Sets file's path to be extracted.
     *
     * @param file is path's file to be extracted.
     */
    public void setFileToExtract(final File file) {
        this.fileToExtract = file;
    }

    /**
     * Gets file's path to  be exported.
     *
     * @return a file to be exported.
     */
    public File getFileToExport() {
        return fileToExport;
    }

    /**
     * Sets file's path to export.
     *
     * @param file is file's path to be exported.
     */
    public void setFileToExport(final File file) {
        this.fileToExport = file;
    }

    /**
     * Gets file's name which the metadata is extracted.
     *
     * @return file's name which the metadata is extracted.
     */
    public String getNameExport() {
        return nameExport;
    }

    /**
     * Sets file's name which the metadata is exported.
     *
     * @param nameExport is file's name which the metadata is exported.
     */
    public void setNameExport(String nameExport) {
        this.nameExport = nameExport;
    }

    /**
     * Gets file's type which the metadata is exported.
     *
     * @return TypeFileExport file's type which the metadata is exported.
     */
    public TypeFileExport getTypeFileExport() {
        return typeFileExport;
    }

    /**
     * Set type of file which the metadata is extracted.
     *
     * @param typeFileExport is type of file which the metadata is extracted.
     */
    public void setTypeFileExport(TypeFileExport typeFileExport) {
        this.typeFileExport = typeFileExport;
    }

    /**
     * Verifies if the metadata file has more information than usual.
     *
     * @return a boolean wiht more information of the file which the metadata is extracted.
     */
    public boolean getMoreInfo() {
        return moreInfo;
    }

    /**
     * Sets if the file metadata has more information than usual.
     *
     * @param moreInfo of file which the metadata is extracted.
     */
    public void setMoreInfo(boolean moreInfo) {
        this.moreInfo = moreInfo;
    }
}
