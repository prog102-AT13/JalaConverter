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
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the compiler's UI.
 */
public class CompilerInterface extends JPanel {
    private final int MARGIN = 15;
    private static final Logger LOGGER = LogManager.getLogger();
    private Console consoleOutput;
    private CompilerMainButtons langButtons;
    private CompilerButtons buttonsCompiler;
    private String token;
    private ProjectTab projectTab;
    private ClientRequest clientRequest = new ClientRequest();
    private int choose;

    public CompilerInterface(final String newToken) {
        token = newToken;
        choose = 1;
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new CompilerMainButtons();
        langButtons.getJava().setEnabled(false);
        projectTab = new ProjectTab();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        add(langButtons);
        add(projectTab);
        add(buttonsCompiler);
        add(consoleOutput);
        buttonsCompiler.getRunButton().addActionListener(addListenerToRunButton());
        langButtons.getJava().addActionListener(addListenerToJavaButton());
        langButtons.getPython().addActionListener(addListenerToPythonButton());
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
            }
        };
        return actionListener;
    }
}
