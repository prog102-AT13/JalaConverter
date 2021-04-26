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

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class is for the select file option in metadata UI.
 */
class SelectFile extends JPanel implements ActionListener {
    private JButton selectFile;
    private JTextField textFile;
    private JFileChooser fileChooser;
    private String fileOriginPath;
    private final int FLOW_LAYOUT_HGAP = 30;
    private final int FLOW_LAYOUT_VGAP = 10;
    private final int DIMENSION_WIDTH = 350;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    protected SelectFile() {
        selectFile = new JButton("Open File");
        selectFile.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        selectFile.addActionListener(this);
        textFile = new JTextField();
        textFile.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        textFile.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        textFile.setEnabled(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, FLOW_LAYOUT_HGAP, FLOW_LAYOUT_VGAP));
        add(selectFile);
        add(textFile);
    }

    /**
     * Opens the File Chooser to select a file.
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            if ((fileName == null) || (fileName.getName().equals(""))) {
                fileOriginPath = "";
            } else {
                fileOriginPath = fileName.getAbsolutePath();
            }
            textFile.setText(fileOriginPath);
        }
    }

    /**
     * Gets the Origin Path of File when selected.
     *
     * @return a String with the fileOriginPath.
     */
    protected String getOriginFilePath() {
        return fileOriginPath;
    }
}
