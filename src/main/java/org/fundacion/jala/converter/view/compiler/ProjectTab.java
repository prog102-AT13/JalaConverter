/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.view.compiler;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * This class customizes a tabbed pane with custom tabs.
 */
public class ProjectTab extends JTabbedPane implements ActionListener {
    public static int COUNTER;
    private PlusButton button;

    /**
     * Starts required components to add new tabs.
     */
    public void start() {
        button = new PlusButton();
        button.setPreferredSize(new Dimension(20, 20));
        button.addActionListener(this);
        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, button);
        COUNTER = 0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent mouseEvent) {
                changeTitle(mouseEvent.getClickCount());
            }
        });
    }

    /**
     * Creates a new tab with X button included.
     *
     * @param event means click on "button".
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        COUNTER++;
        String title = "EndGame " + COUNTER;
        CodeTextArea codeArea = new CodeTextArea();
        codeArea.setName(title);
        add(codeArea, getTabCount() - 1);
        setTabComponentAt(getTabCount() - 2, makeTabTitle(title));
        setSelectedIndex(getTabCount() - 2);
    }

    /**
     * Deletes a selected tab.
     *
     * @param title of tab we want to delete.
     * @return a boolean that means if works or not.
     */
    public boolean removeTap(final String title) {
        int i = getTabCount();
        for (int index = 0; index < i; index++) {
            String temp = getTitleAt(index);
            if (temp.equals(title)) {
                removeTabAt(index);
                return true;
            }
        }
        return false;
    }

    /**
     * It represents what CodeTextArea is selected.
     *
     * @return a CodeTextArea of a selected tab.
     */
    public CodeTextArea getSelectedPane() {
        return (CodeTextArea) getSelectedComponent();
    }

    /**
     * Creates a title made up of a name and a close button.
     *
     * @param title is text that shows as a title.
     * @return a JPanel with complete title.
     */
    public JPanel makeTabTitle(final String title) {
        CloseButton tabButton = new CloseButton();
        tabButton.setPreferredSize(new Dimension(20, 20));
        tabButton.addActionListener(e1 -> {
            removeTap(title);
            setSelectedIndex(getTabCount() - 2);
        });
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.setOpaque(false);
        JLabel label = new JLabel(title);
        label.setFont(new Font("Barlow", 0, 11));
        pnl.add(label);
        pnl.add(tabButton);
        return pnl;
    }

    /**
     * Changes only name of title.
     *
     * @param numberOfClick represents how many clicks it receives.
     */
    public void changeTitle(final int numberOfClick) {
        if (numberOfClick == 2 && !"Main".equals(getTitleAt(getSelectedIndex()))) {
            String result = (String) JOptionPane.showInputDialog(null,
                    "Change TabName", "Change name",
                    JOptionPane.PLAIN_MESSAGE, null, null, "Red");
            if (result != null && result.length() > 0) {
                int indexTab = getSelectedIndex();
                setTitleAt(indexTab, result);
                setTabComponentAt(indexTab, makeTabTitle(result));
            }
        }
    }
}

