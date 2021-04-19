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

import static org.fundacion.jala.converter.ConverterApplication.dotenv;
public class VideoRequestForm implements IrequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = dotenv.get("HTTP_URL_CONVERT_VIDEO");
    private final String file = "file";
    private final String outputFormat = "outputFormat";
    private final String resolution = "resolution";
    private final String thumbnail = "thumbnail";
    private final String frameRate = "frameRate";
    private final String width = "width";
    private final String height = "height";
    private final String audio = "audio";

    /**
     * Video Request Form stores parameters for an video request
     */
    public VideoRequestForm() {
    }

    /**
     * Adds filepath parameter
     * @param filepathValue
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(file, filepathValue, true));
    }

    /**
     * Adds outputFormat parameter
     * @param outputFormatValue
     */
    public void addOutputFormat(final String outputFormatValue) {
        addParameters(new Parameter(outputFormat, outputFormatValue, false));
    }

    /**
     * Adds resolution parameter
     * @param resolutionValue
     */
    public void addResolution(final String resolutionValue) {
        addParameters(new Parameter(resolution, resolutionValue, false));
    }

    /**
     * Adds thumbnail parameter
     * @param thumbnailValue
     */
    public void addThumbnail(final String thumbnailValue) {
        addParameters(new Parameter(thumbnail, thumbnailValue, false));
    }

    /**
     * Adds frameRate parameter
     * @param frameRateValue
     */
    public void addFrameRate(final String frameRateValue) {
        addParameters(new Parameter(frameRate, frameRateValue, false));
    }

    /**
     * Adds width parameter
     * @param widthValue
     */
    public void addWidth(final String widthValue) {
        addParameters(new Parameter(width, widthValue, false));
    }

    /**
     * Adds height parameter
     * @param heightValue
     */
    public void addHeight(final String heightValue) {
        addParameters(new Parameter(height, heightValue, false));
    }

    /**
     * Adds audio parameter
     * @param audioValue
     */
    public void addAudio(final String audioValue) {
        addParameters(new Parameter(audio, audioValue, false));
    }

    /**
     * Gets the body parameters
     * @return bodyParameters of video
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters
     * @param parameter
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url
     * @return url of endpoint
     */
    @Override
    public String getURL() {
        return url;
    }
}
