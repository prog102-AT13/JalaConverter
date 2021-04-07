/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.compiler;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class CompilerInterface extends JPanel {
    private CodeTextArea codeArea;
    private Console consoleOutput;
    private LanguageButtons langButtons;
    private CompilerButtons buttonsCompiler;

    /**
     * Initilize the graphics elements of the Main Compiler Interface.
     */
    public CompilerInterface() {
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new LanguageButtons();
        codeArea = new CodeTextArea();

        setLayout(new GridBagLayout());
        GridBagConstraints panelConstraint = new GridBagConstraints();

        panelConstraint.gridx = 0;
        panelConstraint.gridy = 1;
        panelConstraint.gridheight = 3;
        panelConstraint.gridwidth = 1;
        panelConstraint.weighty = 1;
        panelConstraint.fill = GridBagConstraints.BOTH;
        add(langButtons, panelConstraint);

        panelConstraint.gridx = 1;
        panelConstraint.gridy = 1;
        panelConstraint.gridheight = 2;
        panelConstraint.gridwidth = 4;
        add(codeArea, panelConstraint);

        panelConstraint.gridx = 3;
        panelConstraint.gridy = 7;
        panelConstraint.gridheight = 1;
        panelConstraint.gridwidth = 2;
        panelConstraint.weighty = 0;
        add(buttonsCompiler, panelConstraint);

        panelConstraint.gridx = 1;
        panelConstraint.gridy = 8;
        panelConstraint.gridheight = 2;
        panelConstraint.gridwidth = 4;
        add(consoleOutput, panelConstraint);
    }
}
