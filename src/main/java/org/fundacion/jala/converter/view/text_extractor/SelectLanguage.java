/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

package org.fundacion.jala.converter.view.text_extractor;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SelectLanguage extends JPanel {
    private JComboBox convertTo;

    /**
     * Initializes graphic elements for SelectComboox for convert type.
     */
    protected SelectLanguage() {
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h3", 2, 70, 30);
        convertTo = new JComboBox();
        convertTo.setPreferredSize(new Dimension(100, 30));
        convertTo.setFont(new Font("Barlow", 0, 12));
        convertTo.addItem("eng");
        convertTo.addItem("spa");
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(labelConvertTo.getTextLabel());
        add(convertTo);
    }

    /**
     * Returns the selected option to conversion.
     * @return String with the selected option.
     */
    protected String getConvertTo() {
        return convertTo.getSelectedItem().toString();
    }
}
