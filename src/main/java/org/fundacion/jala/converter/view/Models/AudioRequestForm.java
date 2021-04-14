package org.fundacion.jala.converter.view.Models;
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

public class AudioRequestForm implements IrequestForm{
    private final String FILE = "file";
    private final String FORMAT = "format";
    private final String BITRATE = "bitrate";
    private final String VOLUME = "volume";
    private final String HZ = "hz";

    private String filepathValue;
    private String formatValue;
    private String bitrateValue;
    private String volumeValue;
    private String hzValue;

    /**
     * Audio Request Form stores parameters for an audio request
     */
    public AudioRequestForm() {
        
    }

    /**
     * Add filepath parameter
     * @param filepathValue
     */
    public void addFilepath(String filepathValue) {
        addParameters(new Parameter(FILE, filepathValue, true));
    }

    /**
     * Add format parameter
     * @param formatValue
     */
    public void addFormat(String formatValue) {
        addParameters(new Parameter(FORMAT, formatValue, false));
    }

    /**
     * Add bitrate parameter
     * @param bitrateValue
     */
    public void addBitrate(String bitrateValue) {
        addParameters(new Parameter(BITRATE, bitrateValue, false));
    }

    /**
     * Add volume parameter
     * @param volumeValue
     */
    public void addVolume(String volumeValue) {
        addParameters(new Parameter(VOLUME, volumeValue, false));
    }

    /**
     * Add hz parameter
     * @param hzValue
     */
    public void addHz(String hzValue) {
        addParameters(new Parameter(HZ, hzValue, false));
    }
}
