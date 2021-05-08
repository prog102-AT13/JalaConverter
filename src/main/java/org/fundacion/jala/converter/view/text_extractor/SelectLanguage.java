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
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

/**
 * This class shows the select language form.
 */
public class SelectLanguage extends JPanel {
    private final int WIDTH_COMBO_LANG = 90;
    private final int HEIGHT_COMBO_LANG = 20;
    private final int FLOWLAYOUT_SPACE = 10;
    private ComboStyle langCombo;

    protected SelectLanguage() {
        JLabelStyle lblImageSettings = new JLabelStyle("Image settings", "h3");
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h4");
        langCombo = new ComboStyle(WIDTH_COMBO_LANG, HEIGHT_COMBO_LANG);
        langCombo.addItem("eng");
        langCombo.addItem("spa");
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, FLOWLAYOUT_SPACE, FLOWLAYOUT_SPACE));
        container.add(labelConvertTo);
        container.add(langCombo);
        lblImageSettings.setAlignmentX(LEFT_ALIGNMENT);
        container.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(lblImageSettings);
        add(container);
    }

    /**
     * Returns the selected option to conversion.
     *
     * @return a String with the selected option.
     */
    protected String getConvertTo() {
        return langCombo.getSelectedItem().toString();
    }
}
