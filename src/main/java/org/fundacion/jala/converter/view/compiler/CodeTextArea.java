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
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.ArrayList;

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
    private final int RIGHT_BORDER_SPACE = 20;
    private final int CODE_AREA_WIDTH = 18;
    private final int CODE_AREA_HEIGHT = 30;
    private final int FONT_SIZE = 12;
    private final Color LINE_COLOR = new Color(28, 28, 28);
    final String[] toppings = {"Project1", "Main.java", "subclass.java"};
    private JTree treeOne;
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private String[] options;

    protected CodeTextArea(final String projectName, final ArrayList<String> fileNames) {
        codeArea = new JTextArea(CODE_AREA_WIDTH, CODE_AREA_HEIGHT);
        codeArea.setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        codeArea.setFont(new Font("Courier New", Font.PLAIN, FONT_SIZE));
        lineCode = new JTextArea("1");
        lineCode.setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        lineCode.setBackground(LINE_COLOR);
        lineCode.setForeground(Color.white);
        JScrollPane textCodeArea = new JScrollPane();
        textCodeArea.setBorder(new EmptyBorder(0, 0, 0, 0));
        codeArea.getDocument().addDocumentListener(this);
        setLayout(new BorderLayout());
        createFileTree(projectName, fileNames);
        treeOne.setBorder(new EmptyBorder(RIGHT_BORDER, TOP_BORDER, RIGHT_BORDER, RIGHT_BORDER_SPACE));
        textCodeArea.getViewport().add(codeArea);
        textCodeArea.setRowHeaderView(lineCode);
        add(treeOne, BorderLayout.LINE_START);
        add(textCodeArea, BorderLayout.CENTER);
    }

    /**
     * Gets content of codeArea and textarea.
     *
     * @return codeArea the String content in Code Area.
     */
    public String getText() {
        return codeArea.getText();
    }

    /**
     * Gets text area to have access to its content.
     *
     * @return codeArea the element JTextarea.
     */
    public JTextArea getCodeArea() {
        return codeArea;
    }

    /**
     * Counts how many lines has the codArea.
     *
     * @return text string that is the number of codArea lines.
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

    /**
     * Creates the JtreePanel.
     *
     * @param vals String of values to set in JtreePanel.
     */
    public void JTreePanelOne(final String vals[]) {
        options = vals;
        treeOne = new JTree(options);
    }

    /**
     * Creates a file tree with a project name and a list with file names.
     *
     * @param projectName represents project name.
     * @param fileNames represents a list with file names.
     */
    public void createFileTree(final String projectName, final ArrayList<String> fileNames) {
        root = null;
        treeModel = null;
        treeOne = null;
        root = new DefaultMutableTreeNode(projectName);
        treeModel = new DefaultTreeModel(root);
        treeOne = new JTree(treeModel);
        for (String fileName : fileNames) {
            root.add(new DefaultMutableTreeNode(fileName));
        }
        treeOne.setShowsRootHandles(true);
    }

    /**
     * Adds a child path that represents new file of project.
     */
    public void createChild(final String nameFile) {
        root.add(new DefaultMutableTreeNode(nameFile));
    }
}
