/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.*;
import java.awt.*;

class OutputSettingsAudio extends JPanel {
    private JComboBox volumeSelect;
    private JComboBox hzSelect;
    private JComboBox audioChannelSelect;
    private JCheckBox metadataOption;

    /**
     * Initialize the graphic elements for output settings configurations.
     */
    protected OutputSettingsAudio() {
        JLabelStyle volumeLabel = new JLabelStyle("Select Volume: ", "h3", 2, 70, 20);
        JLabelStyle hzLabel = new JLabelStyle("Select Hz: ", "h3", 2, 70, 20);
        JLabelStyle audioChannelLabel = new JLabelStyle("Select Audio Channel: ", "h3", 2, 70, 20);
        volumeSelect = new JComboBox();
        volumeSelect.setFont(new Font("Barlow", 0, 12));
        volumeSelect.setPreferredSize(new Dimension(70, 30));
        setVolumeSelect();
        hzSelect = new JComboBox();
        hzSelect.setFont(new Font("Barlow", 0, 12));
        hzSelect.setPreferredSize(new Dimension(70, 30));
        setHzSelect();
        audioChannelSelect = new JComboBox();
        audioChannelSelect.setFont(new Font("Barlow", 0, 12));
        audioChannelSelect.setPreferredSize(new Dimension(70, 30));
        setAudioChannelSelect();
        metadataOption = new JCheckBox("With metadata");
        metadataOption.setFont(new Font("Barlow", 0, 12));
        setLayout(new GridLayout(4, 2));
        add(volumeLabel.getTextLabel());

        add(volumeSelect);
        add(hzLabel.getTextLabel());
        add(hzSelect);
        add(audioChannelLabel.getTextLabel());
        add(audioChannelSelect);
        add(metadataOption);
    }

    /**
     * Method that set all possible volume
     * for Audio converter.
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
     * Method that set all possible Hz
     * for Audio converter.
     */
    protected void setHzSelect() {
        hzSelect.addItem(" ");
        hzSelect.addItem("20");
        hzSelect.addItem("44");
        hzSelect.addItem("48");
    }

    /**
     * Method that set all possible Audio Channel
     * for Audio converter.
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
     * Method that get selected volume
     * for Audio converter.
     * @return String, option selected of volume.
     */
    protected String getVolume() {
        return volumeSelect.getSelectedItem().toString();
    }

    /**
     * Method that get selected Hz
     * for Audio converter.
     * @return String, option selected of Hz.
     */
    protected String getHz() {
        return hzSelect.getSelectedItem().toString();
    }

    /**
     * Method that get selected AudioChannel
     * for Audio converter.
     * @return String, option selected of AudioChannel.
     */
    protected String getAudioChannel() {
        return audioChannelSelect.getSelectedItem().toString();
    }

    /**
     * Method that get if metadata is required
     * for Audio converter.
     * @return true if metadata is required, false if not.
     */
    protected boolean isMetadata() {
        return metadataOption.isSelected();
    }
}
