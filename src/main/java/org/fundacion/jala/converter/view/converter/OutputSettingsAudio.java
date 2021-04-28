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
    private final int ALIGN_LABEL_STYLE = 2;
    private final int WIDTH_LABEL_STYLE = 70;
    private final int HEIGHT_LABEL_STYLE = 30;
    private final int DIMENSION_WIDTH = 70;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private final int GRID_LAYOUT_ROWS = 6;
    private final int GRID_LAYOUT_COLS = 2;
    private final String QUALITY_64KBPS = "64 \"Low\"";
    private final String QUALITY_128KBPS = "128 \"Standard\"";
    private final String QUALITY_192KBPS = "192 \"High\"";
    private final String QUALITY_320KBPS = "320 \"Very High\"";

    protected OutputSettingsAudio() {
        JLabelStyle qualityLabel = new JLabelStyle("Select Quality (Kbps): ", "h3",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        JLabelStyle volumeLabel = new JLabelStyle("Select Volume: ", "h3",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        JLabelStyle hzLabel = new JLabelStyle("Select Frequency (Hz): ", "h3",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        JLabelStyle audioChannelLabel = new JLabelStyle("Select Audio Channel: ", "h3",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        qualitySelect = new JComboBox();
        qualitySelect.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        qualitySelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setQualitySelect();
        volumeSelect = new JComboBox();
        volumeSelect.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        volumeSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setVolumeSelect();
        hzSelect = new JComboBox();
        hzSelect.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        hzSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setHzSelect();
        audioChannelSelect = new JComboBox();
        audioChannelSelect.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        audioChannelSelect.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        setAudioChannelSelect();
        metadataOption = new JCheckBox("With metadata");
        metadataOption.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));
        add(qualityLabel.getTextLabel());
        add(qualitySelect);
        add(volumeLabel.getTextLabel());
        add(volumeSelect);
        add(hzLabel.getTextLabel());
        add(hzSelect);
        add(audioChannelLabel.getTextLabel());
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
