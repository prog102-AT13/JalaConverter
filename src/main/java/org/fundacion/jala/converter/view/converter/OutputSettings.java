/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Ximena Aguilar Quiñones
 */
package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class defines the interface for output settings to convert.
 */
class OutputSettings extends JPanel {
    private JComboBox<ResolutionVideo> resolutionComboBox;
    private JComboBox<FrameVideo> framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;
    private JCheckBox metadataOption;
    private final int DIMENSIO_WIDTH = 70;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private final int GRID_LAYOUT_ROWS = 4;
    private final int GRID_LAYOUT_COLS = 2;

    protected OutputSettings() {
        JLabelStyle resolutionLabel = new JLabelStyle("Select resolution: ", "h3");
        JLabelStyle frameLabel = new JLabelStyle("Select frame: ", "h3");
        setResolutionSelect();
        resolutionComboBox.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        resolutionComboBox.setPreferredSize(new Dimension(DIMENSIO_WIDTH, DIMENSION_HEIGHT));
        setFrameSelect();
        framesSelect.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        framesSelect.setPreferredSize(new Dimension(DIMENSIO_WIDTH, DIMENSION_HEIGHT));
        optionCSound = new JCheckBox("Without audio");
        optionCSound.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        optionCSound.setSelected(false);
        thumbnailOption = new JCheckBox("With Thumbnail");
        thumbnailOption.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        metadataOption = new JCheckBox("Metadata");
        metadataOption.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));
        add(resolutionLabel);
        add(resolutionComboBox);
        add(frameLabel);
        add(framesSelect);
        add(optionCSound);
        add(thumbnailOption);
        add(metadataOption);
    }

    /**
     * Sets all possible resolutions for video converter.
     */
    protected void setResolutionSelect() {
        resolutionComboBox = new JComboBox<ResolutionVideo>(
                new ResolutionVideo[]{
                        new ResolutionVideo("720p(HD)", "1280", "720"),
                        new ResolutionVideo("1920p", "1080", "1920"),
                        new ResolutionVideo("480p", "854", "480"),
                        new ResolutionVideo("240p", "426", "240"),
                        new ResolutionVideo("DVD", "720", "567"),
                        new ResolutionVideo("TV", "640", "480"),
                        new ResolutionVideo("Mobile", "320", "240")}
        );
    }

    /**
     * Sets all possible frames for video converter.
     */
    protected void setFrameSelect() {
        framesSelect = new JComboBox<FrameVideo>(
                new FrameVideo[]{
                        new FrameVideo("21"),
                        new FrameVideo("24"),
                        new FrameVideo("27"),
                        new FrameVideo("29"),
                        new FrameVideo("30"),
                        new FrameVideo("60")});
    }

    /**
     * Gets selected width resolution for video converter.
     *
     * @return an int with selected resolution width.
     */
    protected String getWidthResolution() {
        ResolutionVideo item = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return item.getWidth();
    }

    /**
     * Gets selected Height resolution for video converter.
     *
     * @return an int with selected resolution height.
     */
    protected String getHeightResolution() {
        ResolutionVideo resolutionVideo = (ResolutionVideo) resolutionComboBox.getSelectedItem();
        return resolutionVideo.getHeight();
    }

    /**
     * Gets the selected frame for video converter.
     *
     * @return a String with the option selected of Frame.
     */
    protected String getFrame() {
        FrameVideo frameVideo = (FrameVideo) framesSelect.getSelectedItem();
        return frameVideo.getFrame();
    }

    /**
     * Gets if Sound is required for video converter.
     *
     * @return true if audio is required, false if not.
     */
    protected boolean isAudioSelected() {
        return optionCSound.isSelected();
    }

    /**
     * Gets if thumbnail is required for video converter.
     *
     * @return true if thumbnail is required, false if not.
     */
    protected boolean isThumbnailRequired() {
        return thumbnailOption.isSelected();
    }

    /**
     * Gets if metadata is required for video converter.
     *
     * @return true if metadata is required, false if not.
     */
    protected boolean isMetadataRequired() {
        return metadataOption.isSelected();
    }
}
