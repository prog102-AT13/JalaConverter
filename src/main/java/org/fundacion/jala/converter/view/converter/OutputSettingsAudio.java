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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class defines the interface for output settings for audio to convert.
 */
class OutputSettingsAudio extends JPanel {
    private JComboBox volumeSelect;
    private JComboBox hzSelect;
    private JComboBox audioChannelSelect;
    private JCheckBox metadataOption;
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 70;
    private final int heightLabelStyle = 30;
    private final int dimensionWidth = 70;
    private final int dimensionHeight = 30;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int gridLayoutRows = 4;
    private final int gridLayoutCols = 2;

    protected OutputSettingsAudio() {
        JLabelStyle volumeLabel = new JLabelStyle("Select Volume: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle hzLabel = new JLabelStyle("Select Hz: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle audioChannelLabel = new JLabelStyle("Select Audio Channel: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        volumeSelect = new JComboBox();
        volumeSelect.setFont(new Font("Barlow", fontStyle, fontSize));
        volumeSelect.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        setVolumeSelect();
        hzSelect = new JComboBox();
        hzSelect.setFont(new Font("Barlow", fontStyle, fontSize));
        hzSelect.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        setHzSelect();
        audioChannelSelect = new JComboBox();
        audioChannelSelect.setFont(new Font("Barlow", fontStyle, fontSize));
        audioChannelSelect.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        setAudioChannelSelect();
        metadataOption = new JCheckBox("With metadata");
        metadataOption.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new GridLayout(gridLayoutRows, gridLayoutCols));
        add(volumeLabel.getTextLabel());
        add(volumeSelect);
        add(hzLabel.getTextLabel());
        add(hzSelect);
        add(audioChannelLabel.getTextLabel());
        add(audioChannelSelect);
        add(metadataOption);
    }

    /**
     * Sets all possible volume for Audio converter.
     */
    protected void setVolumeSelect() {
        volumeSelect.addItem(" ");
        volumeSelect.addItem("1");
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
     * Gets selected volume for Audio converter.
     *
     * @return String, option selected of volume.
     */
    protected String getVolume() {
        return volumeSelect.getSelectedItem().toString();
    }

    /**
     * Gets selected Hz for Audio converter.
     *
     * @return String, option selected of Hz.
     */
    protected String getHz() {
        return hzSelect.getSelectedItem().toString();
    }

    /**
     * Gets selected AudioChannel for Audio converter.
     *
     * @return String, option selected of AudioChannel.
     */
    protected String getAudioChannel() {
        return audioChannelSelect.getSelectedItem().toString();
    }

    /**
     * Gets if metadata is required for Audio converter.
     *
     * @return true if metadata is required, false if not.
     */
    protected boolean isMetadata() {
        return metadataOption.isSelected();
    }
}
