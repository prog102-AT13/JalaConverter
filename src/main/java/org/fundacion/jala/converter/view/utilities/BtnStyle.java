package org.fundacion.jala.converter.view.utilities;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;

public class BtnStyle extends JButton {
    private final Color GREEN_COLOR_BTN = new Color(86, 139, 77);
    private final Color ORANGE_COLOR_BTN = new Color(242, 156, 85);
    private final Color LIGHT_GRAY_COLOR_BTN = new Color(226, 226, 226);
    private final int FONT_SIZE_12 = 12;

    public BtnStyle(final String text, final int btnType) {
        if (btnType == 1) {
            setBtnFile(text);
        }
        if (btnType == 2) {
            setBtnConvert(text);
        }
        if (btnType == 3) {
            setLoginBtn(text);
        }
        if (btnType == 4) {
            setRegisterBtn(text);
        }
    }

    public void setLoginBtn(String text) {
        final int FILE_BTN_WIDTH = 100;
        final int FILE_BTN_HEIGHT = 30;
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(FILE_BTN_WIDTH, FILE_BTN_HEIGHT));
        setOpaque(true);
        setFocusPainted(false);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
        setBackground(ORANGE_COLOR_BTN);
        setForeground(Color.WHITE);
    }

    public void setRegisterBtn(String text) {
        final int FILE_BTN_WIDTH = 100;
        final int FILE_BTN_HEIGHT = 30;
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(FILE_BTN_WIDTH, FILE_BTN_HEIGHT));
        setOpaque(true);
        setFocusPainted(false);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
        setBackground(LIGHT_GRAY_COLOR_BTN);
        setForeground(Color.DARK_GRAY);
    }

    public void setBtnFile(String text) {
        final int FILE_BTN_WIDTH = 90;
        final int FILE_BTN_HEIGHT = 25;
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(FILE_BTN_WIDTH, FILE_BTN_HEIGHT));
        setOpaque(true);
        setBackground(GREEN_COLOR_BTN);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
    }

    public void setBtnConvert(String text) {
        final int FILE_BTN_WIDTH = 200;
        final int FILE_BTN_HEIGHT = 45;
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(FILE_BTN_WIDTH, FILE_BTN_HEIGHT));
    }
}
