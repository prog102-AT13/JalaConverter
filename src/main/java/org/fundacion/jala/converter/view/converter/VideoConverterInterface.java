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
import org.fundacion.jala.converter.view.Models.VideoRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import org.fundacion.jala.converter.view.utilities.SelectFile;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;
import static org.fundacion.jala.converter.core.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFormatAudioSupport;

/**
 * This class creates the video converter's UI.
 */
public class VideoConverterInterface extends JPanel implements ActionListener {
    private final int CONVERT_TYPE_BTN = 2;
    final int MARGIN_SPACE = 30;
    final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
    final int MARGIN_BOTTOM_BTN_CONTAINER = 100;
    private SelectFile file;
    private ConverterTypeSelect menuConverterType;
    private OutputSettings settings;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private String token;
    private String checksumLocal;
    private JLabel label;


    public VideoConverterInterface(final String newToken) {
        token = newToken;
        JLabelStyle videoTitle = new JLabelStyle("Select Video:", "h2");
        videoTitle.setAlignmentX(LEFT_ALIGNMENT);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        menuConverterType = new ConverterTypeSelect();
        menuConverterType.setAlignmentX(LEFT_ALIGNMENT);
        BtnStyle converterVideoButton = new BtnStyle("Convert", CONVERT_TYPE_BTN);
        converterVideoButton.setFont(new Font("Barlow", fontStyle, fontSize));
        converterVideoButton.addActionListener(this::actionPerformed);
        settings = new OutputSettings();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        ImageIcon icon = new ImageIcon("img/loading.gif");
        label = new JLabel();
        label.setIcon(new ImageIcon(icon.getImage()));
        label.setVisible(false);
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(converterVideoButton);
        btnContainer.add(label);
        JPanel container = new JPanel();
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(menuConverterType);
        container.add(settings);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(videoTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Converts and sends information for metadataClass conversion then Shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        LOGGER.info("start");
        if (checkFileSelect(file.getOriginFilePath())) {
            if(checkFormatAudioSupport(file.getOriginFilePath(), dotenv.get("VIDEO_FORMAT_SUPPORT"))) {
                label.setVisible(true);
                try {
                    LOGGER.info("Execute Try");
                    checksumLocal = getFileChecksum(file.getOriginFilePath());
                    int option = JOptionPane.showConfirmDialog(this, "File Path: "
                            + file.getOriginFilePath()
                            + "\nConvert to:" + menuConverterType.getConvertTo() + "\nResolutionWidth: "
                            + settings.getWidthResolution() + "\nResolutionHeight: " + settings.getHeightResolution()
                            + "\nFrames: " + settings.getFrame() + "\nSound: " + settings.isAudioSelected() + "\nThumbnail: "
                            + settings.isThumbnailRequired() + "\nMetadata: " + settings.isMetadataRequired() + "\nChecksum: "
                            + checksumLocal, "Message confirm", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        callRequest();
                    } else {
                        label.setVisible(false);
                    }
                    LOGGER.info("finish");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    LOGGER.error("Execute Exception");
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                    LOGGER.error("Execute Exception");
                }
            }
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the request.
     *
     * @throws IOException when problems on inputs and outputs.
     */
    private void callRequest() throws IOException {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            VideoRequestForm videoRequestForm = new VideoRequestForm();
            videoRequestForm.addFilepath(file.getOriginFilePath());
            videoRequestForm.addOutputFormat(menuConverterType.getConvertTo());
            videoRequestForm.addThumbnail(String.valueOf(settings.isThumbnailRequired()));
            videoRequestForm.addFrameRate(settings.getFrame());
            videoRequestForm.addWidth(settings.getWidthResolution());
            videoRequestForm.addHeight(settings.getHeightResolution());
            videoRequestForm.addAudio(String.valueOf(settings.isAudioSelected()));
            videoRequestForm.addResolution(settings.getWidthResolution());
            videoRequestForm.addChecksum(checksumLocal);
            videoRequestForm.addMetadata(String.valueOf(settings.isMetadataRequired()));
            String result = clientRequest.executeRequest(videoRequestForm, token);
            clientRequest.downloadFile(result);
            JOptionPane.showMessageDialog(this, "Download in :\n"
                    + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            label.setVisible(false);
            System.getProperty("file.separator");
            System.out.println(result);
            LOGGER.info("finish");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            LOGGER.error("Execute Exception");
        }
        LOGGER.info("Finish");
    }
}
