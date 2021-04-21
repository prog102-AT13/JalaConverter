/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala.
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

public class MetaDataInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ExportingFormat exportingFormat;
    private OutputInfo outputName;
    private JButton convertMetaData;
    private ClientRequest clientRequest = new ClientRequest();
    private static final Logger LOGGER = LogManager.getLogger();
    private final int waitTime = 5000;
    private final int alignLabelStyle = 0;
    private final int widthLabelStyle = 70;
    private final int heightLabelStyle = 30;
    private final int topBorder = 20;
    private final int leftBorder = 0;
    private final int bottomBorder = 100;
    private final int rightBorder = 0;
    private final int fontStyle = 0;
    private final int fontSize = 11;

    /**
     * Initializes the graphics components for MetaData interface.
     */
    public MetaDataInterface() {
        JLabelStyle metaDataTitle = new JLabelStyle("Extract Metadata", "h1",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        file = new SelectFile();
        exportingFormat = new ExportingFormat();
        outputName = new OutputInfo();
        convertMetaData = new JButton("Extract");
        convertMetaData.setAlignmentX(RIGHT_ALIGNMENT);
        convertMetaData.addActionListener(this::actionPerformed);
        convertMetaData.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(metaDataTitle.getTextLabel());
        add(file);
        add(exportingFormat);
        add(outputName);
        add(convertMetaData);
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
                + exportingFormat.getConvertTo()
                + "\nMore information: "
                + exportingFormat.hasMoreInfo()
                + "\nOutput name: "
                + outputName.getOutPutName());
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
        MetaDataRequestForm metaDataRequestForm = new MetaDataRequestForm();
        metaDataRequestForm.addFilepath(file.getOriginFilePath());
        metaDataRequestForm.addMetaDataFormat(exportingFormat.getConvertTo());
        metaDataRequestForm.addMoreInfo(String.valueOf(exportingFormat.hasMoreInfo()));
        metaDataRequestForm.addSameName(String.valueOf(outputName.isSameName()));
        metaDataRequestForm.addOutputName(outputName.getOutPutName());
        try {
            LOGGER.info("Execute Try");
            String result = clientRequest.executeRequest(metaDataRequestForm);
            Thread.sleep(waitTime);
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
