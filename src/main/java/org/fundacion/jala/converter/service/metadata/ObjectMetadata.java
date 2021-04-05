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

public class ObjectMetadata {
    private File file;
    private String nameExport;
    private TypeFileExport typeFileExport;
    private boolean moreInfo;


    /**
     *
     * @return path and name of file which the metadata will be extracted.
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @param file is path and name of file which the metadata will be extracted.
     */
    public void setFile(File file) {
        this.file = file;
    }

    public String getNameExport() {
        return nameExport;
    }

    public void setNameExport(String nameExport) {
        this.nameExport = nameExport;
    }

    public TypeFileExport getTypeFileExport() {
        return typeFileExport;
    }

    public void setTypeFileExport(TypeFileExport typeFileExport) {
        this.typeFileExport = typeFileExport;
    }

    public boolean getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(boolean moreInfo) {
        this.moreInfo = moreInfo;
    }
}
