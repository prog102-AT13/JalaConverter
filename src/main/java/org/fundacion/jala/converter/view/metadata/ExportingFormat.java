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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class is for the metadata exporting format UI.
 */
class ExportingFormat extends JPanel {
    private JComboBox convertTo;
    private JCheckBox checkMoreInfo;
    private final int DIMENSION_WIDTH = 30;
    private final int DIMENSION_HEIGHT = 30;
    private final int ALIGN_LABEL_STYLE = 2;
    private final int WIDTH_LABEL_STYLE = 60;
    private final int HEIGHT_LABEL_STYLE = 0;
    private final int TOP_BORDER = 5;
    private final int LEFT_BORDER = 40;
    private final int BOTTOM_BORDER = 0;
    private final int RIGHT_BORDER = 0;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private final int GRID_LAYOUT_ROWS = 5;
    private final int GRID_LAYOUT_COLS = 1;
    
    protected ExportingFormat() {
        JLabelStyle formatTitle = new JLabelStyle("Exporting Format", "h2", ALIGN_LABEL_STYLE,
                WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        JLabelStyle outPutTitle = new JLabelStyle("Output Information", "h2", ALIGN_LABEL_STYLE,
                WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        convertTo.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        convertTo.addItem("txt");
        convertTo.addItem("html");
        convertTo.addItem("xmp");
        checkMoreInfo = new JCheckBox("More metadata information");
        checkMoreInfo.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        setLayout(new GridLayout(GRID_LAYOUT_ROWS, GRID_LAYOUT_COLS));
        setBorder(new EmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
        add(formatTitle.getTextLabel());
        add(convertTo);
        add(outPutTitle.getTextLabel());
        add(checkMoreInfo);
    }

    /**
     * Gets if checkOutputName is required for metadata.
     *
     * @return a boolean true if it is the same name, false if not.
     */
    protected boolean hasMoreInfo() {
        return checkMoreInfo.isSelected();
    }

    /**
     * Returns the selected option to conversion.
     *
     * @return a String with the selected option.
     */
    protected String getConvertTo() {
        return convertTo.getSelectedItem().toString();
    }
}
