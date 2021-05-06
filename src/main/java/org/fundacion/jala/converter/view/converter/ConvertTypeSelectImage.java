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
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 * This class defines the interface for selecting the type of image to convert.
 */
public class ConvertTypeSelectImage extends JPanel {
    private final int DIMENSION_WIDTH = 100;
    private final int DIMENSION_HEIGHT = 20;
    private final int FONT_SIZE = 12;
    private final int MARGIN_SPACE = 20;
    private ComboStyle convertTo;

    public ConvertTypeSelectImage() {
        JLabelStyle labelConvertTo = new JLabelStyle("Convert to: ", "h3");
        convertTo = new ComboStyle();
        convertTo.setPreferredSize(new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT));
        convertTo.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        convertTo.addItem("png");
        convertTo.addItem("jpg");
        convertTo.addItem("jpeg");
        convertTo.addItem("tiff");
        convertTo.addItem("bmp");
        convertTo.addItem("gif");
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
