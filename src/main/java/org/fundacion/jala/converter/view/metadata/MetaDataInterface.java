/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.metadata;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetaDataInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ExportingFormat exportInfo;
    private OutputInfo outputInfo;
    private JButton convertMetaData;
    private final int topBorder = 20;
    private final int leftBorder = 0;
    private final int bottomBorder = 100;
    private final int rightBorder = 0;
    private final int fontStyle = 0;
    private final int fontSize = 11;

    /**
     * Initialize the graphics components for MetaData interface.
     */
    public MetaDataInterface() {
        file = new SelectFile();
        exportInfo = new ExportingFormat();
        outputInfo = new OutputInfo();
        convertMetaData = new JButton("Convert");
        convertMetaData.setAlignmentX(CENTER_ALIGNMENT);
        convertMetaData.addActionListener(this::actionPerformed);
        convertMetaData.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(file);
        add(exportInfo);
        add(outputInfo);
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
                + "\nOutput name: "
                + "\nConvert to:\n" + exportInfo.txtChecked()
                + exportInfo.isHtmlChecked()
                + exportInfo.isXmpChecked());
    }
}
