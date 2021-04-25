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
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 150;
    private final int heightLabelStyle = 30;
    private final int dimensionWidth = 250;
    private final int dimensionHeight = 30;
    private final int topBorder = 10;
    private final int leftBorder = 30;
    private final int bottomBorder = 10;
    private final int rightBorder = 10;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int flowLayoutHgap = 10;
    private final int flowLayoutVgap = 5;

    /**
     * Initializes the graphic components for how to output the file.
     * Output for Txt.
     * Output for HTML.
     * Output for XMP.
     */
    protected OutputInfo() {
        JLabelStyle outputNameData = new JLabelStyle("Output name of MetaData", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        outputNameField = new JTextField();
        outputNameField.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        outputNameField.setEnabled(false);
        checkOutputName = new JCheckBox("Keep the name of output");
        checkOutputName.setFont(new Font("Barlow", fontStyle, fontSize));
        checkOutputName.setSelected(true);
        checkOutputName.addItemListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT, flowLayoutHgap, flowLayoutVgap));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(outputNameData.getTextLabel());
        add(outputNameField);
        add(checkOutputName);
    }

    /**
     * Gets the name of the outputfile.
     *
     * @return outputname.
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
