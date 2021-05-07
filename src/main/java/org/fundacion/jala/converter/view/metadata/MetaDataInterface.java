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
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.SelectFile;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkFileSelect;
import static org.fundacion.jala.converter.view.utilities.CheckFile.checkOutputNameMetadata;

/**
 * This class is for the metadata UI.
 */
public class MetaDataInterface extends JPanel implements ActionListener {
    private static final Logger LOGGER = LogManager.getLogger();
    private final int WAIT_TIME = 5000;
    private final int MARGIN_SPACE = 30;
    private final int MARGIN_BOTTOM_MAIN_CONTAINER = 200;
    private final int MARGIN_BOTTOM_BTN_CONTAINER = 100;
    private final int CONVERT_TYPE_BTN = 2;
    private String token;
    private SelectFile file;
    private ExportingFormat exportingFormat;
    private OutputInfo outputName;
    private ClientRequest clientRequest = new ClientRequest();
    private JPanel btnContainer;
    private JPanel container;
    private BtnStyle convertMetaData;

    public MetaDataInterface(final String newToken) {
        token = newToken;
        JLabelStyle metaDataTitle = new JLabelStyle("Extract Metadata", "h2");
        file = new SelectFile();
        exportingFormat = new ExportingFormat();
        outputName = new OutputInfo();
        convertMetaData = new BtnStyle("Extract", CONVERT_TYPE_BTN);
        convertMetaData.addActionListener(this::actionPerformed);
        setPanels();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN_SPACE, MARGIN_BOTTOM_MAIN_CONTAINER, MARGIN_SPACE));
        add(metaDataTitle, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        add(btnContainer, BorderLayout.SOUTH);
    }

    /**
     * Sets the position in Panel of elements.
     */
    public void setPanels() {
        btnContainer = new JPanel();
        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnContainer.add(convertMetaData);
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(file);
        container.add(exportingFormat);
        container.add(outputName);
        container.setBorder(new EmptyBorder(MARGIN_SPACE, 0, MARGIN_BOTTOM_BTN_CONTAINER, 0));
    }

    /**
     * Converts, sends information for metadataCLASS conversion and shows a Dialog with the information.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (checkFileSelect(file.getOriginFilePath())) {
            if (checkOutputNameMetadata(outputName.isSameName(), outputName.getOutPutName())) {
                int option = JOptionPane.showConfirmDialog(this, "File Path: "
                        + file.getOriginFilePath() + "\nConvert to: " + exportingFormat.getConvertTo()
                        + "\nMore information: " + exportingFormat.hasMoreInfo() + "\nOutput name: "
                        + outputName.getOutPutName(), "Message confirm", JOptionPane.YES_NO_OPTION);
                try {
                    LOGGER.info("Execute Try");
                    if (option == 0) {
                        callRequest();
                    }
                } catch (Exception ex) {
                    LOGGER.error("Execute Exception to metaData conversion");
                    ex.printStackTrace();
                }
            }
        }
        LOGGER.info("Finish");
    }

    /**
     * Obtains the call request.
     *
     * @throws IOException if the client request fails.
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
