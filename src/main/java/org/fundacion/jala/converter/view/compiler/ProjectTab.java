package org.fundacion.jala.converter.view.compiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectTab extends JTabbedPane implements ActionListener {
    public static int contador;
    public void start() {
        PlusButton button;
        button=new PlusButton();
        button.setPreferredSize(new Dimension(20,20));
        button.addActionListener(this);

        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, button);
        contador = 0;
    }
    CodeTextArea codeArea = new CodeTextArea();

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

    public CodeTextArea getSelectedPane() {
        return (CodeTextArea) getSelectedComponent();
    }

}

