/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 */
package org.fundacion.jala.converter.view.text_extractor;

import org.fundacion.jala.converter.view.utilities.ComboStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.FlowLayout;

/**
 * This class shows the select language form.
 */
public class SelectLanguage extends JPanel {
    private ComboStyle convertTo;

    protected SelectLanguage() {
        JLabelStyle lblImageSettings = new JLabelStyle("Image settings", "h3");
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h4");

        convertTo = new ComboStyle();
        convertTo.addItem("eng");
        convertTo.addItem("spa");
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.add(labelConvertTo.getTextLabel());
        container.add(convertTo);
        lblImageSettings.setAlignmentX(LEFT_ALIGNMENT);
        container.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(lblImageSettings.getTextLabel());
        add(container);

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
