/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.ComboStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * This class defines the interface for output settings for image to convert.
 */
public class OutputSettingsImage extends JPanel {
    private final int WIDTH_BOX = 5;
    private final int HEIGHT_BOX = 20;
    private final int SPACE_MARGIN = 30;
    private final int MARGIN_SPACE_LABEL = 28;
    private final int MARGIN_SPACE_TOP = 10;
    private ComboStyle widthSizeSelect;
    private JCheckBox grayScaleOption;
    private JPanel container;
    private final int FONT_SIZE = 12;
    private JLabelStyle sizeLabel;

    protected OutputSettingsImage() {
        sizeLabel = new JLabelStyle("Select width size: ", "h4");
        widthSizeSelect = new ComboStyle();
        setWidthSizeSelect();
        grayScaleOption = new JCheckBox("Gray scale");
        grayScaleOption.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        setElementsPanels();
        setLayout(new BorderLayout(SPACE_MARGIN, SPACE_MARGIN));
        setBorder(new EmptyBorder(MARGIN_SPACE_TOP, 0, HEIGHT_BOX, 0));
        add(container, BorderLayout.CENTER);
    }

    /**
     * Sets the elements in Panels.
     */
    public void setElementsPanels() {
        JPanel labelContainer = new JPanel();
        labelContainer.setLayout(new BoxLayout(labelContainer, BoxLayout.Y_AXIS));
        labelContainer.add(sizeLabel);
        labelContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, MARGIN_SPACE_LABEL)));
        JPanel comboContainer = new JPanel();
        comboContainer.setLayout(new BoxLayout(comboContainer, BoxLayout.Y_AXIS));
        comboContainer.add(widthSizeSelect);
        comboContainer.add(Box.createRigidArea(new Dimension(WIDTH_BOX, HEIGHT_BOX)));
        JPanel element3container = new JPanel();
        element3container.setLayout(new FlowLayout(FlowLayout.LEFT, HEIGHT_BOX, HEIGHT_BOX));
        element3container.add(grayScaleOption);
        container = new JPanel();
        container.setLayout(new BorderLayout(SPACE_MARGIN, 0));
        container.add(labelContainer, BorderLayout.LINE_START);
        container.add(comboContainer, BorderLayout.CENTER);
        container.add(element3container, BorderLayout.SOUTH);
    }

    /**
     * Sets all possible width size for Image converter.
     */
    protected void setWidthSizeSelect() {
        widthSizeSelect.addItem("854");
        widthSizeSelect.addItem("426");
        widthSizeSelect.addItem("720");
        widthSizeSelect.addItem("640");
        widthSizeSelect.addItem("320");
        widthSizeSelect.setSelectedIndex(1);
    }

    /**
     * Gets selected widthSize for Image converter.
     *
     * @return a String, option selected of widthSize.
     */
    protected String getWidthSize() {
        return widthSizeSelect.getSelectedItem().toString();
    }

    /**
     * Gets if grayScale is required for Image converter.
     *
     * @return a true if grayScale is required, false if not.
     */
    protected boolean isGrayScale() {
        return grayScaleOption.isSelected();
    }
}
