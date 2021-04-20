/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.login;

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
import javax.swing.ImageIcon;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.fundacion.jala.converter.models.UserSQL.usernameExists;

public class LoginInterface extends JFrame implements ActionListener {
    private Container loginContentPane = getContentPane();
    private JLabel usernameLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField usernameTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    private Icon eyeIcon = new ImageIcon("C:\\Users\\Raymundo\\Downloads\\EyeIcon.png");
    private JButton showPasswordButton = new JButton(eyeIcon);
    private Boolean passwordShowStatus = true;
    private JButton registerButton = new JButton("REGISTER");
    private static final int FIELDS_HEIGHT = 30;
    private static final int TEXT_FIELD_WIDTH = 150;
    private static final int LABEL_OR_BUTTON_WIDTH = 100;
    private static final int SMALL_BUTTON_SIZE = 29;
    private ClientRequest clientRequest = new ClientRequest();

    public LoginInterface() {
        setTitle("LOGIN");
        setVisible(true);
        setBounds(500, 200, 400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * Sets the layout manager for the container
     */
    public void setLayoutManager() {
        loginContentPane.setLayout(null);
    }

    /**
     * Sets all the components location and sizes
     */
    public void setLocationAndSize() {
        usernameLabel.setBounds(50, 50, LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        passwordLabel.setBounds(50, 120, LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        usernameTextField.setBounds(150, 50, TEXT_FIELD_WIDTH, FIELDS_HEIGHT);
        passwordField.setBounds(150, 120, TEXT_FIELD_WIDTH, FIELDS_HEIGHT);
        loginButton.setBounds(225, 190, LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
        showPasswordButton.setBounds(300, 120, SMALL_BUTTON_SIZE, SMALL_BUTTON_SIZE);
        registerButton.setBounds(75, 190, LABEL_OR_BUTTON_WIDTH, FIELDS_HEIGHT);
    }

    /**
     * Adds all the components to the container
     */
    public void addComponentsToContainer() {
        loginContentPane.add(usernameLabel);
        loginContentPane.add(passwordLabel);
        loginContentPane.add(usernameTextField);
        loginContentPane.add(passwordField);
        loginContentPane.add(loginButton);
        loginContentPane.add(showPasswordButton);
        loginContentPane.add(registerButton);
    }

    /**
     * Adds the actions performed
     */
    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPasswordButton.addActionListener(this);
        registerButton.addActionListener(this);
    }

    /**
     *
     * @param username
     * @param password
     */
    public void callRequest(final String username, final String password) {
        AuthenticateRequestForm authenticateRequestForm = new AuthenticateRequestForm();
        authenticateRequestForm.addUsername(username);
        authenticateRequestForm.addPassword(password);
        try {
            String result = clientRequest.executeRequestWithoutToken(authenticateRequestForm);
            clientRequest.setToken(result);
            System.out.println(result);
            this.dispose();
            new MainInterface().initInterface();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    /**
     * Defines the operation after an action is done
     * @param e an action performed by user
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == loginButton) {
            String usernameText = usernameTextField.getText();
            String passwordText = String.copyValueOf(passwordField.getPassword());
            callRequest(usernameText, passwordText);
        }

        if (e.getSource() == showPasswordButton) {
            if (passwordShowStatus) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
            passwordShowStatus = !passwordShowStatus;
        }

        if (e.getSource() == registerButton) {
            this.dispose();
            RegisterInterface registerInterface = new RegisterInterface();
        }
    }
}
