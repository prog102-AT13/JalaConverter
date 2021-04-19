/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.compiler;

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
    private String pathFile;
    private final int width = 10;
    private final int height = 10;
    private final int hints = 30;
    private final int dimensionWidth = 80;
    private final int dimensionHeight = 20;
    private final int fontStyle = 0;
    private final int fontSize = 11;
    private final int hgap = 15;
    private final int vgap = 15;

    /**
     * Initializes the graphic elements for Compiler buttons.
     * Runs code, cleans console, uploads code.
     */
    protected CompilerButtons() {
        ImageIcon runIcon = new ImageIcon("src/Images/RunIcon-02.png");
        runCode = new JButton("Run");
        runCode.setIcon(new ImageIcon(runIcon.getImage().getScaledInstance(width, height, hints)));
        runCode.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        runCode.setFont(new Font("Barlow", fontStyle, fontSize));
        clearConsole = new JButton("Clear");
        clearConsole.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        clearConsole.setFont(new Font("Barlow", fontStyle, fontSize));
        selectFile = new JButton("Open File");
        selectFile.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        selectFile.setFont(new Font("Barlow", fontStyle, fontSize));
        selectFile.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.RIGHT, hgap, vgap));
        add(selectFile);
        add(runCode);
        add(clearConsole);
        runCode.addActionListener(this);
    }

    /**
     * Selects a file (Action of JButton).
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        
        System.out.println("Hola bebe");
    }

    public JButton getRunButton() {
        return  runCode;
    }
}
