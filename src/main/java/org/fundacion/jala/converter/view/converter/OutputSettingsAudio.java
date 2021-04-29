/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class defines the interface for output settings for audio to convert.
 */
class OutputSettingsAudio extends JPanel {
    private JComboBox qualitySelect;
    private JComboBox volumeSelect;
    private JComboBox hzSelect;
    private JComboBox audioChannelSelect;
    private JCheckBox metadataOption;
    private final int DIMENSION_WIDTH = 70;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_SIZE = 12;
    private final int GRID_LAYOUT_ROWS = 5;
    private final int GRID_LAYOUT_COLS = 2;
    private final String QUALITY_64KBPS = "64";
    private final String QUALITY_128KBPS = "128";
    private final String QUALITY_192KBPS = "192";
    private final String QUALITY_320KBPS = "320";

    protected OutputSettingsAudio() {
        JLabelStyle qualityLabel = new JLabelStyle("Select Quality (Kbps): ", "h4");
        JLabelStyle volumeLabel = new JLabelStyle("Select Volume: ", "h4");
        JLabelStyle hzLabel = new JLabelStyle("Select Frequency (Hz): ", "h4");
        JLabelStyle audioChannelLabel = new JLabelStyle("Select Audio Channel: ", "h4");
        qualitySelect = new JComboBox();
        qualitySelect.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        qualitySelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setQualitySelect();
        volumeSelect = new JComboBox();
        volumeSelect.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        volumeSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setVolumeSelect();
        hzSelect = new JComboBox();
        hzSelect.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        hzSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setHzSelect();
        audioChannelSelect = new JComboBox();
        audioChannelSelect.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        audioChannelSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setAudioChannelSelect();
        metadataOption = new JCheckBox("With metadata");
        metadataOption.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));
        add(qualityLabel);
        add(qualitySelect);
        add(volumeLabel);
        add(volumeSelect);
        add(hzLabel);
        add(hzSelect);
        add(audioChannelLabel);
        add(audioChannelSelect);
        add(metadataOption);
    }

    /**
     * Sets all possible quality for Audio converter.
     */
    protected void setQualitySelect() {
        qualitySelect.addItem("");
        qualitySelect.addItem(QUALITY_64KBPS);
        qualitySelect.addItem(QUALITY_128KBPS);
        qualitySelect.addItem(QUALITY_192KBPS);
        qualitySelect.addItem(QUALITY_320KBPS);
        qualitySelect.setSelectedIndex(2);
    }

    /**
     * Sets all possible volume for Audio converter.
     */
    protected void setVolumeSelect() {
        volumeSelect.addItem("");
        volumeSelect.addItem("2");
        volumeSelect.addItem("3");
        volumeSelect.addItem("4");
        volumeSelect.addItem("5");
    }

    /**
     * Sets all possible Hz for Audio converter.
     */
    protected void setHzSelect() {
        hzSelect.addItem(" ");
        hzSelect.addItem("20");
        hzSelect.addItem("44");
        hzSelect.addItem("48");
    }

    /**
     * Sets all possible Audio Channel for Audio converter.
     */
    protected void setAudioChannelSelect() {
        audioChannelSelect.addItem(" ");
        audioChannelSelect.addItem("mono");
        audioChannelSelect.addItem("stereo");
        audioChannelSelect.addItem("2.1");
        audioChannelSelect.addItem("4.0");
        audioChannelSelect.addItem("5.0");
        audioChannelSelect.addItem("5.1");
        audioChannelSelect.addItem("6.1");
        audioChannelSelect.addItem("7.1");
    }

    /**
     * Gets selected quality for Audio converter.
     *
     * @return a String, option selected of quality.
     */
    protected String getQuality() {
        return qualitySelect.getSelectedItem().toString();
    }

    /**
     * Gets selected volume for Audio converter.
     *
     * @return a String, option selected of volume.
     */
    protected String getVolume() {
        return volumeSelect.getSelectedItem().toString();
    }

    /**
     * Gets selected Hz for Audio converter.
     *
     * @return a String, option selected of Hz.
     */
    protected String getHz() {
        return hzSelect.getSelectedItem().toString();
    }

    /**
     * Gets selected AudioChannel for Audio converter.
     *
     * @return a String, option selected of AudioChannel.
     */
    protected String getAudioChannel() {
        return audioChannelSelect.getSelectedItem().toString();
    }

    /**
     * Gets if metadata is required for Audio converter.
     *
     * @return a true if metadata is required, false if not.
     */
    protected boolean isMetadata() {
        return metadataOption.isSelected();
    }
}
