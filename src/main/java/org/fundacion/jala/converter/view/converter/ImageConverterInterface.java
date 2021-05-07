/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.view.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.ChecksumException;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.Models.ImageRequestForm;
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
import static org.fundacion.jala.converter.core.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFormatAudioSupport;

/**
 * This class creates the image converter's UI.
 */
public class ImageConverterInterface extends JPanel implements ActionListener {
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
    private final int NUMBER_ZERO = 0;
    private SelectFile file;
    private ConvertTypeSelectImage imageSelect;
    private OutputSettingsImage settings;
    private ClientRequest clientRequest = new ClientRequest();
    private String token;
    private String checksumLocal;
    private JLabel label;

    public ImageConverterInterface(final String newToken) {
        this.token = newToken;
        JLabelStyle imageTitle = new JLabelStyle("Image converter", "h2");
        imageTitle.setAlignmentX(LEFT_ALIGNMENT);
        BtnStyle convertImage = new BtnStyle("Convert", BTN_TYPE);
        convertImage.setAlignmentX(LEFT_ALIGNMENT);
        convertImage.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        convertImage.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        imageSelect = new ConvertTypeSelectImage();
        imageSelect.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        settings = new OutputSettingsImage();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        ImageIcon icon = new ImageIcon("img/loading.gif");
        label = new JLabel();
        label.setIcon(new ImageIcon(icon.getImage()));
        label.setVisible(false);
        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertImage);
        JPanel container = new JPanel();
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(imageSelect);
        container.add(settings);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(imageTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        LOGGER.info("start");
        if (checkFileSelect(file.getOriginFilePath())) {
            if (checkFormatAudioSupport(file.getOriginFilePath(), dotenv.get("IMAGE_FORMAT_SUPPORT"))) {
                label.setVisible(true);
                try {
                    LOGGER.info("Execute Try");
                    checksumLocal = getFileChecksum(file.getOriginFilePath());
                    int option = JOptionPane.showConfirmDialog(this, "File Path: "
                            + file.getOriginFilePath() + "\nConvert to: " + imageSelect.getConvertTo() + "\nWidth size: "
                            + settings.getWidthSize() + "\nGray scale: " + settings.isGrayScale() + "\nChecksum: "
                            + checksumLocal, "Message confirm", JOptionPane.YES_NO_OPTION);
                    if (option == NUMBER_ZERO) {
                        callRequest();
                    } else {
                        label.setVisible(false);
                    }
                    LOGGER.info("finish");
                } catch (ChecksumException ioException) {
                    ioException.printStackTrace();
                    LOGGER.error("Execute Exception");
                }
            }
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the request.
     *
     * @throws IOException when problems on inputs.
     */
    private void callRequest() throws ChecksumException {
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            ImageRequestForm imageRequestForm = new ImageRequestForm();
            imageRequestForm.addFilepath(file.getOriginFilePath());
            imageRequestForm.addFormat(imageSelect.getConvertTo());
            imageRequestForm.addWidthSize(settings.getWidthSize());
            imageRequestForm.addChecksum(checksumLocal);
            imageRequestForm.addGrayScale(String.valueOf(settings.isGrayScale()));
            String result = clientRequest.executeRequest(imageRequestForm, token);
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
