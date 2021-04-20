/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

/**
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.view.compiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectTab extends JTabbedPane implements ActionListener {
    public static int contador;
    PlusButton button;
    public void start() {
        button=new PlusButton();
        button.setPreferredSize(new Dimension(20,20));
        button.addActionListener(this);

        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, button);
        contador = 0;
    }
    CodeTextArea codeArea = new CodeTextArea();

    /**
     * Creates a new tab with X button included
     * @param e means click on "button"
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        contador ++;
        CloseButton tabButton = new CloseButton();
        String title= "EndGame " + contador;
        CodeTextArea codeArea = new CodeTextArea();
        codeArea.setName(title);
        add(codeArea, getTabCount() - 1);
        tabButton.setPreferredSize(new Dimension(20,20));
        tabButton.addActionListener(e1 -> { removeTap(title);setSelectedIndex(getTabCount() - 2);});
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.setOpaque(false);
        JLabel label=new JLabel(title);
        label.setFont(new Font("Barlow", 0, 11));
        pnl.add(label);
        pnl.add(tabButton);
        setTabComponentAt(getTabCount() - 2, pnl);
        setSelectedIndex(getTabCount() - 2);
    }

    /**
     * Deletes a selected tab
     * @param title of tab we want to delete
     * @return a boolean that means if works or not
     */
    public boolean removeTap(String title) {
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
     * It represents what CodeTextArea is selected
     * @return a CodeTextArea
     */
    public CodeTextArea getSelectedPane() {
        return (CodeTextArea) getSelectedComponent();
    }

}

