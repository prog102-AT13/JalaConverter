/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
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

import static org.fundacion.jala.converter.ConverterApplication.dotenv;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;

/**
 * This class shows the extractText interface.
 */
public class TextExtractorInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private SelectLanguage languageSelect;
    private ClientRequest clientRequest = new ClientRequest();
    private final Logger LOGGER = LogManager.getLogger();
    private final int ALIGN_LABEL_STYLE = 2;
    private final int WIDTH_LABEL_STYLE = 70;
    private final int HEIGHT_LABEL_STYLE = 30;
    private final int TOP_BORDER = 40;
    private final int LEFT_BORDER = 40;
    private final int BOTTOM_BORDER = 100;
    private final int RIGHT_BORDER = 0;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private String token;

    public TextExtractorInterface(final String newToken) {
        token = newToken;
        JLabelStyle audioTitle = new JLabelStyle("Text extractor", "h1",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        JLabelStyle audioSettings = new JLabelStyle("Image settings", "h1",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        audioSettings.setAlignmentX(LEFT_ALIGNMENT);
        JButton convertAudio = new JButton("Extract");
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        languageSelect = new SelectLanguage();
        languageSelect.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        add(audioTitle.getTextLabel());
        add(file);
        add(audioSettings.getTextLabel());
        add(languageSelect);
        add(convertAudio);
    }

    /**
     * Converts and sends information for metadata CLASS conversion then shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (checkFileSelect(file.getOriginFilePath())) {
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
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the request.
     *
     * @throws IOException when invalid username or password is given.
     */
    private void callRequest() throws IOException {
        LOGGER.info("start");
        ExtractTextRequestForm extractTextRequestFormat = new ExtractTextRequestForm();
        extractTextRequestFormat.addFilepath(file.getOriginFilePath());
        extractTextRequestFormat.addLanguageFormat(languageSelect.getConvertTo());
        try {
            LOGGER.info("Execute Try");
            String result = clientRequest.executeRequest(extractTextRequestFormat, token);
            clientRequest.downloadFile(result);
            JOptionPane.showMessageDialog(this, "Downloaded in :\n"
                    + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            System.out.println(result);
        } catch (IOException e) {
            LOGGER.error("Execute Exception to obtain the request");
            e.printStackTrace();
        }
        LOGGER.info("Finish");
    }
}
