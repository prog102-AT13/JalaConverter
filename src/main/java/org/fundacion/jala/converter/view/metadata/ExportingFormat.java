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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

class ExportingFormat extends JPanel {
    private JComboBox convertTo;
    private JCheckBox checkMoreInfo;
    private final int dimensionWidth = 30;
    private final int dimensionHeight = 30;
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 60;
    private final int heightLabelStyle = 0;
    private final int topBorder = 5;
    private final int leftBorder = 40;
    private final int bottomBorder = 0;
    private final int rightBorder = 0;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int gridLayoutRows = 5;
    private final int gridLayoutCols = 1;

    /**
     * Initializes the graphic components for Exporting format.
     * Output name of the file.
     */
    protected ExportingFormat() {
        JLabelStyle formatTitle = new JLabelStyle("Exporting Format", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle outPutTitle = new JLabelStyle("Output Information", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        convertTo.setFont(new Font("Barlow", fontStyle, fontSize));
        convertTo.addItem("txt");
        convertTo.addItem("html");
        convertTo.addItem("xmp");
        checkMoreInfo = new JCheckBox("More metadata information");
        checkMoreInfo.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new GridLayout(gridLayoutRows, gridLayoutCols));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(formatTitle.getTextLabel());
        add(convertTo);
        add(outPutTitle.getTextLabel());
        add(checkMoreInfo);
    }

    /**
     * Gets if checkOutputName is required for metadata.
     * @return true if is the same name, false if not.
     */
    protected boolean hasMoreInfo() {
        return checkMoreInfo.isSelected();
    }

    /**
     * Returns the selected option to conversion.
     * @return String with the selected option.
     */
    protected String getConvertTo() {
        return convertTo.getSelectedItem().toString();
    }
}
