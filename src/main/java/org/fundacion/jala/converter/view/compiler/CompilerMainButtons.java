/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Aguilar Quiñones
 */
package org.fundacion.jala.converter.view.compiler;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 *  * This class customizes a panel with custom buttons to change language.
 */
class CompilerMainButtons extends JPanel {
    private JButton java;
    private JButton python;
    private JButton newProject;
    private JButton uploadFile;
    private final int MAXIMUM_SIZE_WIDTH = 50;
    private final int MAXIMUM_SIZE_HEIGHT = 50;
    private final int PREFERRED_SIZE_WIDTH = 70;
    private final int PREFERRED_SIZE_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    protected CompilerMainButtons() {
        //setPreferredSize(new Dimension(PREFERRED_SIZE_WIDTH, PREFERRED_SIZE_HEIGHT));
        newProject = createButton("New Project", "BtnCompilerProject.png");
        uploadFile = createButton("Open File", "BtnCompilerProject.png");
        java = createButton("Java", "BtnCompilerJava.png");
        python = createButton("Python", "BtnCompilerPython.png");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(newProject);
        add(uploadFile);
        add(java);
        add(python);
    }

    /**
     * Button that defines or not java is selected
     *
     * @return a JButton
     */
    public JButton getJava() {
        return java;
    }

    /**
     * Button that defines or not python is selected
     *
     * @return a JButton
     */
    public JButton getPython() {
        return python;
    }

    /**
     * Creates a custom button.
     *
     * @param text represents title that the button has.
     * @return a JButton
     */
    public JButton createButton(final String text, String icon) {
        ImageIcon btnIcon = new ImageIcon("img/compilerBtn/" + icon);

        JButton button = new JButton(text);
        button.setIcon(btnIcon);
        button.setFont(new Font("Barlow", Font.PLAIN, 12));
        button.setPreferredSize(new Dimension(110, 25));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);

        button.setOpaque(true);
        button.setBackground(new Color(67, 116, 171));
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        button.setBorder(border);
        button.setMargin(new Insets(10,0,0,0));

        return button;
    }
}
