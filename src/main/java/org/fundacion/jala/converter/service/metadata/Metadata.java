/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.metadata;

import java.io.File;
public class Metadata {
    Exiftool exiftool;
    Metadata(File file,String nameExport,TypeFileExport typeExport, boolean moreInfo){
        exiftool = new Exiftool (file,nameExport,typeExport,moreInfo);
        exiftool.executionExiftool();
    }
}