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

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class customizes a panel with custom buttons to compile.
 */
class CompilerButtons extends JPanel implements ActionListener {
    private JButton runCode;
    private JButton clearConsole;
    private final int DIMENSION_WIDTH = 80;
    private final int DIMENSION_HEIGHT = 20;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;
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
        button.setFont(new Font("Barlow", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(70, 20));
        //button.setHorizontalAlignment(SwingConstants.LEFT);
        //button.setHorizontalTextPosition(SwingConstants.RIGHT);

        button.setOpaque(true);
        button.setBackground(new Color(86,139,77));
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        button.setBorder(border);
        return button;
    }
}
