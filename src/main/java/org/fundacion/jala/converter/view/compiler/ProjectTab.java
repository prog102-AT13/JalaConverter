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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * This class customizes a tabbed pane with custom tabs.
 */
public class ProjectTab extends JTabbedPane implements ActionListener {
    private ArrayList<String> tabList;
    private ArrayList<CodeTextArea> codeTextAreas;
    private ClientRequest clientRequest = new ClientRequest();
    private String token;
    private String extension;
    private final int SIZE_FONT_11 = 11;
    private final int AMOUNT_TABS = 8;
    private JButton addBtn;
    private String projectName;

    public ProjectTab(final String newToken) {
        token = newToken;
        tabList = new ArrayList<>();
        codeTextAreas = new ArrayList<>();
        projectName = "projectexample";
        addInitialProjectTab("Initial", "Create a Project");
    }

    /**
     * Starts required components to add new tabs.
     */
    public void start(final String filetype, final String projectN) {
        extension = filetype;
        projectName = projectN;
        if (this != null && getTabList() != null) {
            cleanProjectTab();
        }
        addInitialProjectTab(InitialCode.getNameMain(extension),
                InitialCode.generate(InitialCode.getNameMain(extension), extension));
        setFont(new Font("Barlow", 0, SIZE_FONT_11));
        ImageIcon addIcon = new ImageIcon("img/compilerBtn/BtnAddTab.png");
        addBtn = new JButton(addIcon);
        addBtn.setOpaque(true);
        addBtn.setBackground(null);
        addBtn.setFocusPainted(false);
        Border border = new LineBorder(Color.WHITE, 0);
        addBtn.setBorder(border);
        addBtn.addActionListener(this);
        add(new JPanel());
        setTabComponentAt(getTabCount() - 1, addBtn);
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
        String title = (String) JOptionPane.showInputDialog(null,
                "Write file name", "Create file",
                JOptionPane.PLAIN_MESSAGE, null, null, "file1");
        if (!title.isEmpty() && tabList.size() < AMOUNT_TABS - 1) {
            if (!tabList.contains(title)) {
                addProjectTab(title, InitialCode.generate(title, extension));
                updateCodeTextAreas(title);
//                codeTextAreas.get(0).createChild(title);
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
                codeTextAreas.remove(index);
                deleteCodeTextAreas(index);
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
        closeBtn.addActionListener(eventMouse -> {
            removeTab(title);
            setSelectedIndex(getTabCount() - 2);
            tabList.remove(tabList.indexOf(title));
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

    /**
     * Gets the add tab button.
     *
     * @return addBtn JButton that add a tab.
     */
    public JButton getButton() {
        return addBtn;
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

    /**
     * Cleans all tabs and names in tabList.
     */
    public void cleanProjectTab() {
        removeAll();
        tabList.clear();
        codeTextAreas.clear();
    }

    /**
     * Adds a initial tab to tabbed pane.
     *
     * @param title represents title of tab that is added.
     * @param initialCode represents initial code that tab has.
     */
    public void addInitialProjectTab(final String title, final String initialCode) {
        createProjectTab(title, initialCode);
        add(codeTextAreas.get(codeTextAreas.size() - 1));
        setTabComponentAt(getTabCount() - 1, createTabHeaderWithTitle(title));
    }

    /**
     * Adds a new tab to tabbed pane.
     *
     * @param title represents title of tab that is added.
     * @param initialCode represents initial code that tab has.
     */
    public void addProjectTab(final String title, final String initialCode) {
        createProjectTab(title, initialCode);
        add(codeTextAreas.get(codeTextAreas.size() - 1), getTabCount() - 1);
        setTabComponentAt(getTabCount() - 2, createTabHeader(title));
        setSelectedIndex(getTabCount() - 2);
    }

    /**
     * Creates a new codeTexArea.
     *
     * @param title represents title of codeTexArea.
     * @param initialCode represents initial code of codeTexArea.
     */
    public void createProjectTab(final String title, final String initialCode) {
        tabList.add(title);
        CodeTextArea codeArea = new CodeTextArea(projectName, tabList);
        codeArea.setName(title);
        codeArea.getCodeArea().setText(initialCode);
        codeTextAreas.add(codeArea);
    }

    /**
     * Updates file tree of all tabs.
     */
    public void updateCodeTextAreas(final String fileName) {
        for (int i = 0; i < codeTextAreas.size() - 1; i++) {
            codeTextAreas.get(i).createChild(fileName);
        }
    }

    /**
     * Deletes a file form all tree tabs.
     */
    public void deleteCodeTextAreas(final int index) {
        for (int i = 0; i < codeTextAreas.size(); i++) {
            codeTextAreas.get(i).removeChild(index);
        }
    }
}

