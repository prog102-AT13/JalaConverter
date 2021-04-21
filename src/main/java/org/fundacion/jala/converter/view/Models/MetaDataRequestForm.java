/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */

package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;

import static org.fundacion.jala.converter.ConverterApplication.dotenv;

public class MetaDataRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = dotenv.get("HTTP_URL_EXTRACT_METADATA");
    private final String file = "fileToExtract";
    private final String format = "format";
    private final String outputName = "nameExport";
    private final String keepName = "name";
    private final String moreInfo = "moreInfo";

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
        addParameters(new Parameter(moreInfo, moreInformation, false));
    }

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
