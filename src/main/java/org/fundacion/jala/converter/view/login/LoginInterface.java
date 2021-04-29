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

import org.fundacion.jala.converter.controller.response.PaoPaoResponse;
import org.fundacion.jala.converter.controller.response.SuccessAuthenticationResponse;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.utilities.TxtField;
import org.fundacion.jala.converter.view.MainInterface;
import org.fundacion.jala.converter.view.Models.AuthenticateRequestForm;
import org.fundacion.jala.converter.view.controllers.ClientRequest;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class creates the Login UI.
 */
public class LoginInterface extends JFrame implements ActionListener {
    private final int NUMBER_COLUMNS_TEXT_FIELD = 21;
    private final int BUTTON_EYE_SIZE = 20;
    private final int LOGIN_X_POSITION = 500;
    private final int LOGIN_Y_POSITION = 200;
    private final int LOGIN_WIDTH = 400;
    private final int LOGIN_HEIGHT = 250;
    private final int MARGIN_SPACE = 15;
    private final int VERTICAL_SPACE_FLOW = 10;
    private final int HORIZONTAL_SPACE_FLOW = 5;
    private final int FONT_SIZE = 12;
    private final int LOGIN_BUTTON_TYPE = 3;
    private final int REGITER_BUTTON_TYPE = 4;
    private final TxtField USERNAME_TEXT_FIELD = new TxtField(NUMBER_COLUMNS_TEXT_FIELD, true);
    private final JPasswordField PASSWORD_FIELD = new JPasswordField(NUMBER_COLUMNS_TEXT_FIELD);
    private final Icon EYE_ICON = new ImageIcon("img/EyeIcon.png");
    private final Icon image = new ImageIcon("img/loginImg.png");
    private final JLabel loginImg = new JLabel(image);
    private final BtnStyle LOGIN_BUTTON = new BtnStyle("Login", LOGIN_BUTTON_TYPE);
    private final JButton SHOW_PASSWORD_BUTTON = new JButton(EYE_ICON);
    private final BtnStyle REGISTER_BUTTON = new BtnStyle("Register", REGITER_BUTTON_TYPE);
    private final ClientRequest CLIENT_REQUEST = new ClientRequest();
    private final JLabelStyle USERNAME_LABEL = new JLabelStyle("Username: ", Color.WHITE, FONT_SIZE);
    private final JLabelStyle PASSWORD_LABEL = new JLabelStyle("Password: ", Color.WHITE, FONT_SIZE);
    private Boolean passwordShowStatus = true;
    private JButton CLOSE_BTN;
    private JPanel userPanel;
    private JPanel passPanel;
    private JPanel btnPanel;
    private JPanel mainContainer;
    private JPanel container;
    private JPanel mainPanel;

    public LoginInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(LOGIN_X_POSITION, LOGIN_Y_POSITION, LOGIN_WIDTH, LOGIN_HEIGHT);
        setUndecorated(true);
        setMinimumSize(new Dimension(LOGIN_WIDTH, LOGIN_HEIGHT));
        setPanels();
        setProperties();
        add(mainPanel);
        setVisible(true);
    }

    /**
     * Sets all the properties for components.
     */
    public void setProperties() {
        PASSWORD_FIELD.setForeground(Color.DARK_GRAY);
        PASSWORD_FIELD.setFont(new Font("Barlow", Font.PLAIN, FONT_SIZE));
        PASSWORD_FIELD.setBorder(new EmptyBorder(0, HORIZONTAL_SPACE_FLOW, 0, 0));
        LOGIN_BUTTON.addActionListener(this);
        SHOW_PASSWORD_BUTTON.addActionListener(this);
        REGISTER_BUTTON.addActionListener(this);
        CLOSE_BTN.setFont(new Font("Barlow", Font.BOLD, FONT_SIZE));
        CLOSE_BTN.setOpaque(true);
        CLOSE_BTN.setFocusPainted(false);
        CLOSE_BTN.setBackground(null);
        CLOSE_BTN.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        CLOSE_BTN.setBorder(border);
        SHOW_PASSWORD_BUTTON.setPreferredSize(new Dimension(BUTTON_EYE_SIZE, BUTTON_EYE_SIZE));
        SHOW_PASSWORD_BUTTON.setOpaque(true);
        SHOW_PASSWORD_BUTTON.setFocusPainted(false);
        SHOW_PASSWORD_BUTTON.setBackground(null);
        SHOW_PASSWORD_BUTTON.setBorder(border);
    }

    /**
     * Sets all the Panels and positions for components.
     */
    public void setPanels() {
        userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        userPanel.setBorder(new EmptyBorder(0, MARGIN_SPACE, 0, MARGIN_SPACE));
        userPanel.setLayout(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        userPanel.add(USERNAME_LABEL);
        userPanel.add(USERNAME_TEXT_FIELD);
        userPanel.setBackground(Color.DARK_GRAY);
        passPanel = new JPanel();
        passPanel.setBorder(new EmptyBorder(0, MARGIN_SPACE, 0, MARGIN_SPACE));
        passPanel.setLayout(new FlowLayout(FlowLayout.LEFT, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        passPanel.setBackground(Color.DARK_GRAY);
        passPanel.add(PASSWORD_LABEL);
        passPanel.add(PASSWORD_FIELD);
        passPanel.add(SHOW_PASSWORD_BUTTON);
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, HORIZONTAL_SPACE_FLOW, VERTICAL_SPACE_FLOW));
        btnPanel.add(LOGIN_BUTTON);
        btnPanel.add(REGISTER_BUTTON);
        btnPanel.setBackground(Color.DARK_GRAY);
        JPanel iconContainer = new JPanel();
        iconContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        iconContainer.setBorder(new EmptyBorder(HORIZONTAL_SPACE_FLOW, 0, HORIZONTAL_SPACE_FLOW, 0));
        iconContainer.add(loginImg);
        iconContainer.setBackground(Color.DARK_GRAY);
        mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.add(iconContainer);
        mainContainer.add(userPanel);
        mainContainer.add(passPanel);
        mainContainer.setBackground(Color.DARK_GRAY);
        container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.RIGHT));
        container.setBackground(Color.DARK_GRAY);
        CLOSE_BTN = new JButton(new AbstractAction("X") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        container.add(CLOSE_BTN);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(container, BorderLayout.NORTH);
        mainPanel.add(mainContainer, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBorder(new EmptyBorder(MARGIN_SPACE, MARGIN_SPACE, MARGIN_SPACE, MARGIN_SPACE));
    }

    /**
     * Sends a request with given information.
     *
     * @param username a String with username.
     * @param password a String with password.
     */
    public void callRequest(final String username, final String password) {
        PaoPaoResponse result;
        AuthenticateRequestForm authenticateRequestForm = new AuthenticateRequestForm();
        authenticateRequestForm.addUsername(username);
        authenticateRequestForm.addPassword(password);
        try {
            result = CLIENT_REQUEST.executeRequestWithoutToken(authenticateRequestForm);
            if ("200".equals(result.getStatus())) {
                this.dispose();
                SuccessAuthenticationResponse successAuthenticationResponse = (SuccessAuthenticationResponse) result;
                new MainInterface().initInterface(successAuthenticationResponse.getJwt());
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
