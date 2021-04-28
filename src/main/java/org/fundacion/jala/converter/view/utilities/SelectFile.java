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
package org.fundacion.jala.converter.view.utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class is for the select file option.
 */
public class SelectFile extends JPanel implements ActionListener {
    private BtnStyle fileButton;
    private JTextField textFile;
    private JFileChooser fileChooser;
    private String fileOriginPath;
    private final int DIMENSION_WIDTH = 400;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    public SelectFile() {
        JLabelStyle lblFile = new JLabelStyle("Select a File to convert: ", "h3");
        fileButton = new BtnStyle("Select a File", 1);
        fileButton.addActionListener(this::actionPerformed);
        textFile = new JTextField();
        textFile.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        textFile.setEnabled(false);
        textFile.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        JPanel containerFile = new JPanel();
        containerFile.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerFile.add(fileButton);
        containerFile.add(textFile);
        lblFile.setAlignmentX(LEFT_ALIGNMENT);
        containerFile.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(lblFile.getTextLabel());
        add(containerFile);
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
    public String getOriginFilePath() {
        return fileOriginPath;
    }
}
