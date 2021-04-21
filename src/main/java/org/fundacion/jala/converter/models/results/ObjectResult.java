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

public interface ObjectResult {
    public String getStatus();
    public String getPathfile();
    public String getChecksum();
}
