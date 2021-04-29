/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Aguilar Quiñones
 */
package org.fundacion.jala.converter.view.utilities;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.Color;

/**
 * This class set the UI for the JCombobox.
 */
public class ComboUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new ComboUI();
    }

    /**
     * Sets the type of the Arrow from JCombobox.
     *
     * @return JButton of the Arrow.
     */
    @Override protected JButton createArrowButton() {
        return new BasicArrowButton(
                BasicArrowButton.SOUTH);
    }

    /**
     * Sets the style of the List of Combobox.
     *
     * @return ComboPopup the element of Combobox.
     */
    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
        basicComboPopup.setBorder(new LineBorder(Color.LIGHT_GRAY));
        return basicComboPopup;
    }
}
