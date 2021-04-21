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

import org.fundacion.jala.converter.view.Models.RegisterRequestForm;
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

public class RegisterInterface extends JFrame implements ActionListener {
    private final Container registerContentPane = getContentPane();
    private final JLabel usernameLabel = new JLabel("USERNAME");
    private final JLabel passwordLabel = new JLabel("PASSWORD");
    private final JLabel passwordConfirmationLabel = new JLabel("<html>CONFIRM<br/>PASSWORD</html>");
    private final JTextField usernameTextField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JPasswordField passwordConfirmationField = new JPasswordField();
    private final JButton registerButton = new JButton("REGISTER");
    private final Icon backIcon = new ImageIcon("C:\\Users\\Raymundo\\Downloads\\BackIcon.jpg");
    private final JButton backButton = new JButton(backIcon);
    private final Icon eyeIcon = new ImageIcon("C:\\Users\\Raymundo\\Downloads\\EyeIcon.png");
    private final JButton showPasswordButton = new JButton(eyeIcon);
    private final JButton showPasswordConfirmationButton = new JButton(eyeIcon);
    private Boolean passwordShowStatus = true;
    private Boolean passwordConfirmationShowStatus = true;
    private ClientRequest clientRequest = new ClientRequest();

    public RegisterInterface() {
        setTitle("SIGN UP");
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
     * Sets the layout Manager for the Container
     */
    public void setLayoutManager() {
        registerContentPane.setLayout(null);
    }

    /**
     * Sets the position and size for the components
     */
    public void setLocationAndSize() {
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 120, 100, 30);
        passwordConfirmationLabel.setBounds(50, 190, 100, 30);
        usernameTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 120, 150, 30);
        passwordConfirmationField.setBounds(150, 190, 150, 30);
        registerButton.setBounds(150, 260, 100, 30);
        backButton.setBounds(50, 260, 30, 30);
        showPasswordButton.setBounds(300, 120, 29, 29);
        showPasswordConfirmationButton.setBounds(300, 190, 29, 29);
    }

    /**
     * Adds all the components to the Container
     */
    public void addComponentsToContainer() {
        registerContentPane.add(usernameLabel);
        registerContentPane.add(passwordLabel);
        registerContentPane.add(passwordConfirmationLabel);
        registerContentPane.add(usernameTextField);
        registerContentPane.add(passwordField);
        registerContentPane.add(passwordConfirmationField);
        registerContentPane.add(registerButton);
        registerContentPane.add(backButton);
        registerContentPane.add(showPasswordButton);
        registerContentPane.add(showPasswordConfirmationButton);
    }

    /**
     * Adds the different events to the ActionListener
     */
    public void addActionEvent() {
        registerButton.addActionListener(this);
        backButton.addActionListener(this);
        showPasswordButton.addActionListener(this);
        showPasswordConfirmationButton.addActionListener(this);
    }

    /**
     * Sends a request with given information
     * @param username a String with username
     * @param password a String with password
     */
    public void callRequest(final String username, final String password) {
        RegisterRequestForm registerRequestForm = new RegisterRequestForm();
        registerRequestForm.addUsername(username);
        registerRequestForm.addPassword(password);
        try {
            String result = clientRequest.executeRequestWithoutToken(registerRequestForm);
            System.out.println(result);
            JOptionPane.showMessageDialog(this, "Register successful");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid username");
        }
    }

    /**
     * Gets the actions performed on the components
     * @param e an action event
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameTextField.getText();
            String password = String.copyValueOf(passwordField.getPassword());
            String passwordConfirmation = String.copyValueOf(passwordConfirmationField.getPassword());
            if (password.equals(passwordConfirmation)) {
                callRequest(username, password);
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            }
            usernameTextField.setText("");
            passwordField.setText("");
            passwordConfirmationField.setText("");
        }

        if (e.getSource() == backButton) {
            this.dispose();
            new LoginInterface();
        }

        if (e.getSource() == showPasswordButton) {
            showOrHidePassword(passwordField, passwordShowStatus);
            passwordShowStatus = !passwordShowStatus;
        }

        if (e.getSource() == showPasswordConfirmationButton) {
            showOrHidePassword(passwordConfirmationField, passwordConfirmationShowStatus);
            passwordConfirmationShowStatus = !passwordConfirmationShowStatus;
        }
    }

    /**
     * Shows or Hides a JPasswordField depending on its status
     * @param jPasswordField the field to change
     * @param status a boolean with current status
     */
    public void showOrHidePassword(final JPasswordField jPasswordField, final boolean status) {
        if (status) {
            jPasswordField.setEchoChar((char) 0);
        } else {
            jPasswordField.setEchoChar('*');
        }
    }
}
