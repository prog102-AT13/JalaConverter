package org.fundacion.jala.converter.view.utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ComboStyle extends JComboBox {
    private final int FONT_SIZE = 12;

    public ComboStyle() {
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        setForeground(Color.DARK_GRAY);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 20, 5, 20));
    }
}
