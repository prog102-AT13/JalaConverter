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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.Models.ExtractTextRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextExtractorInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private SelectLanguage languageSelect;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 70;
    private final int heightLabelStyle = 30;
    private final int topBorder = 40;
    private final int leftBorder = 40;
    private final int bottomBorder = 100;
    private final int rightBorder = 0;
    private final int fontStyle = 0;
    private final int fontSize = 12;

    /**
     * Initializes graphics elements for Audio converter interface.
     */
    public TextExtractorInterface() {
        JLabelStyle audioTitle = new JLabelStyle("Text extractor", "h1", alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle audioSettings = new JLabelStyle("Image settings", "h1", alignLabelStyle, widthLabelStyle, heightLabelStyle);
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        audioSettings.setAlignmentX(LEFT_ALIGNMENT);
        JButton convertAudio = new JButton("Convert");
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", fontStyle, fontSize));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        languageSelect = new SelectLanguage();
        languageSelect.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(audioTitle.getTextLabel());
        add(file);
        add(audioSettings.getTextLabel());
        add(languageSelect);
        add(convertAudio);
    }

    /**
     * Converts, sends information for metadataCLASS conversion.
     * Shows a Dialog with the information.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(this, "File Path: "
                + file.getOriginFilePath()
                + "\nConvert to: "
                + languageSelect.getConvertTo());
        try {
            LOGGER.info("Execute Try");
            callRequest();
        } catch (Exception ex) {
            LOGGER.error("Execute Exception to text extraction");
            ex.printStackTrace();
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the request
     * @throws IOException
     */
    private void callRequest() throws IOException {
        LOGGER.info("start");
        ExtractTextRequestForm extractTextRequestFormat = new ExtractTextRequestForm();
        extractTextRequestFormat.addFilepath(file.getOriginFilePath());
        extractTextRequestFormat.addLanguageFormat(languageSelect.getConvertTo());
        try {
            LOGGER.info("Execute Try");
            String result = clientRequest.executeRequest(extractTextRequestFormat);
            JOptionPane.showMessageDialog(this, "Download Link:\n" + result);
            System.out.println(result);
        } catch (IOException e) {
            LOGGER.error("Execute Exception to obtain the request");
            e.printStackTrace();
        }
        LOGGER.info("Finish");
    }
}
