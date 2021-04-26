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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is for output information UI.
 */
class OutputInfo extends JPanel implements ItemListener {
    private JTextField outputNameField;
    private JCheckBox checkOutputName;
    private String outPutName;
    private final int ALIGN_LABEL_STYLE = 2;
    private final int WIDTH_LABEL_STYLE = 150;
    private final int HEIGHT_LABEL_STYLE = 30;
    private final int DIMENSION_WIDTH = 250;
    private final int DIMENSION_HEIGHT = 30;
    private final int TOP_BORDER = 10;
    private final int LEFT_BORDER = 30;
    private final int BOTTOM_BORDER = 10;
    private final int RIGHT_BORDER = 10;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private final int FLOW_LAYOUT_HGAP = 10;
    private final int FLOW_LAYOUT_VGAP = 5;

    protected OutputInfo() {
        JLabelStyle outputNameData = new JLabelStyle("Output name of MetaData", "h3",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        outputNameField = new JTextField();
        outputNameField.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        outputNameField.setEnabled(false);
        checkOutputName = new JCheckBox("Keep the name of output");
        checkOutputName.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        checkOutputName.setSelected(true);
        checkOutputName.addItemListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT, FLOW_LAYOUT_HGAP, FLOW_LAYOUT_VGAP));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        add(outputNameData.getTextLabel());
        add(outputNameField);
        add(checkOutputName);
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
