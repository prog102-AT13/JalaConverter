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

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

/**
 *  * This class customizes a panel with custom buttons to change language.
 */
class LanguageButtons extends JPanel {
    private JButton cPlusPlus;
    private JButton java;
    private JButton python;
    private final int MAXIMUM_SIZE_WIDTH = 50;
    private final int MAXIMUM_SIZE_HEIGHT = 50;
    private final int PREFERRED_SIZE_WIDTH = 70;
    private final int PREFERRED_SIZE_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    protected LanguageButtons() {
        setPreferredSize(new Dimension(PREFERRED_SIZE_WIDTH, PREFERRED_SIZE_HEIGHT));
        cPlusPlus = new JButton("C++");
        cPlusPlus.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        cPlusPlus.setMaximumSize(new Dimension(MAXIMUM_SIZE_WIDTH, MAXIMUM_SIZE_HEIGHT));
        cPlusPlus.setAlignmentX(Component.CENTER_ALIGNMENT);
        java = new JButton("Java");
        java.setMaximumSize(new Dimension(MAXIMUM_SIZE_WIDTH, MAXIMUM_SIZE_HEIGHT));
        java.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        java.setAlignmentX(Component.CENTER_ALIGNMENT);
        python = new JButton("Python");
        python.setMaximumSize(new Dimension(MAXIMUM_SIZE_WIDTH, MAXIMUM_SIZE_HEIGHT));
        python.setAlignmentX(Component.CENTER_ALIGNMENT);
        python.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(cPlusPlus);
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
}

