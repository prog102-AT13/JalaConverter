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

import org.fundacion.jala.converter.view.utilities.ComboStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * This class defines the interface for output settings for audio to convert.
 */
class OutputSettingsAudio extends JPanel {
    private final int WIDTH_BOX = 5;
    private final int HEIGHT_BOX = 20;
    private final int SPACE_MARGIN = 30;
    private final int MARGIN_SPACE_LABEL = 28;
    private final int MARGIN_SPACE_TOP = 10;
    private ComboStyle qualitySelect;
    private ComboStyle volumeSelect;
    private ComboStyle hzSelect;
    private ComboStyle audioChannelSelect;
    private JCheckBox metadataOption;
    private JPanel container;
    private final int FONT_SIZE = 12;
    private final String QUALITY_64KBPS = "64 \"Low\"";
    private final String QUALITY_128KBPS = "128 \"Standard\"";
    private final String QUALITY_192KBPS = "192 \"High\"";
    private final String QUALITY_320KBPS = "320 \"Very High\"";
    private JLabelStyle qualityLabel;
    private JLabelStyle volumeLabel;
    private JLabelStyle hzLabel;
    private JLabelStyle audioChannelLabel;

    protected OutputSettingsAudio() {
        qualityLabel = new JLabelStyle("Select Quality (Kbps): ", "h4");
        volumeLabel = new JLabelStyle("Select Volume: ", "h4");
        hzLabel = new JLabelStyle("Select Frequency (Hz): ", "h4");
        audioChannelLabel = new JLabelStyle("Select Audio Channel: ", "h4");
        qualitySelect = new ComboStyle();
        setQualitySelect();
        volumeSelect = new ComboStyle();
        setVolumeSelect();
        hzSelect = new ComboStyle();
        setHzSelect();
        audioChannelSelect = new ComboStyle();
        setAudioChannelSelect();
        metadataOption = new JCheckBox("With metadata");
        metadataOption.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        setElementsPanels();
        setLayout(new BorderLayout(SPACE_MARGIN, SPACE_MARGIN));
        setBorder(new EmptyBorder(MARGIN_SPACE_TOP, 0, HEIGHT_BOX, 0));
        add(container, BorderLayout.CENTER);
    }

    /**
     * Sets the elements in Panels.
     */
    public void setElementsPanels() {
        JPanel labelContainer = new JPanel();
        labelContainer.setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));
        labelContainer.add(qualityLabel);
        labelContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, MARGIN_SPACE_LABEL)));
        labelContainer.add(volumeLabel);
        labelContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, MARGIN_SPACE_LABEL)));
        labelContainer.add(hzLabel);
        labelContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, MARGIN_SPACE_LABEL)));
        labelContainer.add(audioChannelLabel);
        JPanel comboContainer = new JPanel();
        comboContainer.setLayout(new BoxLayout(comboContainer, BoxLayout.Y_AXIS));
        comboContainer.add(qualitySelect);
        comboContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        comboContainer.add(volumeSelect);
        comboContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        comboContainer.add(hzSelect);
        comboContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        comboContainer.add(audioChannelSelect);
        JPanel element3container = new JPanel();
        element3container.setLayout(new FlowLayout(FlowLayout.LEFT, HEIGHT_BOX, HEIGHT_BOX));
        element3container.add(metadataOption);
        container = new JPanel();
        container.setLayout(new BorderLayout(SPACE_MARGIN, 0));
        container.add(labelContainer, BorderLayout.LINE_START);
        container.add(comboContainer, BorderLayout.CENTER);
        container.add(element3container, BorderLayout.SOUTH);
    }

    /**
     * Sets all possible quality for Audio converter.
     */
    protected void setQualitySelect() {
        qualitySelect.addItem(QUALITY_64KBPS);
        qualitySelect.addItem(QUALITY_128KBPS);
        qualitySelect.addItem(QUALITY_192KBPS);
        qualitySelect.addItem(QUALITY_320KBPS);
        qualitySelect.setSelectedIndex(1);
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
