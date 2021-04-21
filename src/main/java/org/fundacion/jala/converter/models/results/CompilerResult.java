package org.fundacion.jala.converter.models.results;

/**
 * Copyright (c) 2021 Fundacion Jala.
 * *  This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

public class CompilerResult implements ObjectResult {
    public String status;
    public String compileResult;
    public String pathfile;
    public String checkshum;

    public CompilerResult(String status, String compileResult, String pathfile, String checkshum) {
        this.status = status;
        this.compileResult = compileResult;
        this.pathfile = pathfile;
        this.checkshum = checkshum;
    }

    public String getStatus() {
        return status;
    }
    public String getCompileResult() {
        return compileResult;
    }
    public String getChecksum() {
        return checkshum;
    }
    public String getPathfile() {
        return pathfile;
    }
}
