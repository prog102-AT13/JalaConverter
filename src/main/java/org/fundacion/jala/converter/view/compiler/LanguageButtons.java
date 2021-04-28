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

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Component;

/**
 * This class customizes a panel with custom buttons to change language.
 */
class LanguageButtons extends JPanel {
    private JButton cPlusPlus;
    private JButton java;
    private JButton python;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 11;

    protected LanguageButtons() {
        cPlusPlus = createButton("C++");
        java = createButton("Java");
        python = createButton("Python");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(cPlusPlus);
        add(java);
        add(python);
    }

    /**
     * Button that defines if java is selected or not.
     *
     * @return a JButton to select a language.
     */
    public JButton getJava() {
        return java;
    }

    /**
     * Button that defines if python is selected or not.
     *
     * @return a JButton to select a language.
     */
    public JButton getPython() {
        return python;
    }

    /**
     * Creates a custom button.
     *
     * @param text represents title that the button has.
     * @return a JButton for the programming language.
     */
    public JButton createButton(final String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        return button;
    }
}

