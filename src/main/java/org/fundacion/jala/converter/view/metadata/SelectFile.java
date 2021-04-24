/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Ximena Aguilar Quiñonez
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
    private final int flowLayoutHgap = 30;
    private final int flowLayoutVgap = 10;
    private final int dimensionWidth = 350;
    private final int dimensionHeight = 30;
    private final int fontStyle = 0;
    private final int fontSize = 11;

    /**
     * Initializes the graphic components for Selecting file display.
     */
    protected SelectFile() {
        selectFile = new JButton("Open File");
        selectFile.setFont(new Font("Barlow", fontStyle, fontSize));
        selectFile.addActionListener(this);
        textFile = new JTextField();
        textFile.setFont(new Font("Barlow", fontStyle, fontSize));
        textFile.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        textFile.setEnabled(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, flowLayoutHgap, flowLayoutVgap));
        add(selectFile);
        add(textFile);
    }

    /**
     * Opens the File Chooser to select a file.
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
     * @return String fileOriginPath.
     */
    protected String getOriginFilePath() {
        return fileOriginPath;
    }
}
