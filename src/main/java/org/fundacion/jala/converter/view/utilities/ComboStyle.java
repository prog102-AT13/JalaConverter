package org.fundacion.jala.converter.view.utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

public class ComboStyle extends JComboBox {
    private final int FONT_SIZE = 12;

    public ComboStyle() {
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        setForeground(Color.DARK_GRAY);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 20, 5, 20));
        setRenderer(new CustomComboBoxRenderer());
    }

    class CustomComboBoxRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel lbl = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected,  cellHasFocus);
            lbl.setBorder(BorderFactory.createEmptyBorder(50, 7, 7, 50));
            lbl.setBackground(Color.WHITE);
            lbl.setForeground(Color.DARK_GRAY);
            return lbl;
        }
    }
}
