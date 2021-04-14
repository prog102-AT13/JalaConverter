/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import static org.fundacion.jala.converter.service.ChecksumService.getFileChecksum;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AudioConverterInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ConvertTypeSelectAudio audioSelect;
    private QualityAudio quality;

    /**
     * Initialize of graphics elements for Audio converter interface.
     */
    public AudioConverterInterface() {
        JLabelStyle audioTitle = new JLabelStyle("Audio converter", "h1", 2, 70, 30);
        JLabelStyle audioSettings = new JLabelStyle("Audio settings", "h1", 2, 70, 30);
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        audioSettings.setAlignmentX(LEFT_ALIGNMENT);
        JButton convertAudio = new JButton("Convert");
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", 0, 12));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        audioSelect = new ConvertTypeSelectAudio();
        audioSelect.setAlignmentX(LEFT_ALIGNMENT);
        quality = new QualityAudio();
        quality.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(40, 40, 100, 0));
        add(audioTitle.getTextLabel());
        add(file);
        add(audioSettings.getTextLabel());
        add(audioSelect);
        add(quality);
        add(convertAudio);
    }

    /**
     * Action of JButton convert, send information for metadataCLASS conversion.
     * Show a Dialog with the information.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        try {
            JOptionPane.showMessageDialog(this, "File Path: "
                    + file.getOriginFilePath()
                    + "\nConvert to: "
                    + audioSelect.getConvertTo()
                    + "\nQuality: "
                    + quality.getQualityAudio()
                    + "\nChecksum: "
                    + getFileChecksum(file.getOriginFilePath()));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
    }
}
