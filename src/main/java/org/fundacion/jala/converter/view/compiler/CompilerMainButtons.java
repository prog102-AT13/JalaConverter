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

import org.fundacion.jala.converter.view.utilities.BtnStyle;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

/**
 * This class customizes a panel with custom buttons to change language.
 */
class CompilerMainButtons extends JPanel {
    private String newToken;
    private BtnStyle java;
    private BtnStyle python;
    private BtnStyle project;
    private final int BTN_TYPE_COMPILER = 2;

    protected CompilerMainButtons(final String token) {
        newToken = token;
        project = new BtnStyle("New Project", "BtnCompilerProject.png", BTN_TYPE_COMPILER);
        java = new BtnStyle("Java", "BtnCompilerJava.png", BTN_TYPE_COMPILER);
        python = new BtnStyle("Python", "BtnCompilerPython.png", BTN_TYPE_COMPILER);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(project);
        add(java);
        add(python);
    }

    /**
     * Defines Button depending if Java is selected or not.
     *
     * @return java JButton selected.
     */
    public JButton getJava() {
        return java;
    }

    /**
     * Defines Button depending if Python is selected or not.
     *
     * @return python JButton selected.
     */
    public JButton getPython() {
        return python;
    }
}
