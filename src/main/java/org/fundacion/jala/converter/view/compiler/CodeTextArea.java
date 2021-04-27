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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.Color;
import java.awt.BorderLayout;

/**
 * This class customizes a panel with custom text areas.
 */
class CodeTextArea extends JPanel implements DocumentListener {
    private JTextArea codeArea;
    private JTextArea lineCode;
    private final int TOP_BORDER = 5;
    private final int LEFT_BORDER = 10;
    private final int BOTTOM_BORDER = 0;
    private final int RIGHT_BORDER = 10;

    protected CodeTextArea() {
        codeArea = new JTextArea();
        codeArea.setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        lineCode = new JTextArea("1");
        lineCode.setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        lineCode.setBackground(Color.darkGray);
        lineCode.setForeground(Color.white);
        JScrollPane textCodeArea = new JScrollPane();
        textCodeArea.setBorder(new EmptyBorder(0, 0, 0, 0));
        codeArea.getDocument().addDocumentListener(this);
        setLayout(new BorderLayout());
        textCodeArea.getViewport().add(codeArea);
        textCodeArea.setRowHeaderView(lineCode);
        add(textCodeArea, BorderLayout.CENTER);
    }

    /**
     * Gives users content of codeArea and textarea.
     *
     * @return a string on the codeArea.
     */
    public String getText() {
        return codeArea.getText();
    }

    /**
     *
     * @return
     */
    public JTextArea getCodeArea() {
        return codeArea;
    }

    /**
     * Counts how many lines has the codArea.
     *
     * @return a string that is the number of codArea lines.
     */
    public String getLinesOfText() {
        int caretPosition = codeArea.getDocument().getLength();
        Element root = codeArea.getDocument().getDefaultRootElement();
        String text = "1" + System.getProperty("line.separator");
        for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
            text += i + System.getProperty("line.separator");
        }
        return text;
    }

    /**
     * Adds the number of rows in Code Area Text.
     *
     * @param de event when inserting text in Code Area Text.
     */
    @Override
    public void changedUpdate(final DocumentEvent de) {
        lineCode.setText(getLinesOfText());
    }

    /**
     * Updates the number of rows in Code Area Text.
     *
     * @param de event when updating text in Code Area Text.
     */
    @Override
    public void insertUpdate(final DocumentEvent de) {
        lineCode.setText(getLinesOfText());
    }

    /**
     * Deletes the number of rows in Code Area Text.
     *
     * @param de event when deleting text in Code Area Text.
     */
    @Override
    public void removeUpdate(final DocumentEvent de) {
        lineCode.setText(getLinesOfText());
    }
}

