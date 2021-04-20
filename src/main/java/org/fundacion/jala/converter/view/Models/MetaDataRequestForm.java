/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

public class MetaDataRequestForm implements IrequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = "http://localhost:8080/api/extractMetadata";
    private final String file = "file";
    private final String format = "format";
    private final String outputName = "outputname";
    private final String keepName = "name";
    private final String moreInfo = "moreinfo";

    public MetaDataRequestForm() {
    }

    /**
     * Adds filepath parameter
     * @param filepathValue
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(file, filepathValue, true));
    }

    /**
     * Adds metadata format parameter
     * @param metaDataFormat
     */
    public void addMetaDataFormat(final String metaDataFormat) {
        addParameters(new Parameter(format, metaDataFormat, false));
    }

    /**
     * Adds new name parameter
     * @param newName
     */
    public void addOutputName(final String newName) {
        addParameters(new Parameter(outputName, newName, false));
    }

    /**
     * Adds same name parameter
     * @param sameName
     */
    public void addSameName(final String sameName) {
        addParameters(new Parameter(keepName, sameName, false));
    }

    /**
     * Adds more info parameter
     * @param moreInformation
     */
    public void addMoreInfo(final String moreInformation) {
        addParameters(new Parameter(moreInfo, moreInformation, false)); }

    /**
     * Gets the body parameters
     * @return bodyParameters
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     * @param parameter
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the URL
     * @return URL
     */
    @Override
    public String getURL() {
        return url;
    }
}
