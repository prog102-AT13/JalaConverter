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

/**
 * This class defines the JLabel's style.
 */
public class JLabelStyle extends JLabel {
    private final int FONT_SIZE_10 = 10;
    private final int FONT_SIZE_12 = 12;
    private final int FONT_SIZE_16 = 16;
    private final int FONT_SIZE_20 = 20;


    public JLabelStyle(final String text, final String type) {
        if (type == "h1") {
            setTitle(text);
        } else if (type == "h2") {
            setSubtitle(text);
        } else if (type == "h3") {
            setSecondSubtitle(text);
        } else if (type == "h4") {
            setContent(text);
        } else if (type == "h5") {
            setFooter(text);
        }
    }

    public JLabelStyle(final String text, final Color color, final int size) {
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, size));
        setForeground(color);
    }

    /**
     * Sets JLabel format for Titles.
     *
     * @param text String to format.
     */
    private void setTitle(final String text) {
        setText(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Barlow", Font.BOLD, FONT_SIZE_20));
        setForeground(Color.DARK_GRAY);
    }

    /**
     * Sets JLabel format for Subtitles.
     *
     * @param text String to format.
     */
    private void setSubtitle(final String text) {
        setText(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Barlow", Font.BOLD, FONT_SIZE_16));
        setForeground(Color.DARK_GRAY);
    }

    /**
     * Sets JLabel format for Second Subtitle Text.
     *
     * @param text String to format.
     */
    private void setSecondSubtitle(final String text) {
        setText(text);
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(new Font("Barlow", Font.BOLD, FONT_SIZE_12));
        setForeground(Color.DARK_GRAY);
    }

    /**
     * Sets JLabel format for General Text.
     *
     * @param text String to format.
     */
    private void setContent(final String text) {
        setText(text);
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setForeground(Color.DARK_GRAY);
    }

    /**
     * Sets JLabel format for footer Text.
     *
     * @param text String to format.
     */
    private void setFooter(final String text) {
        setText(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_10));
        setForeground(Color.DARK_GRAY);
    }
}
