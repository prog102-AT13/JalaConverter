/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class VideoConverterInterface extends JPanel implements ActionListener{
    private SelectFile file;
    private ConverterTypeSelect menuConverterType;
    private OutputSettings settings;

    /**
     * Set all the graphics elements for the main interface of Video Converter.
     */
    public VideoConverterInterface() {
        JLabelStyle videoTitle = new JLabelStyle("Select Video:", "h2", 0, 100, 30);
        videoTitle.setAlignmentX(LEFT_ALIGNMENT);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        menuConverterType = new ConverterTypeSelect();
        menuConverterType.setAlignmentX(LEFT_ALIGNMENT);
        JButton converterVideoButton = new JButton("Convert Video");
        converterVideoButton.setFont(new Font("Barlow", 0, 12));
        converterVideoButton.addActionListener(this::actionPerformed);
        settings = new OutputSettings();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(50, 50, 100, 70));
        add(videoTitle.getTextLabel());
        add(file);
        add(menuConverterType);
        add(settings);
        add(converterVideoButton);
    }

    /**
     * Action of JButton convert, send information for metadataCLASS conversion.
     * Show a Dialog with the information.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(this, "File Path: "
                + file.getOriginFilePath()
                + "\nConvert to:"
                + menuConverterType.getConvertTo()
                + "\nResolutionWidth: "
                + settings.getWidthResolution()
                + "\nResolutionHeight: "
                + settings.getHeightResolution()
                + "\nFrames: "
                + settings.getFrame()
                + "\nSound: "
                + settings.isAudioSelected()
                + "\nThumbnail: "
                + settings.isThumbnailRequired());
    }
}




