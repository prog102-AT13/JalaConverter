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

/**
 * This class shows the metadata form.
 */
public class MetaDataRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String URL = dotenv.get("HTTP_URL_EXTRACT_METADATA");
    private final String FILE = "fileToExtract";
    private final String FORMAT = "format";
    private final String OUTPUT_NAME = "nameExport";
    private final String KEEP_NAME = "name";
    private final String MORE_INFO = "moreInfo";

    public MetaDataRequestForm() {
    }

    /**
     * Adds filepath parameter.
     *
     * @param filepathValue String with path's value.
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(FILE, filepathValue, true));
    }

    /**
     * Adds metadata format parameter.
     *
     * @param metaDataFormat String with metadata value.
     */
    public void addMetaDataFormat(final String metaDataFormat) {
        addParameters(new Parameter(FORMAT, metaDataFormat, false));
    }

    /**
     * Adds new name parameter.
     *
     * @param newName String with the file's name.
     */
    public void addOutputName(final String newName) {
        addParameters(new Parameter(OUTPUT_NAME, newName, false));
    }

    /**
     * Adds same name parameter.
     *
     * @param sameName String with file's name.
     */
    public void addSameName(final String sameName) {
        addParameters(new Parameter(KEEP_NAME, sameName, false));
    }

    /**
     * Adds more info parameter.
     *
     * @param moreInformation String if options more information was selected.
     */
    public void addMoreInfo(final String moreInformation) {
        addParameters(new Parameter(MORE_INFO, moreInformation, false));
    }

    /**
     * Gets the body parameters.
     *
     * @return a List<Parameter> with body's parameters.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter Object Parameter.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the URL
     * @return a String with file's URL
     */
    @Override
    public String getURL() {
        return URL;
    }
}
