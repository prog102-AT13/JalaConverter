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
    private JComboBox<FrameVideo> framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;

    /**
     * Initialize the graphic elements for output settings configurations.
     */
    protected OutputSettings() {
        JLabelStyle resolutionLabel = new JLabelStyle("Select resolution: ", "h3", 2, 70, 30);
        JLabelStyle frameLabel = new JLabelStyle("Select frame: ", "h3", 2, 70, 30);
        setResolutionSelect();
        resolutionComboBox.setFont(new Font("Barlow", 0, 12));
        resolutionComboBox.setPreferredSize(new Dimension(70, 30));
        setFrameSelect();
        framesSelect.setFont(new Font("Barlow", 0, 12));
        framesSelect.setPreferredSize(new Dimension(70, 30));

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
        framesSelect=new JComboBox<FrameVideo>(
                new FrameVideo[]{
                        new FrameVideo(21),
                        new FrameVideo(24),
                        new FrameVideo(27),
                        new FrameVideo(29),
                        new FrameVideo(30),
                        new FrameVideo(60)});
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
        ResolutionVideo resolutionVideo = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return resolutionVideo.getHeight();
    }

    /**
     * Method that get selected frame
     * for video converter.
     *
     * @return String, option selected of Frame.
     */
    protected int getFrame() {
        FrameVideo frameVideo=(FrameVideo)framesSelect.getSelectedItem();
        return frameVideo.getFrame();
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
