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
package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

/**
 * This class defines the interface for selecting the type of audio to convert.
 */
public class ConvertTypeSelectAudio extends JPanel {
    private JComboBox convertTo;
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 70;
    private final int heightLabelStyle = 30;
    private final int dimensionWidth = 100;
    private final int dimensionHeight = 30;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int flowLayoutHgap = 10;
    private final int flowLayoutVgap = 10;

    /**
     * Initializes the graphic elements for SelectCombobox for convert type.
     */
    protected ConvertTypeSelectAudio() {
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h3",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(dimensionWidth, dimensionHeight));
        convertTo.setFont(new Font("Barlow", fontStyle, fontSize));
        convertTo.addItem("mp3");
        convertTo.addItem("wav");
        convertTo.addItem("m4a");
        convertTo.addItem("flac");
        convertTo.addItem("ogg");
        setLayout(new FlowLayout(FlowLayout.LEFT, flowLayoutHgap, flowLayoutVgap));
        add(labelConvertTo.getTextLabel());
        add(convertTo);
    }

    /**
     * Returns the selected option to conversion.
     *
     * @return String with the selected option.
     */
    protected String getConvertTo() {
        return convertTo.getSelectedItem().toString();
    }
}
