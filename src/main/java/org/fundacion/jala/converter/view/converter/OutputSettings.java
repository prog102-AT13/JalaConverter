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

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

public class OutputSettings extends JPanel{
    private JComboBox resolutionSelect;
    private JComboBox framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;

    /**
     * Initialize the graphic elements for output settings configurations.
     */
    OutputSettings() {
        JLabelStyle resolutionLabel = new JLabelStyle("Select resolution: ", "h3", 2, 70, 30);
        JLabelStyle frameLabel = new JLabelStyle("Select frame: ", "h3", 2, 70, 30);
        resolutionSelect = new JComboBox();
        resolutionSelect.setFont(new Font("Barlow", 0, 12));
        resolutionSelect.setPreferredSize(new Dimension(70, 30));
        setResolutionSelect();
        framesSelect = new JComboBox();
        framesSelect.setFont(new Font("Barlow", 0, 12));
        framesSelect.setPreferredSize(new Dimension(70, 30));
        setFrameSelect();
        optionCSound = new JCheckBox("With audio");
        optionCSound.setFont(new Font("Barlow", 0, 12));
        optionCSound.setSelected(true);
        thumbnailOption = new JCheckBox("With Thumbnail");
        thumbnailOption.setFont(new Font("Barlow", 0, 12));
        setLayout(new GridLayout(3, 2));
        add(resolutionLabel.getTextLabel());
        add(resolutionSelect);
        add(frameLabel.getTextLabel());
        add(framesSelect);
        add(optionCSound);
        add(thumbnailOption);

    }

    /**
     * Method that set all possible resolutions
     * for video converter.
     */
    protected void setResolutionSelect() {
        resolutionSelect.addItem("Original resolution");
        resolutionSelect.addItem("HD720p\t1280x720");
        resolutionSelect.addItem("1920p\t108x1920");
        resolutionSelect.addItem("480p\t854x480");
        resolutionSelect.addItem("240p\t426x240");
        resolutionSelect.addItem("DVD\t720x567");
        resolutionSelect.addItem("Television\t640x480");
        resolutionSelect.addItem("Mobile\t320x240");
    }

    /**
     * Method that set all possible resolutions
     * for video converter.
     */
    protected void setFrameSelect() {
        framesSelect.addItem("Original frame");
        framesSelect.addItem("21F");
        framesSelect.addItem("24F");
        framesSelect.addItem("27F");
        framesSelect.addItem("29,9F");
        framesSelect.addItem("30F");
        framesSelect.addItem("60F");
    }

    /**
     * Method that get selected resolution
     * for video converter.
     * @return String, option selected of Resolution.
     */
    protected String getResolution() {
        return resolutionSelect.getSelectedItem().toString();
    }

    /**
     * Method that get selected frame
     * for video converter.
     * @return String, option selected of Frame.
     */
    protected String getFrame() {
        return framesSelect.getSelectedItem().toString();
    }

    /**
     * Method that get if Sound is required
     * for video converter.
     * @return true if audio is required, false if not.
     */
    protected boolean isAudioSelected() {
        return optionCSound.isSelected();
    }

    /**
     * Method that get if thumbnail is required
     * for video converter.
     * @return true if thumbnail is required, false if not.
     */
    protected boolean isThumbnailRequired() {
        return thumbnailOption.isSelected();
    }
}
