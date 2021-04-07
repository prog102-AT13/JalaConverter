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

    /**
     * Initialize the graphic components for Exporting format.
     * Output name of the file.
     */
    protected ExportingFormat() {
        JLabelStyle formatTitle = new JLabelStyle("Exporting Format", "h2", 2, 60, 0);
        JLabelStyle outPutTitle = new JLabelStyle("Output Information", "h2", 2, 60, 0);

        txtCheck = new JCheckBox(".txt");
        txtCheck.setFont(new Font("Barlow", 0, 12));
        htmlCheck = new JCheckBox(".html");
        htmlCheck.setFont(new Font("Barlow", 0, 12));
        xmpCheck = new JCheckBox(".xmp");
        xmpCheck.setFont(new Font("Barlow", 0, 12));
        setLayout(new GridLayout(5, 1));
        setBorder(new EmptyBorder(5, 40, 0, 0));
        add(formatTitle.getTextLabel());
        add(txtCheck);
        add(htmlCheck);
        add(xmpCheck);
        add(outPutTitle.getTextLabel());
    }

    /**
     * Method that returns if Txt checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String txtChecked() {
        return txtCheck.isSelected() ? "format Txt\n" : "";
    }

    /**
     * Method that returns if Html checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String isHtmlChecked() {
        return htmlCheck.isSelected() ? "format HTML\n" : "";
    }

    /**
     * Method that returns if Xmp checkbox is selected.
     * @return true if is selected, false if not.
     */
    protected String isXmpChecked() {
        return xmpCheck.isSelected() ? "format Xmp\n" : "";
    }
}
