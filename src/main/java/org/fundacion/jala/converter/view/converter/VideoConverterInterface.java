/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.Models.VideoRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

public class VideoConverterInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ConverterTypeSelect menuConverterType;
    private OutputSettings settings;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int alignLabelStyle = 0;
    private final int widthLabelStyle = 100;
    private final int heightLabelStyle = 30;
    private final int topBorder = 50;
    private final int leftBorder = 50;
    private final int bottomBorder = 100;
    private final int rightBorder = 70;
    private final int fontStyle = 0;
    private final int fontSize = 12;

    /**
     * Sets all the graphics elements for the main interface of Video Converter.
     */
    public VideoConverterInterface() {
        JLabelStyle videoTitle = new JLabelStyle("Select Video:", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        videoTitle.setAlignmentX(LEFT_ALIGNMENT);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        menuConverterType = new ConverterTypeSelect();
        menuConverterType.setAlignmentX(LEFT_ALIGNMENT);
        JButton converterVideoButton = new JButton("Convert");
        converterVideoButton.setFont(new Font("Barlow", fontStyle, fontSize));
        converterVideoButton.addActionListener(this::actionPerformed);
        settings = new OutputSettings();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(videoTitle.getTextLabel());
        add(file);
        add(menuConverterType);
        add(settings);
        add(converterVideoButton);
    }

    /**
     * Converts, sends information for metadataClass conversion.
     * Shows a Dialog with the information.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        LOGGER.info("Start");
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
                + settings.isThumbnailRequired()
                + "\nMetadata: "
                + settings.isMetadataRequired());
        try {
            LOGGER.info("Execute Try");
            callRequest();
        } catch (Exception ex) {
            LOGGER.error("Execute Exception to metaData conversion");
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
        VideoRequestForm videoRequestForm = new VideoRequestForm();
        videoRequestForm.addFilepath(file.getOriginFilePath());
        videoRequestForm.addOutputFormat(menuConverterType.getConvertTo());
        videoRequestForm.addThumbnail(String.valueOf(settings.isThumbnailRequired()));
        videoRequestForm.addFrameRate(settings.getFrame());
        videoRequestForm.addWidth(settings.getWidthResolution());
        videoRequestForm.addHeight(settings.getHeightResolution());
        videoRequestForm.addAudio(String.valueOf(settings.isAudioSelected()));
        videoRequestForm.addMetadata(String.valueOf(settings.isMetadataRequired()));
        videoRequestForm.addResolution(settings.getWidthResolution());
        try {
            LOGGER.info("Execute Try");
            String result = clientRequest.executeRequest(videoRequestForm);
            JOptionPane.showMessageDialog(this, "Download in :\n" + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            System.getProperty("file.separator");
            System.out.println(result);
        } catch (IOException e) {
            LOGGER.error("Execute Exception to obtain the request");
            e.printStackTrace();
        }
        LOGGER.info("Finish");
    }
}
