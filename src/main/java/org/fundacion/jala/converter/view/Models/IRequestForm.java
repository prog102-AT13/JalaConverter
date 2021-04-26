/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */
package org.fundacion.jala.converter.view.Models;

import java.util.List;

/**
 * This interface defines the signatures for handling the parameters.
 */
public interface IRequestForm {

    /**
     * Gets the body parameters.
     *
     * @return a List<Parameter> Object with body's parameters.
     */
    public List<Parameter> getBodyParameters();

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter Object Parameter.
     */
    public void addParameters(Parameter parameter);

    /**
     * Gets the URL.
     *
     * @return a String with the file's url.
     */
    public String getURL();
}
