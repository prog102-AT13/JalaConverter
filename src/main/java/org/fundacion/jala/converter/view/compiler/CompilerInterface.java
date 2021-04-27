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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.Models.CompileRequestForm;
import org.fundacion.jala.converter.view.Models.FileRequestForm;
import org.fundacion.jala.converter.view.Models.ProjectRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the compiler's UI.
 */
public class CompilerInterface extends JPanel {
    private static final Logger LOGGER = LogManager.getLogger();
    private Console consoleOutput;
    private LanguageButtons langButtons;
    private CompilerButtons buttonsCompiler;
    private String token;
    private ProjectTab projectTab;
    private ClientRequest clientRequest = new ClientRequest();
    private int choose;
    private String extension;
    public static String projectId;

    public CompilerInterface(final String newToken) {
        token = newToken;
        choose = 1;
        extension = "java";
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new LanguageButtons();
        langButtons.getJava().setEnabled(false);
        projectTab = new ProjectTab(token);
        setLayout(new GridBagLayout());
        GridBagConstraints panelConstraint = new GridBagConstraints();
        panelConstraint.weighty = 1;
        panelConstraint.fill = GridBagConstraints.BOTH;
        add(langButtons, setConstraints(panelConstraint, 0, 1, 3, 1));
        add(projectTab, setConstraints(panelConstraint, 1, 1, 2, 4));
        panelConstraint.weighty = 0;
        add(buttonsCompiler, setConstraints(panelConstraint, 3, 7, 1, 2));
        add(consoleOutput, setConstraints(panelConstraint, 1, 8, 2, 4));
        buttonsCompiler.getRunButton().addActionListener(addListenerToRunButton());
        buttonsCompiler.getSelectFile().addActionListener(addListenerSaveButton());
        langButtons.getJava().addActionListener(addListenerToJavaButton());
        langButtons.getPython().addActionListener(addListenerToPythonButton());
        JButton project = new JButton("Create Project");
        add(project, setConstraints(panelConstraint, 0, 7, 1, 1));
        project.addActionListener(addListenerToCreateProjectButton());
    }

    /**
     * Sets all grids to a GridBagConstraints.
     *
     * @param panelConstraint is the GridBagConstraints that sets.
     * @param gx represents x grid.
     * @param gy represents y grid.
     * @param gh represents height grid.
     * @param gw represents width grid.
     * @return a GridBagConstraints for the compiler.
     */
    public GridBagConstraints setConstraints(final GridBagConstraints panelConstraint, final int gx, final int gy,
                                             final int gh, final int gw) {
        panelConstraint.gridx = gx;
        panelConstraint.gridy = gy;
        panelConstraint.gridheight = gh;
        panelConstraint.gridwidth = gw;
        return panelConstraint;
    }

    /**
     * Processes code and receives its result.
     *
     * @return a custom ActionListener.
     */
    public ActionListener addListenerToRunButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                LOGGER.info("start");
                String inputCode = projectTab.getSelectedPane().getText();
                CompileRequestForm compileRequestForm = new CompileRequestForm(choose);
                compileRequestForm.addCode(inputCode);
                try {
                    LOGGER.info("Execute Try");
                    String sResponse = clientRequest.executeRequest(compileRequestForm, token);
                    consoleOutput.getConsole().setText(sResponse);
                    LOGGER.info("finish");
                } catch (Exception exception) {
                    LOGGER.error("Execute Exception" + exception.getMessage());
                }
            }
        };
        return actionListener;
    }

    /**
     * Sets enabled to java button and disabled to python button.
     *
     * @return a custom ActionListener.
     */
    public ActionListener addListenerToJavaButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                langButtons.getJava().setEnabled(false);
                langButtons.getPython().setEnabled(true);
                choose = 1;
                extension = "java";
                projectTab.setExtension(extension);
            }
        };
        return actionListener;
    }

    /**
     * Sets enabled to python button and disabled to java button.
     *
     * @return a custom ActionListener.
     */
    public ActionListener addListenerToPythonButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                langButtons.getPython().setEnabled(false);
                langButtons.getJava().setEnabled(true);
                choose = 2;
                extension = "py";
                projectTab.setExtension(extension);
            }
        };
        return actionListener;
    }

    /**
     * Processes code and receives its result.
     *
     * @return a custom ActionListener.
     */
    public ActionListener addListenerToCreateProjectButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                LOGGER.info("start");
                ProjectRequestForm projectRequestForm = new ProjectRequestForm();
                String result = (String) JOptionPane.showInputDialog(null,
                        "Write project name", "Project Name",
                        JOptionPane.PLAIN_MESSAGE, null, null, "project 1");
                projectRequestForm.addProjectName(result);
                projectRequestForm.addUserId("1");
                try {
                    LOGGER.info("Execute Try");
                    String sResponse = clientRequest.executeRequest(projectRequestForm, token);
                    projectId = sResponse;
                    consoleOutput.getConsole().setText(sResponse + " " + result);
                    projectTab.start(extension);
                    LOGGER.info("finish");
                } catch (Exception exception) {
                    LOGGER.error("Execute Exception" + exception.getMessage());
                }
            }
        };
        return actionListener;
    }

    /**
     *
     * @return
     */
    public ActionListener addListenerSaveButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (int i = 0; i < projectTab.getTabCount() - 1; i++) {
                    CodeTextArea codeTextArea = (CodeTextArea) projectTab.getComponentAt(i);
                    String title = codeTextArea.getName();
                    String code = codeTextArea.getText();
                    FileRequestForm fileRequestForm = new FileRequestForm();
                    fileRequestForm.addFileTitle(title);
                    fileRequestForm.setUrl(CompilerInterface.projectId);
                    fileRequestForm.addFileExtension(extension);
                    fileRequestForm.addCode(code);
                    try {
                        clientRequest.executeRequest(fileRequestForm, token);
                    } catch (Exception exception) {
                    }
                }
            }
        };
        return actionListener;
    }
}

