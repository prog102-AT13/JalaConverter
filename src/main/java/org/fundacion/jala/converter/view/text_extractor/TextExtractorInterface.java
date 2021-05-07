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
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFormatAudioSupport;

/**
 * This class shows the extractText interface.
 */
public class TextExtractorInterface extends JPanel implements ActionListener {
    private final Logger LOGGER = LogManager.getLogger();
    private final int MARGIN_SPACE = 30;
    private final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
    private final int MARGIN_BOTTOM_BTN_CONTAINER = 200;
    private final int CONVERT_TYPE_BTN = 2;
    private SelectFile file;
    private SelectLanguage languageSelect;
    private ClientRequest clientRequest = new ClientRequest();
    private String token;
    private JPanel btnContainer;
    private JPanel container;
    private BtnStyle convertTxtExtract;

    public TextExtractorInterface(final String newToken) {
        token = newToken;
        JLabelStyle lblTxtExtractor = new JLabelStyle("Text extractor", "h2");
        convertTxtExtract = new BtnStyle("Extract", CONVERT_TYPE_BTN);
        convertTxtExtract.addActionListener(this::actionPerformed);
        file = new SelectFile();
        languageSelect = new SelectLanguage();
        setPanel();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(lblTxtExtractor, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Sets the position in Panel for elements.
     */
    public void setPanel() {
        btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertTxtExtract);
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(languageSelect);
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
    }

    /**
     * Converts and sends information for metadata CLASS conversion then shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (checkFileSelect(file.getOriginFilePath())) {
            if(checkFormatAudioSupport(file.getOriginFilePath(), dotenv.get("TEXT_FORMAT_SUPPORT"))) {
                int option = JOptionPane.showConfirmDialog(this, "File Path: "
                        + file.getOriginFilePath()
                        + "\nConvert to: "
                        + languageSelect.getConvertTo(), "Message confirm", JOptionPane.YES_NO_OPTION);
                try {
                    LOGGER.info("Execute Try");
                    if (option == 0) {
                        callRequest();
                    }
                } catch (Exception ex) {
                    LOGGER.error("Execute Exception to text extraction");
                    ex.printStackTrace();
                }
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
