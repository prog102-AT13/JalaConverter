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

import java.util.ArrayList;
import java.util.List;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class shows the audio's form.
 */
public class AudioRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String URL = dotenv.get("HTTP_URL_CONVERT_AUDIO");
    private final String FILE = "file";
    private final String FORMAT = "format";
    private final String BITRATE = "bitrate";
    private final String VOLUME = "volume";
    private final String HZ = "hz";
    private final String AUDIOCHANEL = "audiochannel";
    private final String METADATA = "metadata";
    private final String CHECKSUM = "checksum";

    public AudioRequestForm() {
    }

    /**
     * Adds filepath parameter.
     *
     * @param filepathValue String with the path.
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(FILE, filepathValue, true));
    }

    /**
     * Adds format parameter.
     *
     * @param formatValue String with the format value.
     */
    public void addFormat(final String formatValue) {
        addParameters(new Parameter(FORMAT, formatValue, false));
    }

    /**
     * Adds bitrate parameter.
     *
     * @param bitrateValue String with the bitrate value.
     */
    public void addBitrate(final String bitrateValue) {
        addParameters(new Parameter(BITRATE, bitrateValue, false));
    }

    /**
     * Adds volume parameter.
     *
     * @param volumeValue String with the volume value.
     */
    public void addVolume(final String volumeValue) {
        addParameters(new Parameter(VOLUME, volumeValue, false));
    }

    /**
     * Adds hz parameter.
     *
     * @param hzValue String with the hz value.
     */
    public void addHz(final String hzValue) {
        addParameters(new Parameter(HZ, hzValue, false));
    }

    /**
     * Adds audiochannel parameter.
     *
     * @param metadataValue String with the metadata value.
     */
    public void addAudiochannel(final String metadataValue) {
        addParameters(new Parameter(AUDIOCHANEL, metadataValue, false));
    }

    /**
     * Adds metadata parameter.
     *
     * @param metadataValue String with the metadata value.
     */
    public void addMetadata(final String metadataValue) {
        addParameters(new Parameter(METADATA, metadataValue, false));
    }

    /**
     * Adds checksum parameter.
     *
     * @param checksumValue String with the checksum value.
     */
    public void addChecksum(final String checksumValue) {
        addParameters(new Parameter(CHECKSUM, checksumValue, false));
    }


    /**
     * Gets the body parameters.
     *
     * @return a List<Parameter> for bodyParameters.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter String with the object's parameters.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url.
     *
     * @return a String with the file's url.
     */
    @Override
    public String getURL() {
        return URL;
    }
}
