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

import org.fundacion.jala.converter.view.utilities.ComboStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * This class defines the interface for output settings to convert.
 */
class OutputSettings extends JPanel {
    private final int FONT_SIZE = 12;
    private final int WIDTH_BOX = 5;
    private final int HEIGHT_BOX = 20;
    private final int SPACE_MARGIN = 30;
    private final int MARGIN_SPACE_TOP = 10;
    private ComboStyle<ResolutionVideo> resolutionComboBox;
    private ComboStyle<FrameVideo> framesSelect;
    private JCheckBox optionCSound;
    private JCheckBox thumbnailOption;
    private JCheckBox metadataOption;
    private JPanel container;
    private JLabelStyle resolutionLabel;
    private JLabelStyle frameLabel;

    protected OutputSettings() {
        resolutionLabel = new JLabelStyle("Select resolution: ", "h3");
        frameLabel = new JLabelStyle("Select frame: ", "h3");
        setResolutionSelect();
        setFrameSelect();
        optionCSound = new JCheckBox("Without audio");
        optionCSound.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        optionCSound.setSelected(false);
        thumbnailOption = new JCheckBox("With Thumbnail");
        thumbnailOption.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        metadataOption = new JCheckBox("Metadata");
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
        labelContainer. setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));
        labelContainer.add(resolutionLabel);
        labelContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        labelContainer.add(frameLabel);
        JPanel comboContainer = new JPanel();
        comboContainer. setLayout(new BoxLayout(comboContainer, BoxLayout.Y_AXIS));
        comboContainer.add(resolutionComboBox);
        comboContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        comboContainer.add(framesSelect);
        JPanel element3container = new JPanel();
        element3container.setLayout(new FlowLayout(FlowLayout.LEFT, HEIGHT_BOX, HEIGHT_BOX));
        element3container.add(optionCSound);
        element3container.add(thumbnailOption);
        element3container.add(metadataOption);
        container = new JPanel();
        container.setLayout(new BorderLayout(SPACE_MARGIN, 0));
        container.add(labelContainer, BorderLayout.LINE_START);
        container.add(comboContainer, BorderLayout.CENTER);
        container.add(element3container, BorderLayout.SOUTH);
    }

    /**
     * Sets all possible resolutions for video converter.
     */
    protected void setResolutionSelect() {
        resolutionComboBox = new ComboStyle<>(
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
        final int DEFAULT_INDEX = 4;
        framesSelect = new ComboStyle<>(
                new FrameVideo[]{
                        new FrameVideo("21"),
                        new FrameVideo("24"),
                        new FrameVideo("27"),
                        new FrameVideo("29"),
                        new FrameVideo("30"),
                        new FrameVideo("60")});
        framesSelect.setSelectedIndex(DEFAULT_INDEX);
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
