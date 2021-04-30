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

import org.fundacion.jala.converter.view.utilities.ComboStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * This class defines the interface for selecting the type of video to convert.
 */
class ConverterTypeSelect extends JPanel {
    private ComboStyle convertTo;
    private final int DIMENSION_WIDTH = 100;
    private final int DIMENSION_HEIGHT = 20;
    private final int MARGIN_SPACE = 20;

    protected ConverterTypeSelect() {
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h3");
        convertTo = new ComboStyle(DIMENSION_WIDTH, DIMENSION_HEIGHT);
        convertTo.addItem("avi");
        convertTo.addItem("mp4");
        convertTo.addItem("mpeg");
        convertTo.addItem("mov");
        convertTo.addItem("wmv");
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, MARGIN_SPACE));
        add(labelConvertTo);
        add(convertTo);
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
