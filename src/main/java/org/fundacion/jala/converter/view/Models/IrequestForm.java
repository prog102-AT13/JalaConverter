package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

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

public interface IrequestForm {
    public List<Parameter> bodyParameters = new ArrayList<>();
    default List<Parameter> getBodyParameters() {
        return bodyParameters;
    }
    default void addParameters(Parameter parameter) {
        bodyParameters.add(parameter);
    }
}
