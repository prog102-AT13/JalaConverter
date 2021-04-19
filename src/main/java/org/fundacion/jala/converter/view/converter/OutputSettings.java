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

class OutputSettings extends JPanel {
    private JComboBox<ResolutionVideo> resolutionComboBox;
    private JComboBox<FrameVideo> framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 70;
    private final int heightLabelStyle = 30;
    private final int dimensionWidth = 70;
    private final int dimensionHeight = 30;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int gridLayoutRows = 3;
    private final int gridLayoutCols = 2;

    /**
     * Initializes the graphic elements for output settings configurations.
     */
    protected OutputSettings() {
        JLabelStyle resolutionLabel = new JLabelStyle("Select resolution: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle frameLabel = new JLabelStyle("Select frame: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        setResolutionSelect();
        resolutionComboBox.setFont(new Font("Barlow", fontStyle, fontSize));
        resolutionComboBox.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        setFrameSelect();
        framesSelect.setFont(new Font("Barlow", fontStyle, fontSize));
        framesSelect.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        optionCSound = new JCheckBox("With audio");
        optionCSound.setFont(new Font("Barlow", fontStyle, fontSize));
        optionCSound.setSelected(true);
        thumbnailOption = new JCheckBox("With Thumbnail");
        thumbnailOption.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new GridLayout(gridLayoutRows, gridLayoutCols));
        add(resolutionLabel.getTextLabel());
        add(resolutionComboBox);
        add(frameLabel.getTextLabel());
        add(framesSelect);
        add(optionCSound);
        add(thumbnailOption);
    }

    /**
     * Sets all possible resolutions for video converter.
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
     * Sets all possible resolutions for video converter.
     */
    protected void setFrameSelect() {
        framesSelect = new JComboBox<FrameVideo>(
                new FrameVideo[]{
                        new FrameVideo(21),
                        new FrameVideo(24),
                        new FrameVideo(27),
                        new FrameVideo(29),
                        new FrameVideo(30),
                        new FrameVideo(60)});
    }

    /**
     * Gets selected width resolution for video converter.
     * @return int, width selected of Resolution.
     */
    protected int getWidthResolution() {
        ResolutionVideo item = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return item.getWidth();
    }

    /**
     * Gets selected Height resolution for video converter.
     * @return int, Height selected of Resolution.
     */
    protected int getHeightResolution() {
        ResolutionVideo resolutionVideo = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return resolutionVideo.getHeight();
    }

    /**
     * Gets the selected frame for video converter.
     * @return String, option selected of Frame.
     */
    protected int getFrame() {
        FrameVideo frameVideo = (FrameVideo) framesSelect.getSelectedItem();
        return frameVideo.getFrame();
    }

    /**
     * Gets if Sound is required for video converter.
     * @return true if audio is required, false if not.
     */
    protected boolean isAudioSelected() {
        return optionCSound.isSelected();
    }

    /**
     * Gets if thumbnail is required for video converter.
     * @return true if thumbnail is required, false if not.
     */
    protected boolean isThumbnailRequired() {
        return thumbnailOption.isSelected();
    }
}
