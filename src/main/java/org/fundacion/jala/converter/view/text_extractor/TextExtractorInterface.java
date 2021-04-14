/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */
package org.fundacion.jala.converter.view.text_extractor;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextExtractorInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private SelectLanguage languageSelect;

    /**
     * Initialize of graphics elements for Audio converter interface.
     */
    public TextExtractorInterface() {
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
        languageSelect = new SelectLanguage();
        languageSelect.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(40, 40, 100, 0));
        add(audioTitle.getTextLabel());
        add(file);
        add(audioSettings.getTextLabel());
        add(languageSelect);
        add(convertAudio);
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
                + "\nConvert to: "
                + languageSelect.getConvertTo()
                + "\nQuality: ");
    }
}