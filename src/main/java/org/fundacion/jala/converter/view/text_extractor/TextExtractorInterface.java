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
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.SelectFile;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class shows the extractText interface.
 */
public class TextExtractorInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private SelectLanguage languageSelect;
    private ClientRequest clientRequest = new ClientRequest();
    private final Logger LOGGER = LogManager.getLogger();
    private String token;

    public TextExtractorInterface(final String newToken) {
        final int MARGIN_SPACE = 30;
        final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
        final int MARGIN_BOTTOM_BTN_CONTAINER = 200;
        token = newToken;
        JLabelStyle lblTxtExtractor = new JLabelStyle("Text extractor", "h2");
        BtnStyle convertTxtExtract = new BtnStyle("Extract", 2);
        convertTxtExtract.addActionListener(this::actionPerformed);
        file = new SelectFile();
        languageSelect = new SelectLanguage();
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertTxtExtract);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(languageSelect);
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(lblTxtExtractor.getTextLabel(), BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Converts and sends information for metadata CLASS conversion then shows a Dialog with the information.
     *
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
