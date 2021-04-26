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
package org.fundacion.jala.converter.view.metadata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.Models.MetaDataRequestForm;
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

/**
 * This class is for the metadata UI.
 */
public class MetaDataInterface extends JPanel implements ActionListener {
    private String token;
    private SelectFile file;
    private ExportingFormat exportingFormat;
    private OutputInfo outputName;
    private JButton convertMetaData;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int WAIT_TIME = 5000;
    private final int ALIGN_LABEL_STYLE = 0;
    private final int WIDTH_LABEL_STYLE = 70;
    private final int HEIGHT_LABEL_STYLE = 30;
    private final int TOP_BORDER = 20;
    private final int LEFT_BORDER = 0;
    private final int BOTTOM_BORDER = 100;
    private final int RIGHT_BORDER = 0;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    public MetaDataInterface(final String newToken) {
        token = newToken;
        JLabelStyle metaDataTitle = new JLabelStyle("Extract Metadata", "h1",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        file = new SelectFile();
        exportingFormat = new ExportingFormat();
        outputName = new OutputInfo();
        convertMetaData = new JButton("Extract");
        convertMetaData.setAlignmentX(RIGHT_ALIGNMENT);
        convertMetaData.addActionListener(this::actionPerformed);
        convertMetaData.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        add(metaDataTitle.getTextLabel());
        add(file);
        add(exportingFormat);
        add(outputName);
        add(convertMetaData);
    }

    /**
     * Converts, sends information for metadataCLASS conversion.
     * Shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        JOptionPane.showMessageDialog(this, "File Path: " + file.getOriginFilePath() +
                "\nConvert to: " + exportingFormat.getConvertTo() + "\nMore information: " +
                exportingFormat.hasMoreInfo() + "\nOutput name: " + outputName.getOutPutName());
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
     * Obtains the call request.
     *
     * @throws IOException if fails.
     */
    private void callRequest() throws IOException {
        LOGGER.info("start");
        MetaDataRequestForm metaDataRequestForm = new MetaDataRequestForm();
        metaDataRequestForm.addFilepath(file.getOriginFilePath());
        metaDataRequestForm.addMetaDataFormat(exportingFormat.getConvertTo());
        metaDataRequestForm.addMoreInfo(String.valueOf(exportingFormat.hasMoreInfo()));
        metaDataRequestForm.addSameName(String.valueOf(outputName.isSameName()));
        metaDataRequestForm.addOutputName(outputName.getOutPutName());
        try {
            LOGGER.info("Execute Try");
            String result = clientRequest.executeRequest(metaDataRequestForm, token);
            Thread.sleep(WAIT_TIME);
            clientRequest.downloadFile(result);
            JOptionPane.showMessageDialog(this, "Downloaded in :\n"
                    + System.getProperty("user.home") + dotenv.get("DIR_DOWNLOAD"));
            System.out.println(result);
        } catch (IOException | InterruptedException e) {
            LOGGER.error("Execute Exception to obtain the request");
            e.printStackTrace();
        }
        LOGGER.info("Finish");
    }
}
