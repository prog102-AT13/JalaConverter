/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.compiler;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

class CompilerButtons extends JPanel implements ActionListener {
    private JButton runCode;
    private JButton clearConsole;
    private JButton selectFile;
    String pathFile;

    /**
     * Initialize the graphic elements for Compiler buttons.
     * Run code, clean console, upload code.
     */
    protected CompilerButtons() {
        ImageIcon runIcon = new ImageIcon("src/Images/RunIcon-02.png");
        runCode = new JButton("Run");
        runCode.setIcon(new ImageIcon(runIcon.getImage().getScaledInstance(10, 10,  30)));
        runCode.setPreferredSize(new Dimension(80, 20));
        runCode.setFont(new Font("Barlow", 0, 11));
        clearConsole = new JButton("Clear");
        clearConsole.setPreferredSize(new Dimension(80, 20));
        clearConsole.setFont(new Font("Barlow", 0,  11));
        selectFile = new JButton("Open File");
        selectFile.setPreferredSize(new Dimension(80, 20));
        selectFile.setFont(new Font("Barlow", 0,  11));
        selectFile.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
        add(selectFile);
        add(runCode);
        add(clearConsole);
        runCode.addActionListener(this);
    }

    /**
     * Action of JButton to select a file.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        /*JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("TxT", "txt");
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                pathFile = "";
            } else {
                pathFile = fileName.getAbsolutePath();
            }
        }

         */
        System.out.println("Hola bebe");
    }

    public JButton getRunButton() {
        return  runCode;
    }
}
