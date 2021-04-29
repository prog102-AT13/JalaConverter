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
package org.fundacion.jala.converter.view.compiler;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class customizes a panel with custom buttons to compile.
 */
class CompilerButtons extends JPanel implements ActionListener {
    private final int FONT_SIZE = 12;
    private final Color BTN_COLOR = new Color(86,139,77);
    private final int BTN_WIDTH = 70;
    private final int BTN_HEIGHT = 20;
    private JButton runCode;
    private JButton clearConsole;
    private final int HGAP = 10;
    private final int VGAP = 15;

    protected CompilerButtons() {
        runCode = makeButton("Run");
        Icon buttonIcon = new ImageIcon("img/compilerBtn/BtnRunCode.png");
        runCode.setIcon(buttonIcon);
        clearConsole = makeButton("Clear");
        setLayout(new FlowLayout(FlowLayout.RIGHT, HGAP, VGAP));
        add(runCode);
        add(clearConsole);
    }

    /**
     * Selects a file (Action of JButton).
     *
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
    }

    /**
     * Gets runCode to manipulate.
     *
     * @return a JButton to run the compiler.
     */
    public JButton getRunButton() {
        return runCode;
    }

    /**
     * Makes a custom button.
     *
     * @param text represents title that the button has.
     * @return a JButton to run the compiler.
     */
    public JButton makeButton(final String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        button.setPreferredSize(new Dimension(BTN_WIDTH, BTN_HEIGHT));
        button.setOpaque(true);
        button.setBackground(BTN_COLOR);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        button.setBorder(border);
        return button;
    }
}
