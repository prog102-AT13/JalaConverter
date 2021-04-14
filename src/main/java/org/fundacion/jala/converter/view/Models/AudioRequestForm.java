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
    private final String file = "file";
    private final String format = "format";
    private final String bitrate = "bitrate";
    private final String volume = "volume";
    private final String hz = "hz";

    private String filepathValue;
    private String formatValue;
    private String bitrateValue;
    private String volumeValue;
    private String hzValue;

    /**
     * Audio Request Form stores parameters for an audio request
     * @param filepathValue
     * @param formatValue
     * @param bitrateValue
     * @param volumeValue
     * @param hzValue
     */
    public AudioRequestForm(String filepathValue, String formatValue, String bitrateValue, String volumeValue, String hzValue) {
        this.filepathValue = filepathValue;
        this.formatValue = formatValue;
        this.bitrateValue = bitrateValue;
        this.volumeValue = volumeValue;
        this.hzValue = hzValue;
    }

    public String getFilepathValue() {
        return filepathValue;
    }

    public void setFilepathValue(String filepathValue) {
        this.filepathValue = filepathValue;
    }

    public String getFormatValue() {
        return formatValue;
    }

    public void setFormatValue(String formatValue) {
        this.formatValue = formatValue;
    }

    public String getBitrateValue() {
        return bitrateValue;
    }

    public void setBitrateValue(String bitrateValue) {
        this.bitrateValue = bitrateValue;
    }

    public String getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(String volumeValue) {
        this.volumeValue = volumeValue;
    }

    public String getHzValue() {
        return hzValue;
    }

    public void setHzValue(String hzValue) {
        this.hzValue = hzValue;
    }
}
