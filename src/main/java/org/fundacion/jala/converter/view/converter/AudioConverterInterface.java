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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.Models.AudioRequestForm;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.SelectFile;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import static org.fundacion.jala.converter.core.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class creates the audio converter's UI.
 */
public class AudioConverterInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ConvertTypeSelectAudio audioSelect;
    private QualityAudio quality;
    private OutputSettingsAudio settings;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private String token;
    private String checksumLocal;

    public AudioConverterInterface(final String newToken) {
        final int MARGIN_SPACE = 30;
        final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
        final int MARGIN_BOTTOM_BTN_CONTAINER = 100;
        token = newToken;
        JLabelStyle audioTitle = new JLabelStyle("Audio converter", "h2");
        JLabelStyle audioSettings = new JLabelStyle("Audio settings", "h3");
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        audioSettings.setAlignmentX(LEFT_ALIGNMENT);
        BtnStyle convertAudio = new BtnStyle("Convert", 2);
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        audioSelect = new ConvertTypeSelectAudio();
        audioSelect.setAlignmentX(LEFT_ALIGNMENT);
        quality = new QualityAudio();
        quality.setAlignmentX(LEFT_ALIGNMENT);
        settings = new OutputSettingsAudio();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertAudio);
        JPanel container = new JPanel();
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(audioSettings);
        container.add(audioSelect);
        container.add(settings);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(audioTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Converts and sends information for metadataClass conversion then shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            checksumLocal = getFileChecksum(file.getOriginFilePath());
            JOptionPane.showMessageDialog(this, "File Path: " + file.getOriginFilePath()
                    + "\nConvert to: " + audioSelect.getConvertTo() + "\nQuality: " + settings.getQuality()
                    + "\nVolume: " + settings.getVolume() + "\nAudio Channel: " + settings.getAudioChannel()
                    + "\nHz: " + settings.getHz() + "\nwith metadata: " + settings.isMetadata() + "\nChecksum: "
                    + checksumLocal);
            callRequest();
            LOGGER.info("finish");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            LOGGER.error("Execute Exception");
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            LOGGER.error("Execute Exception");
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the request.
     *
     * @throws IOException when problems on inputs.
     */
    private void callRequest() throws IOException {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            AudioRequestForm audioRequestForm = new AudioRequestForm();
            audioRequestForm.addFilepath(file.getOriginFilePath());
            audioRequestForm.addFormat(audioSelect.getConvertTo());
            audioRequestForm.addBitrate(settings.getQuality());
            audioRequestForm.addVolume(settings.getVolume());
            audioRequestForm.addHz(settings.getHz());
            audioRequestForm.addAudiochannel(settings.getAudioChannel());
            audioRequestForm.addChecksum(checksumLocal);
            audioRequestForm.addMetadata(String.valueOf(settings.isMetadata()));
            String result = clientRequest.executeRequest(audioRequestForm, token);
            clientRequest.downloadFile(result);
            JOptionPane.showMessageDialog(this, "Download in :\n"
                    + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            System.out.println(result);
            LOGGER.info("finish");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            LOGGER.error("Execute Exception");
        }
        LOGGER.info("Finish");
    }
}
