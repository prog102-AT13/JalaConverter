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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * This class customizes a tabbed pane with custom tabs.
 */
public class ProjectTab extends JTabbedPane implements ActionListener {
    public static int counter;
    private final int SIZE_FONT_11 = 11;
    private final int SIZE_FONT_12 = 12;

    public ProjectTab() {
        CodeTextArea codeArea = new CodeTextArea();
        codeArea.setName("Main");
        add(codeArea);
        setFont(new Font("Barlow", Font.PLAIN, SIZE_FONT_12));
        setOpaque(false);
        setBackground(Color.LIGHT_GRAY);
        setBorder(null);
        setTabComponentAt(getTabCount() - 1, createTabHeaderWithTitle("Main"));
        start();
    }

    /**
     * Starts required components to add new tabs.
     */
    public void start() {
        setFont(new Font("Barlow", 0, SIZE_FONT_11));
        ImageIcon addIcon = new ImageIcon("img/compilerBtn/BtnAddTab.png");
        JButton addBtn = new JButton(addIcon);
        addBtn.setOpaque(true);
        addBtn.setBackground(null);
        addBtn.setFocusPainted(false);
        Border border = new LineBorder(Color.WHITE, 0);
        addBtn.setBorder(border);
        addBtn.addActionListener(this);
        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, addBtn);
        counter = 0;
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
        counter++;
        String title = "EndGame " + counter;
        CodeTextArea codeArea = new CodeTextArea();
        codeArea.setName(title);
        add(codeArea, getTabCount() - 1);
        setTabComponentAt(getTabCount() - 2, createTabHeader(title));
        setSelectedIndex(getTabCount() - 2);
    }

    /**
     * Deletes a selected tab.
     *
     * @param title of tab we want to delete.
     * @return a boolean that means if works or not.
     */
    public boolean removeTab(final String title) {
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
     * Gets the selected tab CodeTextArea.
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
    public JPanel createTabHeader(final String title) {

        ImageIcon addIcon = new ImageIcon("img/compilerBtn/BtnCloseTab.png");
        JButton closeBtn = new JButton(addIcon);

        closeBtn.setOpaque(true);
        closeBtn.setBackground(Color.WHITE);
        closeBtn.setFocusPainted(false);
        Border border = new LineBorder(Color.WHITE, 0);
        closeBtn.setBorder(border);

        //CloseButton tabButton = new CloseButton();
        //tabButton.setPreferredSize(new Dimension(dimension, dimension));
        closeBtn.addActionListener(e1 -> {
            removeTab(title);
            setSelectedIndex(getTabCount() - 2);
        });
        JPanel tabHeader = createTabHeaderWithTitle(title);
        tabHeader.add(closeBtn);
        return tabHeader;
    }

    /**
     * Creates a header tab with only title.
     *
     * @param title represents title that the header has.
     * @return a JPanel with parcial title.
     */
    public JPanel createTabHeaderWithTitle(final String title) {
        JPanel headerTab = new JPanel();
        headerTab.setLayout(new FlowLayout());
        headerTab.setOpaque(false);
        JLabel headerLabel = new JLabel(title);
        headerLabel.setFont(new Font("Barlow", 0, SIZE_FONT_11));
        headerTab.add(headerLabel);
        return headerTab;
    }

    /**
     * Changes only name of title.
     *
     * @param numberOfClicks represents how many clicks it receives.
     */
    public void changeTitle(final int numberOfClicks) {
        if (numberOfClicks == 2 && !"Main".equals(getTitleAt(getSelectedIndex()))) {
            String result = (String) JOptionPane.showInputDialog(null,
                    "Change TabName", "Change name",
                    JOptionPane.PLAIN_MESSAGE, null, null, "Red");
            if (result != null && result.length() > 0) {
                int indexTab = getSelectedIndex();
                setTitleAt(indexTab, result);
                setTabComponentAt(indexTab, createTabHeader(result));
            }
        }
    }
}
