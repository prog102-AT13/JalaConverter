/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.metadata;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Font;

class ExportingFormat extends JPanel {
    private JCheckBox txtCheck;
    private JCheckBox htmlCheck;
    private JCheckBox xmpCheck;
    private final int alignLabelStyle = 2;
    private final int widthLabelStyle = 60;
    private final int heightLabelStyle = 0;
    private final int topBorder = 5;
    private final int leftBorder = 40;
    private final int bottomBorder = 0;
    private final int rightBorder = 0;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private final int gridLayoutRows = 5;
    private final int gridLayoutCols = 1;

    /**
     * Initializes the graphic components for Exporting format.
     * Output name of the file.
     */
    protected ExportingFormat() {
        JLabelStyle formatTitle = new JLabelStyle("Exporting Format", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        JLabelStyle outPutTitle = new JLabelStyle("Output Information", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        txtCheck = new JCheckBox(".txt");
        txtCheck.setFont(new Font("Barlow", fontStyle, fontSize));
        htmlCheck = new JCheckBox(".html");
        htmlCheck.setFont(new Font("Barlow", fontStyle, fontSize));
        xmpCheck = new JCheckBox(".xmp");
        xmpCheck.setFont(new Font("Barlow", fontStyle, fontSize));
        setLayout(new GridLayout(gridLayoutRows, gridLayoutCols));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(formatTitle.getTextLabel());
        add(txtCheck);
        add(htmlCheck);
        add(xmpCheck);
        add(outPutTitle.getTextLabel());
    }

    /**
     * Returns if Txt checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String txtChecked() {
        return txtCheck.isSelected() ? "format Txt\n" : "";
    }

    /**
     * Returns if Html checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String isHtmlChecked() {
        return htmlCheck.isSelected() ? "format HTML\n" : "";
    }

    /**
     * Returns if Xmp checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String isXmpChecked() {
        return xmpCheck.isSelected() ? "format Xmp\n" : "";
    }
}
