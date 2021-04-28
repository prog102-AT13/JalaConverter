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
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * This class is for the metadata exporting format UI.
 */
class ExportingFormat extends JPanel {
    private JComboBox convertTo;
    private JCheckBox checkMoreInfo;
    private final int DIMENSION_WIDTH = 30;
    private final int DIMENSION_HEIGHT = 30;
    private final int FONT_SIZE = 12;
    private final int COMBO_WIDTH = 100;
    private final int COMBO_HEIGHT = 30;
    
    protected ExportingFormat() {
        JLabelStyle formatTitle = new JLabelStyle("Exporting Format", "h4");
        JLabelStyle outputFormat = new JLabelStyle("Format Options", "h3");
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        convertTo.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        convertTo.setPreferredSize(new Dimension(COMBO_WIDTH, COMBO_HEIGHT));
        convertTo.addItem("txt");
        convertTo.addItem("html");
        convertTo.addItem("xmp");
        checkMoreInfo = new JCheckBox("More metadata information");
        checkMoreInfo.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        checkMoreInfo.setForeground(Color.DARK_GRAY);
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.add(formatTitle.getTextLabel());
        container.add(convertTo);
        container.add(checkMoreInfo);
        container.setAlignmentX(LEFT_ALIGNMENT);
        outputFormat.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(outputFormat.getTextLabel());
        add(container);
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
