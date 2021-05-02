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
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

/**
 * This class creates the compiler's UI.
 */
public class CompilerInterface extends JPanel {
    private static final Logger LOGGER = LogManager.getLogger();
    private Console consoleOutput;
    private CompilerMainButtons langButtons;
    private CompilerButtons buttonsCompiler;
    private String token;
    private ProjectTab projectTab;
    private ClientRequest clientRequest = new ClientRequest();
    private int choose;
    private String extension;
    public static String projectId;
    private int MARGIN = 5;

    public CompilerInterface(final String newToken) {
        token = newToken;
        choose = 1;
        extension = "java";
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new CompilerMainButtons(token);
        langButtons.getJava().setEnabled(false);
        projectTab = new ProjectTab(token);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        add(langButtons);
        add(projectTab);
        add(buttonsCompiler);
        add(consoleOutput);
        buttonsCompiler.getRunButton().addActionListener(addListenerToRunButton());
        buttonsCompiler.getSaveFiles().addActionListener(addListenerSaveButton());
        buttonsCompiler.getClearConsole().addActionListener(addListenerCleanButton());
        buttonsCompiler.getRunButton().setEnabled(false);
        langButtons.getJava().addActionListener(addListenerToJavaButton());
        langButtons.getPython().addActionListener(addListenerToPythonButton());
        langButtons.getProject().addActionListener(addListenerToCreateProjectButton());
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
                CompileRequestForm compileRequestForm = new CompileRequestForm(projectId);
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
                if (changeLanguage() == 0) {
                    langButtons.getJava().setEnabled(false);
                    langButtons.getPython().setEnabled(true);
                    choose = 1;
                    extension = "java";
                    createProject();
                    projectTab.setExtension(extension);
                }
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
                if (changeLanguage() == 0) {
                    langButtons.getPython().setEnabled(false);
                    langButtons.getJava().setEnabled(true);
                    choose = 2;
                    extension = "py";
                    createProject();
                }
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
                createProject();
                buttonsCompiler.getRunButton().setEnabled(false);
            }
        };
        return actionListener;
    }

    /**
     * Creates files and their content according tab names and their content.
     *
     * @return an action listener that executes the event.
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
                        buttonsCompiler.getRunButton().setEnabled(true);
                    } catch (Exception exception) {
                    }
                }
            }
        };
        return actionListener;
    }

    /**
     * Cleans content of selected tab.
     *
     * @return a action listener that actives the event.
     */
    public ActionListener addListenerCleanButton() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                projectTab.getSelectedPane().getCodeArea().setText("");
            }
        };
        return actionListener;
    }

    /**
     * Gets options to change or not language.
     *
     * @return a integer that represents the choice.
     */
    public int changeLanguage() {
        int selection = JOptionPane.showOptionDialog(null, "Are "
                        + "you sure you want to leave this project", "Changing language",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new Object[] {"Yes", "No"}, "Yes");
        return selection;
    }

    /**
     * Creates a new project.
     */
    public void createProject() {
        LOGGER.info("start");
        ProjectRequestForm projectRequestForm = new ProjectRequestForm();
        String projectTitle = (String) JOptionPane.showInputDialog(null,
                "Write project name", "Project Name",
                JOptionPane.PLAIN_MESSAGE, null, null, "project1");
            projectRequestForm.addProjectName(projectTitle);
            projectRequestForm.addUserId("1");
            try {
                LOGGER.info("Execute Try");
                String endpointResponse = clientRequest.executeRequest(projectRequestForm, token);
                projectId = endpointResponse;
                consoleOutput.getConsole().setText("Project " + projectTitle + " was created successfully");
                projectTab.start(extension, projectTitle);
                LOGGER.info("finish");
            } catch (Exception exception) {
                LOGGER.error("Execute Exception" + exception.getMessage());
            }
    }
}
