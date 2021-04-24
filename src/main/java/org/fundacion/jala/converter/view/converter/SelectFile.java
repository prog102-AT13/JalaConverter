/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Aguilar
 */
package org.fundacion.jala.converter.view.converter;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class defines the interface for select a file.
 */
class SelectFile extends JPanel implements ActionListener {
    private JButton fileButton;
    private String fileOriginPath;
    private JFileChooser fileChooser;
    private JTextField videoPath;
    private final int dimensionWidth = 350;
    private final int dimensionHeight = 30;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int flowLayoutHgap = 0;
    private final int flowLayoutVgap = 20;

    /**
     * Initializes the graphic components to select a file.
     */
    protected SelectFile() {
        fileButton = new JButton("Select a File");
        fileButton.addActionListener(this::actionPerformed);
        fileButton.setFont(new Font("Barlow", fontStyle, fontSize));
        videoPath = new JTextField();
        videoPath.setEnabled(false);
        videoPath.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        videoPath.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new FlowLayout(FlowLayout.LEFT, flowLayoutHgap, flowLayoutVgap));
        add(fileButton);
        add(videoPath);
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
            videoPath.setText(fileOriginPath);
        }
    }

    /**
     * Gets the Origin Path of File when selected.
     *
     * @return String fileOriginPath.
     */
    protected String getOriginFilePath() {
        return fileOriginPath;
    }
}
