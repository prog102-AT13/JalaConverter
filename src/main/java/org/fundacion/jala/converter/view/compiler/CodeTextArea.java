/**
 * CopyrightBorder (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

/**
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

class CodeTextArea extends JPanel {
    private JTextArea codeArea;
    private JTextArea lineCode;
    private final int topBorder = 5;
    private final int leftBorder = 10;
    private final int bottomBorder = 0;
    private final int rightBorder = 10;

    /**
     * Initializes the  graphic elements for Code Text Area.
     */
    protected CodeTextArea() {
        codeArea = new JTextArea();
        codeArea.setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        lineCode = new JTextArea("1");
        lineCode.setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        lineCode.setBackground(Color.darkGray);
        lineCode.setForeground(Color.white);
        JScrollPane textCodeArea = new JScrollPane();
        textCodeArea.setBorder(new EmptyBorder(0, 0, 0, 0));
        codeArea.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
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
             * @param de event when inserting text in Code Area Text.
             */
            @Override
            public void changedUpdate(final DocumentEvent de) {
                lineCode.setText(getText());
            }

            /**
             * Updates the number of rows in Code Area Text.
             * @param de event when updating text in Code Area Text.
             */
            @Override
            public void insertUpdate(final DocumentEvent de) {
                lineCode.setText(getText());
            }

            /**
             * Deletes the number of rows in Code Area Text.
             * @param de event when deleting text in Code Area Text.
             */
            @Override
            public void removeUpdate(final DocumentEvent de) {
                lineCode.setText(getText());
            }
        });

        setLayout(new BorderLayout());
        textCodeArea.getViewport().add(codeArea);
        textCodeArea.setRowHeaderView(lineCode);
        add(textCodeArea, BorderLayout.CENTER);
    }

    /**
     * Gives us content of text area
     * @return a String
     */
    public String getText() {
        return codeArea.getText();
    }
}
