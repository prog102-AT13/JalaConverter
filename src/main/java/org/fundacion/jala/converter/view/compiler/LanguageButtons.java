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
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.Component;

class LanguageButtons extends JPanel {
    private JButton cPlusPlus;
    private JButton java;
    private JButton python;

    /**
     * Initialize the graphics elements for language buttons.
     */
    protected LanguageButtons() {
        ImageIcon javaIcon = new ImageIcon("src/Images/JavaIcon.png");
        ImageIcon pythonIcon = new ImageIcon("src/Images/PythonIcon.png");
        ImageIcon cIcon = new ImageIcon("src/Images/CIcon.png");
        setPreferredSize(new Dimension(75, 30));
        cPlusPlus = new JButton(cIcon);
        cPlusPlus.setMaximumSize(new Dimension(50, 50));
        cPlusPlus.setAlignmentX(Component.CENTER_ALIGNMENT);
        java = new JButton(javaIcon);
        java.setMaximumSize(new Dimension(50, 50));
        java.setAlignmentX(Component.CENTER_ALIGNMENT);
        python = new JButton(pythonIcon);
        python.setMaximumSize(new Dimension(50, 50));
        python.setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(cPlusPlus);
        add(java);
        add(python);
    }
}
