package org.fundacion.jala.converter.models.results;

/**
 *  Copyright (c) 2021 Fundacion Jala.
 *   *  This software is the confidential and proprietary information of Fundacion Jala
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

public class ConverterResult implements ObjectResult{
    public String status;
    public String pathfile;
    public String checksum;

    public ConverterResult(String status, String pathfile, String checksum) {
        this.status = status;
        this.pathfile = pathfile;
        this.checksum = checksum;
    }

    public String getStatus() {
        return status;
    }
    public String getPathfile() {
        return pathfile;
    }
    public String getChecksum() {
        return checksum;
    }
}

