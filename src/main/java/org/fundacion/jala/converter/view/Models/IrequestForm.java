/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */
package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

public interface IrequestForm {

    /**
     * @return bodyParameters
     */
    public List<Parameter> getBodyParameters();

    /**
     * Adds parameters to bodyParameters.
     * @param parameter
     */
    public void addParameters(Parameter parameter);

    /**
     * @return URL
     */
    public String getURL();
}
