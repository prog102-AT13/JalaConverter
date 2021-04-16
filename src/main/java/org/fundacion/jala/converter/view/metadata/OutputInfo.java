/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.metadata;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class OutputInfo extends JPanel implements ItemListener {
    private JTextField outputNameField;
    private JCheckBox checkOutputName;

    /**
     * Initializes the graphic components for how to output the file.
     * Output for Txt.
     * Output for HTML.
     * Output for XMP.
     */
    protected OutputInfo() {
        JLabelStyle outputNameData = new JLabelStyle("Output name of MetaData", "h3", 2, 150, 30);
        outputNameField = new JTextField();
        outputNameField.setPreferredSize(new Dimension(250, 30));
        outputNameField.setEnabled(false);
        checkOutputName = new JCheckBox("Keep the name of output");
        checkOutputName.setFont(new Font("Barlow", 0, 12));
        checkOutputName.setSelected(true);
        checkOutputName.addItemListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        setBorder(new EmptyBorder(10, 30, 10, 10));
        add(outputNameData.getTextLabel());
        add(outputNameField);
        add(checkOutputName);
    }

    /**
     * Action Method that enables the JTextField to change the
     * name of the output file for MetaData.
     * @param e event of Check status.
     */
    @Override
    public void itemStateChanged(final ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            outputNameField.setEnabled(false);
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            outputNameField.setEnabled(true);
        }
    }
}
