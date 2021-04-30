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

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * This class defines the JButton style for the project.
 */
public class BtnStyle extends JButton {
    private final Color GREEN_COLOR_BTN = new Color(86, 139, 77);
    private final Color ORANGE_COLOR_BTN = new Color(242, 156, 85);
    private final Color LIGHT_GRAY_COLOR_BTN = new Color(226, 226, 226);
    private final Color DARK_BACKGROUND_BTN = new Color(28, 28, 28);
    private final Color BLUE_COLOR_BTN = new Color(67, 117, 169);
    private final int FONT_SIZE_12 = 12;
    private final int FONT_SIZE_13 = 13;
    private final int FILE_BUTTON = 1;
    private final int CONVERT_BUTTON = 2;
    private final int LOGIN_BUTTON = 3;
    private final int REGISTER_BUTTON = 4;
    private final int WIDTH_BTN = 110;
    private final int HEIGHT_BTN = 25;
    private final int MARGIN = 10;

    public BtnStyle(final String text, final int btnType) {
        if (btnType == FILE_BUTTON) {
            setBtnFile(text);
        }
        if (btnType == CONVERT_BUTTON) {
            setBtnConvert(text);
        }
        if (btnType == LOGIN_BUTTON) {
            setLoginBtn(text);
        }
        if (btnType == REGISTER_BUTTON) {
            setRegisterBtn(text);
        }
    }

    public BtnStyle(final String text, final String icon, final int typeBtn) {
        if(typeBtn == 1) {
            setBtnMainMenu(text, icon);
        }
        if(typeBtn == 2) {
            setBtnCompilers(text, icon);
        }
    }

    /**
     * Sets JButton format for Login.
     *
     * @param text String for the JButton.
     */
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

    /**
     * Sets JButton format for Register.
     *
     * @param text String for the JButton.
     */
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

    /**
     * Sets JButton format for File Select.
     *
     * @param text String for the JButton.
     */
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

    /**
     * Sets JButton format for Convert Button.
     *
     * @param text String for the JButton.
     */
    public void setBtnConvert(String text) {
        final int FILE_BTN_WIDTH = 200;
        final int FILE_BTN_HEIGHT = 45;
        setText(text);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(FILE_BTN_WIDTH, FILE_BTN_HEIGHT));
        setOpaque(true);
        setBackground(BLUE_COLOR_BTN);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
    }

    /**
     * Sets JButton format for Main Menu Buttons.
     *
     * @param text String for the JButton.
     */
    public void setBtnMainMenu(String text, String icon) {
        int marginIcon = 20;
        int widthBtn = 200;
        int heightBtn = 50;
        Icon buttonIcon = new ImageIcon("img/mainButtons/" + icon);
        setText(text);
        setIcon(buttonIcon);
        setIconTextGap(marginIcon);
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setOpaque(true);
        setBackground(DARK_BACKGROUND_BTN);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_13));
        setPreferredSize(new Dimension(widthBtn, heightBtn));
    }

    public void setBtnCompilers(String text, String icon) {
        ImageIcon btnIcon = new ImageIcon("img/compilerBtn/" + icon);
        setText(text);
        setIcon(btnIcon);
        setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE_12));
        setPreferredSize(new Dimension(WIDTH_BTN, HEIGHT_BTN));
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setOpaque(true);
        setBackground(BLUE_COLOR_BTN);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        setBorder(border);
        setMargin(new Insets(MARGIN,0,0,0));
    }
}
