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
import org.fundacion.jala.converter.core.exceptions.ChecksumException;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.Models.AudioRequestForm;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.SelectFile;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static org.fundacion.jala.converter.core.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFormatAudioSupport;

/**
 * This class creates the audio converter's UI.
 */
public class AudioConverterInterface extends JPanel implements ActionListener {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int TOP_BORDER = 40;
    private final int LEFT_BORDER = 40;
    private final int BOTTOM_BORDER = 100;
    private final int RIGHT_BORDER = 0;
    private final int FONT_SIZE = 12;
    private final int MARGIN_SPACE = 30;
    private final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
    private final int MARGIN_BOTTOM_BTN_CONTAINER = 100;
    private final int BTN_TYPE = 2;
    private SelectFile file;
    private ConvertTypeSelectAudio audioSelect;
    private OutputSettingsAudio settings;
    private ClientRequest clientRequest = new ClientRequest();
    private String token;
    private String checksumLocal;
    private JLabel label;

    public AudioConverterInterface(final String newToken) {
        token = newToken;
        JLabelStyle audioTitle = new JLabelStyle("Audio converter", "h2");
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        BtnStyle convertAudio = new BtnStyle("Convert", BTN_TYPE);
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        audioSelect = new ConvertTypeSelectAudio();
        audioSelect.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        settings = new OutputSettingsAudio();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        ImageIcon icon = new ImageIcon("img/loading.gif");
        label = new JLabel();
        label.setIcon(new ImageIcon(icon.getImage()));
        label.setVisible(false);
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertAudio);
        btnContainer.add(label);
        JPanel container = new JPanel();
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
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
        if (checkFileSelect(file.getOriginFilePath())) {
            if(checkFormatAudioSupport(file.getOriginFilePath(), dotenv.get("AUDIO_FORMAT_SUPPORT"))) {
                label.setVisible(true);
                try {
                    LOGGER.info("Execute Try");
                    checksumLocal = getFileChecksum(file.getOriginFilePath());
                    int option = JOptionPane.showConfirmDialog(this, "File Path: " + file.getOriginFilePath()
                            + "\nConvert to: " + audioSelect.getConvertTo() + "\nQuality: " + settings.getQuality()
                            + "\nVolume: " + settings.getVolume() + "\nAudio Channel: " + settings.getAudioChannel()
                            + "\nHz: " + settings.getHz() + "\nwith metadata: " + settings.isMetadata() + "\nChecksum: "
                            + checksumLocal, "Message confirm", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        callRequest();
                    } else {
                        label.setVisible(false);
                    }
                    LOGGER.info("finish");
                } catch (ChecksumException checksumException) {
                    checksumException.printStackTrace();
                }
                LOGGER.info("finish");
            }
        }

        LOGGER.info("Finish");
    }

    /**
     * Obtains the request.
     *
     * @throws ChecksumException if process is interrupted.
     */
    private void callRequest() throws ChecksumException {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            AudioRequestForm audioRequestForm = new AudioRequestForm();
            audioRequestForm.addFilepath(file.getOriginFilePath());
            audioRequestForm.addFormat(audioSelect.getConvertTo());
            String getNumberQuality [] = settings.getQuality().split(" ");
            audioRequestForm.addBitrate(getNumberQuality[0]);
            audioRequestForm.addVolume(settings.getVolume());
            audioRequestForm.addHz(settings.getHz());
            audioRequestForm.addAudiochannel(settings.getAudioChannel());
            audioRequestForm.addChecksum(checksumLocal);
            audioRequestForm.addMetadata(String.valueOf(settings.isMetadata()));
            String result = clientRequest.executeRequest(audioRequestForm, token);
            clientRequest.downloadFile(result);
            JOptionPane.showMessageDialog(this, "Download in :\n"
                    + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            label.setVisible(false);
            System.out.println(result);
            LOGGER.info("finish");
        } catch (IOException ioException) {
            LOGGER.error("Execute Exception");
            throw new ChecksumException(ioException);
        }
        LOGGER.info("Finish");
    }
}
