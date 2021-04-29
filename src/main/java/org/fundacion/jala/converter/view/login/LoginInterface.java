/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.view.login;

import org.fundacion.jala.converter.view.MainInterface;
import org.fundacion.jala.converter.view.Models.AuthenticateRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.springframework.security.authentication.BadCredentialsException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.IOException;

/**
 * This class creates the Login UI.
 */
public class LoginInterface extends JFrame implements ActionListener {
    private final JLabel USERNAME_LABEL = new JLabel("Username: ");
    private final JLabel PASSWORD_LABEL = new JLabel("Password: ");
    private final JTextField USERNAME_TEXT_FIELD = new JTextField(19);
    private final JPasswordField PASSWORD_FIELD = new JPasswordField(19);
    private final Icon EYE_ICON = new ImageIcon("img/EyeIcon.png");
    private final BtnStyle LOGIN_BUTTON = new BtnStyle("Login", 3);
    private final JButton SHOW_PASSWORD_BUTTON = new JButton(EYE_ICON);
    private JButton CLOSE_BTN;
    private final BtnStyle REGISTER_BUTTON = new BtnStyle("Register", 4);
    private final ClientRequest CLIENT_REQUEST = new ClientRequest();
    private final int LOGIN_X_POSITION = 500;
    private final int LOGIN_Y_POSITION = 200;
    private final int LOGIN_WIDTH = 400;
    private final int LOGIN_HEIGHT = 250;
    private final int MARGIN_SPACE = 50;
    private final int VERTICAL_SPACE_FLOW = 10;
    private final int HORIZONTAL_SPACE_FLOW = 5;
    private Boolean passwordShowStatus = true;

    public LoginInterface() {
        ImageIcon image = new ImageIcon("img/loginImg.png");
        JLabel loginImg = new JLabel(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(LOGIN_X_POSITION, LOGIN_Y_POSITION, LOGIN_WIDTH, LOGIN_HEIGHT);
        setUndecorated(true);
        setMinimumSize(new Dimension(LOGIN_WIDTH, LOGIN_HEIGHT));
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userPanel.setBorder(new EmptyBorder(0, MARGIN_SPACE, 0, MARGIN_SPACE));
        userPanel.setLayout(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        userPanel.add(USERNAME_LABEL);
        userPanel.add(USERNAME_TEXT_FIELD);
        userPanel.setBackground(Color.DARK_GRAY);
        JPanel passPanel = new JPanel();
        passPanel.setBorder(new EmptyBorder(0, MARGIN_SPACE, 0, MARGIN_SPACE));
        passPanel.setLayout(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        passPanel.setBackground(Color.DARK_GRAY);
        passPanel.add(PASSWORD_LABEL);
        passPanel.add(PASSWORD_FIELD);
        passPanel.add(SHOW_PASSWORD_BUTTON);
        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(new EmptyBorder(0, MARGIN_SPACE, 0, MARGIN_SPACE));
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        btnPanel.add(LOGIN_BUTTON);
        btnPanel.add(REGISTER_BUTTON);
        btnPanel.setBackground(Color.DARK_GRAY);
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.RIGHT));
        container.setBackground(Color.DARK_GRAY);
        CLOSE_BTN = new JButton(new AbstractAction("X") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        container.add(CLOSE_BTN);
        setProperties();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(container);
        mainPanel.add(loginImg);
        mainPanel.add(userPanel);
        mainPanel.add(passPanel);
        mainPanel.add(btnPanel);
        mainPanel.setBackground(Color.DARK_GRAY);
        add(mainPanel);
        setVisible(true);
    }

    /**
     * Sets all the components location and sizes.
     */
    public void setProperties() {
        USERNAME_LABEL.setForeground(Color.WHITE);
        USERNAME_LABEL.setFont(new Font("Barlow", Font.PLAIN, 12));
        PASSWORD_LABEL.setForeground(Color.WHITE);
        PASSWORD_LABEL.setFont(new Font("Barlow", Font.PLAIN, 12));
        USERNAME_TEXT_FIELD.setFont(new Font("Barlow", Font.PLAIN, 12));
        USERNAME_TEXT_FIELD.setForeground(Color.DARK_GRAY);
        PASSWORD_FIELD.setForeground(Color.DARK_GRAY);
        PASSWORD_FIELD.setFont(new Font("Barlow", Font.PLAIN, 12));
        LOGIN_BUTTON.addActionListener(this);
        SHOW_PASSWORD_BUTTON.addActionListener(this);
        REGISTER_BUTTON.addActionListener(this);
        CLOSE_BTN.setFont(new Font("Barlow", Font.BOLD, 12));
        CLOSE_BTN.setOpaque(true);
        CLOSE_BTN.setFocusPainted(false);
        CLOSE_BTN.setBackground(null);
        CLOSE_BTN.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        CLOSE_BTN.setBorder(border);
        SHOW_PASSWORD_BUTTON.setPreferredSize(new Dimension(20, 20));
        SHOW_PASSWORD_BUTTON.setOpaque(true);
        SHOW_PASSWORD_BUTTON.setFocusPainted(false);
        SHOW_PASSWORD_BUTTON.setBackground(null);
        SHOW_PASSWORD_BUTTON.setBorder(border);
    }

    /**
     * Sends a request with given information.
     *
     * @param username a String with username.
     * @param password a String with password.
     */
    public void callRequest(final String username, final String password) {
        String result = "";
        AuthenticateRequestForm authenticateRequestForm = new AuthenticateRequestForm();
        authenticateRequestForm.addUsername(username);
        authenticateRequestForm.addPassword(password);
        try {
            result = CLIENT_REQUEST.executeRequestWithoutToken(authenticateRequestForm);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = result.substring(8, result.length() - 2);
        this.dispose();
        new MainInterface().initInterface(result);
    }

    /**
     * Defines the operation after an action is done.
     *
     * @param e an action performed by user.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == LOGIN_BUTTON) {
            String usernameText = USERNAME_TEXT_FIELD.getText();
            String passwordText = String.copyValueOf(PASSWORD_FIELD.getPassword());
            callRequest(usernameText, passwordText);
        }
        if (e.getSource() == SHOW_PASSWORD_BUTTON) {
            if (passwordShowStatus) {
                PASSWORD_FIELD.setEchoChar((char) 0);
            } else {
                PASSWORD_FIELD.setEchoChar('*');
            }
            passwordShowStatus = !passwordShowStatus;
        }
        if (e.getSource() == REGISTER_BUTTON) {
            this.dispose();
            new RegisterInterface();
        }
    }
}
