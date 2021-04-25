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
package org.fundacion.jala.converter.view.utilities;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

/**
 * This class defines the JLabel's style.
 */
public class JLabelStyle extends JLabel {
    private JLabel textLabel;
    private final int FONT_STYLE_TITLE = 1;
    private final int FONT_SIZE_TITLE = 18;
    private final int FONT_STYLE_SUBTITLE = 1;
    private final int FONT_SIZE_SUBTITLE = 16;
    private final int FONT_STYLE_CONTENT = 0;
    private final int FONT_SIZE_CONTENT = 12;

    public JLabelStyle(final String text, final String type, final int align, final int width, final int height) {
        if (type == "h1") {
            setTitle(text, align, width, height);
        } else if (type == "h2") {
            setSubtitle(text, align, width, height);
        } else if (type == "h3") {
            setContent(text, align, width, height);
        }
    }

    /**
     * Sets JLabel format for Titles.
     *
     * @param text String to format.
     * @param align Align the text 0 center, 1 right, 2 left (defect).
     * @param width Width size of the JLabel.
     * @param height Height size of the JLabel.
     */
    private void setTitle(final String text, final int align, final int width, final int height) {
        if (align == 0) {
            this.textLabel = new JLabel(text, SwingConstants.CENTER);
        } else if (align == 1) {
            this.textLabel =  new JLabel(text, SwingConstants.RIGHT);
        } else if (align == 2) {
            this.textLabel = new JLabel(text);
        }
        textLabel.setFont(new Font("Barlow", FONT_STYLE_TITLE, FONT_SIZE_TITLE));
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Sets JLabel format for Subtitles.
     *
     * @param text String to format.
     * @param align Align the text 0 center, 1 right, 2 left (defect).
     * @param width Width size of the JLabel.
     * @param height Height size of the JLabel.
     */
    private void setSubtitle(final String text, final int align, final int width, final int height) {
        if (align == 0) {
            this.textLabel = new JLabel(text, SwingConstants.CENTER);
        } else if (align == 1) {
            this.textLabel =  new JLabel(text, SwingConstants.RIGHT);
        } else {
            this.textLabel = new JLabel(text);
        }
        textLabel.setFont(new Font("Barlow", FONT_STYLE_SUBTITLE, FONT_SIZE_SUBTITLE));
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Sets JLabel format for General Text.
     *
     * @param text String to format.
     * @param align Align the text 0 center, 1 right, 2 left (defect).
     * @param width Width size of the JLabel.
     * @param height Height size of the JLabel.
     */
    private void setContent(final String text, final int align, final int width, final int height) {
        if (align == 0) {
            this.textLabel = new JLabel(text, SwingConstants.CENTER);
        } else if (align == 1) {
            this.textLabel =  new JLabel(text, SwingConstants.RIGHT);
        } else {
            this.textLabel = new JLabel(text);
        }
        textLabel.setFont(new Font("Barlow", FONT_STYLE_CONTENT, FONT_SIZE_CONTENT));
        textLabel.setForeground(Color.DARK_GRAY);
        textLabel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Return the text, formatted with the Style.
     *
     * @return a JLabel formatted.
     */
    public JLabel getTextLabel() {
        return this.textLabel;
    }
}
