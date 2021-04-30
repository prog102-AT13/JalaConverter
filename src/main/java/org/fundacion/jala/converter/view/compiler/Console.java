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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;

/**
 * This class customizes a panel as a console.
 */
class Console extends JPanel {
    private final int MARGIN = 10;
    private final int FONT_SIZE = 12;
    private JTextArea console;

    protected Console() {
        console = new JTextArea();
        console.setBackground(Color.black);
        console.setForeground(Color.white);
        console.setEditable(true);
        console.setBorder(new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        console.setFont(new Font("Courier New", Font.PLAIN, FONT_SIZE));
        Border border = new LineBorder(Color.WHITE, 0);
        JScrollPane scrollPane = new JScrollPane(console);
        scrollPane.setBorder(border);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, MARGIN, 0, MARGIN));
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Gets access to JTextArea.
     *
     * @return a JTextArea for the console.
     */
    public JTextArea getConsole() {
        return console;
    }
}
