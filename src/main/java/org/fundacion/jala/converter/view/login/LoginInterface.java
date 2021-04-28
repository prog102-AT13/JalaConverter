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
import org.springframework.security.authentication.BadCredentialsException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class creates the Login UI.
 */
public class LoginInterface extends JFrame implements ActionListener {
    private final Container LOGIN_CONTENT_PANE = getContentPane();
    private final JLabel USERNAME_LABEL = new JLabel("USERNAME");
    private final JLabel PASSWORD_LABEL = new JLabel("PASSWORD");
    private final JTextField USERNAME_TEXT_FIELD = new JTextField();
    private final JPasswordField PASSWORD_FIELD = new JPasswordField();
    private final Icon EYE_ICON = new ImageIcon("img/EyeIcon.png");
    private final JButton LOGIN_BUTTON = new JButton("LOGIN");
    private final JButton SHOW_PASSWORD_BUTTON = new JButton(EYE_ICON);
    private final JButton REGISTER_BUTTON = new JButton("REGISTER");
    private final ClientRequest CLIENT_REQUEST = new ClientRequest();
    private final int FIELDS_HEIGHT = 30;
    private final int TEXT_FIELD_WIDTH = 150;
    private final int LABEL_OR_BUTTON_WIDTH = 100;
    private final int SMALL_BUTTON_SIZE = 29;
    private final int LOGIN_X_POSITION = 500;
    private final int LOGIN_Y_POSITION = 200;
    private final int LOGIN_WIDTH = 400;
    private final int LOGIN_HEIGHT = 350;
    private final int LABEL_X_POSITION = 50;
    private final int TEXT_FIELD_X_POSITION = 150;
    private final int FIRST_COMPONENTS_Y_POSITION = 50;
    private final int SECOND_COMPONENTS_Y_POSITION = 120;
    private final int THIRD_COMPONENTS_Y_POSITION = 190;
    private final int LOGIN_BUTTON_X_POSITION = 225;
    private final int SHOW_PASSWORD_BUTTON_X_POSITION = 300;
    private final int REGISTER_BUTTON_X_POSITION = 75;
    private Boolean passwordShowStatus = true;

    public LoginInterface() {
        setTitle("LOGIN");
        setVisible(true);
        setBounds(LOGIN_X_POSITION, LOGIN_Y_POSITION, LOGIN_WIDTH, LOGIN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * Sets the layout manager for the container.
     */
    public void setLayoutManager() {
        LOGIN_CONTENT_PANE.setLayout(null);
    }

    /**
     * Sets all the components location and sizes.
     */
    public void setLocationAndSize() {
        USERNAME_LABEL.setBounds(LABEL_X_POSITION, FIRST_COMPONENTS_Y_POSITION,
                LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        PASSWORD_LABEL.setBounds(LABEL_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        USERNAME_TEXT_FIELD.setBounds(TEXT_FIELD_X_POSITION, FIRST_COMPONENTS_Y_POSITION,
                TEXT_FIELD_WIDTH, FIELDS_HEIGHT);
        PASSWORD_FIELD.setBounds(TEXT_FIELD_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                TEXT_FIELD_WIDTH, FIELDS_HEIGHT);
        LOGIN_BUTTON.setBounds(LOGIN_BUTTON_X_POSITION, THIRD_COMPONENTS_Y_POSITION,
                LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        SHOW_PASSWORD_BUTTON.setBounds(SHOW_PASSWORD_BUTTON_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                SMALL_BUTTON_SIZE, SMALL_BUTTON_SIZE);
        REGISTER_BUTTON.setBounds(REGISTER_BUTTON_X_POSITION, THIRD_COMPONENTS_Y_POSITION,
                LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
    }

    /**
     * Adds all the components to the container.
     */
    public void addComponentsToContainer() {
        LOGIN_CONTENT_PANE.add(USERNAME_LABEL);
        LOGIN_CONTENT_PANE.add(PASSWORD_LABEL);
        LOGIN_CONTENT_PANE.add(USERNAME_TEXT_FIELD);
        LOGIN_CONTENT_PANE.add(PASSWORD_FIELD);
        LOGIN_CONTENT_PANE.add(LOGIN_BUTTON);
        LOGIN_CONTENT_PANE.add(SHOW_PASSWORD_BUTTON);
        LOGIN_CONTENT_PANE.add(REGISTER_BUTTON);
    }

    /**
     * Adds the actions performed.
     */
    public void addActionEvent() {
        LOGIN_BUTTON.addActionListener(this);
        SHOW_PASSWORD_BUTTON.addActionListener(this);
        REGISTER_BUTTON.addActionListener(this);
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
        //new MainInterface().initInterface(result);
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
