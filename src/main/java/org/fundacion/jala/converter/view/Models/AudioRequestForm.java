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

public class AudioRequestForm implements IrequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String url = "http://localhost:8080/api/convertAudio";
    private final String file = "file";
    private final String format = "format";
    private final String bitrate = "bitrate";
    private final String volume = "volume";
    private final String hz = "hz";
    private final String audioChannel = "audiochannel";
    private final String metaData = "metadata";

    /**
     * Audio Request Form stores parameters for an audio request
     */
    public AudioRequestForm() {
    }

    /**
     * Adds filepath parameter
     * @param filepathValue
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(file, filepathValue, true));
    }

    /**
     * Adds format parameter
     * @param formatValue
     */
    public void addFormat(final String formatValue) {
        addParameters(new Parameter(format, formatValue, false));
    }

    /**
     * Adds bitrate parameter
     * @param bitrateValue
     */
    public void addBitrate(final String bitrateValue) {
        addParameters(new Parameter(bitrate, bitrateValue, false));
    }

    /**
     * Adds volume parameter
     * @param volumeValue
     */
    public void addVolume(final String volumeValue) {
        addParameters(new Parameter(volume, volumeValue, false));
    }

    /**
     * Adds hz parameter
     * @param hzValue
     */
    public void addHz(final String hzValue) {
        addParameters(new Parameter(hz, hzValue, false));
    }

    /**
     * Adds audiochannel parameter
     * @param metadataValue
     */
    public void addAudiochannel(final String metadataValue) {
        addParameters(new Parameter(audioChannel, metadataValue, false));
    }
    /**
     * Adds metadata parameter
     * @param metadataValue
     */
    public void addMetadata(final String metadataValue) {
        addParameters(new Parameter(metaData, metadataValue, false));
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
     * Adds parameters to bodyParameters
     * @param parameter
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url
     * @return url
     */
    @Override
    public String getURL() {
        return url;
    }
}
