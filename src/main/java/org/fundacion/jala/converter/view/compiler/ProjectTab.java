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

import org.fundacion.jala.converter.view.controllers.ClientRequest;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * This class customizes a tabbed pane with custom tabs.
 */
public class ProjectTab extends JTabbedPane implements ActionListener {
    public static int counter;
    private PlusButton button;
    private final int sizeFont = 11;
    private final int dimension = 20;
    private ArrayList<String> tabList;
    private ClientRequest clientRequest = new ClientRequest();
    private String token;
    private String extension;

    public ProjectTab(final String newToken) {
        token = newToken;
    }

    /**
     * Starts required components to add new tabs.
     */
    public void start(final String filetype) {
        extension = filetype;
        CodeTextArea codeArea = new CodeTextArea();
        codeArea.setName(InitialCode.getNameMain(extension));
        codeArea.getCodeArea().setText(InitialCode.generate(InitialCode.getNameMain(extension), extension));
        add(codeArea);
        setTabComponentAt(getTabCount() - 1, createTabHeaderWithTitle(InitialCode.getNameMain(extension)));
        tabList = new ArrayList<>();
        setFont(new Font("Barlow", 0, sizeFont));
        button = new PlusButton();
        button.setPreferredSize(new Dimension(dimension, dimension));
        button.addActionListener(this);
        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, button);
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
        String title = (String) JOptionPane.showInputDialog(null,
                "Write file name", "Create file",
                JOptionPane.PLAIN_MESSAGE, null, null, "file1");

        if (!title.isEmpty() && tabList.size() < 7) {
            if (!tabList.contains(title)) {
                tabList.add(title);
                CodeTextArea codeArea = new CodeTextArea();
                codeArea.setName(title);
                codeArea.getCodeArea().setText(InitialCode.generate(title, extension));
                add(codeArea, getTabCount() - 1);
                setTabComponentAt(getTabCount() - 2, createTabHeader(title));
                setSelectedIndex(getTabCount() - 2);
            }
        }
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
        CloseButton tabButton = new CloseButton();
        tabButton.setPreferredSize(new Dimension(dimension, dimension));
        tabButton.addActionListener(e1 -> {
            removeTab(title);
            setSelectedIndex(getTabCount() - 2);
            tabList.remove(tabList.indexOf(title));
        });
        JPanel tabHeader = createTabHeaderWithTitle(title);
        tabHeader.add(tabButton);
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
        headerLabel.setFont(new Font("Barlow", 0, sizeFont));
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

    /**
     * Gets us the plus button to access it.
     *
     * @return a plus button
     */
    public PlusButton getButton() {
        return button;
    }

    /**
     * Gets the list of all tab names.
     *
     * @return a array list of strings.
     */
    public ArrayList<String> getTabList() {
        return tabList;
    }

    /**
     * Sets type of extension.
     *
     * @param fileType represents new type of extension.
     */
    public void setExtension(final String fileType) {
        extension = fileType;
    }
}

