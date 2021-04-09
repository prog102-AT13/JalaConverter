/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

class OutputSettings extends JPanel {
    private JComboBox<ResolutionVideo> resolutionComboBox;

    private JComboBox framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;

    /**
     * Initialize the graphic elements for output settings configurations.
     */
    protected OutputSettings() {
        JLabelStyle resolutionLabel = new JLabelStyle("Select resolution: ", "h3", 2, 70, 30);
        JLabelStyle frameLabel = new JLabelStyle("Select frame: ", "h3", 2, 70, 30);

        //resolutionComboBox = new JComboBox<ResolutionVideo>(setResolutionSelect());
        setResolutionSelect();


        resolutionComboBox.setFont(new Font("Barlow", 0, 12));
        resolutionComboBox.setPreferredSize(new Dimension(70, 30));


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
        add(resolutionComboBox);
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

        resolutionComboBox = new JComboBox<ResolutionVideo>(
                new ResolutionVideo[]{
                        new ResolutionVideo("720p(HD)", 1280, 720),
                        new ResolutionVideo("1920p", 1080, 1920),
                        new ResolutionVideo("480p", 854, 480),
                        new ResolutionVideo("240p", 426, 240),
                        new ResolutionVideo("DVD", 720, 567),
                        new ResolutionVideo("TV", 640, 480),
                        new ResolutionVideo("Mobile", 320, 240)}
        );
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
     * Method that get selected width resolution
     * for video converter.
     *
     * @return int, width selected of Resolution.
     */
    protected int getWidthResolution() {
        ResolutionVideo item = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return item.getWidth();
    }

    /**
     * Method that get selected Height resolution
     * for video converter.
     *
     * @return int, Height selected of Resolution.
     */
    protected int getHeightResolution() {
        ResolutionVideo item = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return item.getHeight();
    }

    /**
     * Method that get selected frame
     * for video converter.
     *
     * @return String, option selected of Frame.
     */
    protected String getFrame() {
        return framesSelect.getSelectedItem().toString();
    }

    /**
     * Method that get if Sound is required
     * for video converter.
     *
     * @return true if audio is required, false if not.
     */
    protected boolean isAudioSelected() {
        return optionCSound.isSelected();
    }

    /**
     * Method that get if thumbnail is required
     * for video converter.
     *
     * @return true if thumbnail is required, false if not.
     */
    protected boolean isThumbnailRequired() {
        return thumbnailOption.isSelected();
    }
}
