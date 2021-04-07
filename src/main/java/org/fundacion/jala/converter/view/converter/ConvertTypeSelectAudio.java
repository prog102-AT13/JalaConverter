/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.*;
import java.awt.*;

public class ConvertTypeSelectAudio extends JPanel {
    private JComboBox convertTo;

    /**
     * Initialize the graphic elements for SelectComboox for convert type.
     */
    protected ConvertTypeSelectAudio() {
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h3", 2, 70, 30);
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(100, 30));
        convertTo.setFont(new Font("Barlow", 0, 12));
        convertTo.addItem("mp3");
        convertTo.addItem("wav");
        convertTo.addItem("m4a");
        convertTo.addItem("flac");
        convertTo.addItem("ogg");
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(labelConvertTo.getTextLabel());
        add(convertTo);
    }

    /**
     * Return the selected option to conversion.
     * @return String with the selected option.
     */
    protected String getConvertTo() {
        return convertTo.getSelectedItem().toString();
    }
}
