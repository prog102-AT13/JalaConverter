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
package org.fundacion.jala.converter.view.metadata;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.TxtField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;

/**
 * This class is for output information UI.
 */
class OutputInfo extends JPanel implements ItemListener {
    private final int DIMENSION_WIDTH = 250;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private TxtField outputNameField;
    private JCheckBox checkOutputName;
    private String outPutName;
    private JPanel container;
    private JLabelStyle outputNameData;

    protected OutputInfo() {
        outputNameData = new JLabelStyle("Output name of MetaData", "h3");
        outputNameField = new TxtField(DIMENSION_WIDTH, DIMENSION_HEIGHT, false);
        checkOutputName = new JCheckBox("Keep the name of output");
        checkOutputName.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        checkOutputName.setSelected(true);
        checkOutputName.addItemListener(this);
        setPanel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(outputNameData);
        add(container);
    }

    /**
     * Sets the position in Panel of elements.
     */
    public void setPanel() {
        container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.add(outputNameField);
        container.add(checkOutputName);
        outputNameData.setAlignmentX(LEFT_ALIGNMENT);
        container.setAlignmentX(LEFT_ALIGNMENT);
    }

    /**
     * Gets the name of the outputfile.
     *
     * @return a String with the outputname.
     */
    public String getOutPutName() {
        outPutName = outputNameField.getText();
        return outPutName;
    }

    /**
     * Gets if checkOutputName is required for metadata.
     *
     * @return true if is the same name, false if not.
     */
    protected boolean isSameName() {
        return checkOutputName.isSelected();
    }

    /**
     * Enables the JTextField to change the name of the output file for MetaData.
     *
     * @param e event of Check status.
     */
    @Override
    public void itemStateChanged(final ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            outputNameField.setEnabled(false);
            outputNameField.setText("");
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            outputNameField.setEnabled(true);
        }
    }
}
