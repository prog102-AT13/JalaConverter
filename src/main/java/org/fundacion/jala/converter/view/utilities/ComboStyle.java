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

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

/**
 * This class set the style for JComboBox.
 */
public class ComboStyle<E> extends JComboBox {
    private final int THICK_BORDER = 1;
    private final int MARGIN_COMBOBOX = 5;
    private final int FONT_SIZE = 12;
    private final Font DEFAULT_FONT = new Font("Barlow", Font.PLAIN, FONT_SIZE);

    public ComboStyle(final int width, final int height) {
        Dimension dimension = new Dimension(width,height);
        setPreferredSize(dimension);
        setSize(dimension);
        setForeground(Color.DARK_GRAY);
        setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, THICK_BORDER),
                new EmptyBorder(0, MARGIN_COMBOBOX, 0, 0)));
        setFont(DEFAULT_FONT);
        setFocusable(false);
        setBackground(Color.WHITE);
        setUI(ComboUI.createUI(this));
        setVisible(true);
    }

    public ComboStyle() {
        setForeground(Color.DARK_GRAY);
        setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, THICK_BORDER),
                new EmptyBorder(0, MARGIN_COMBOBOX, 0, 0)));
        setFont(DEFAULT_FONT);
        setFocusable(false);
        setBackground(Color.WHITE);
        setUI(ComboUI.createUI(this));
        setVisible(true);
    }

    public ComboStyle(E[] items) {
        setForeground(Color.DARK_GRAY);
        setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, THICK_BORDER),
                new EmptyBorder(0, MARGIN_COMBOBOX, 0, 0)));
        setFont(DEFAULT_FONT);
        setFocusable(false);
        setBackground(Color.WHITE);
        setUI(ComboUI.createUI(this));
        setVisible(true);
        setModel(new DefaultComboBoxModel<E>(items));
    }
}
