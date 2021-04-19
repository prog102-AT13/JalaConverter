/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.login;

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
    Container registerContentPane = getContentPane();
    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel passwordConfirmationLabel = new JLabel("<html>CONFIRM<br/>PASSWORD</html>");
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField passwordConfirmationField = new JPasswordField();
    JButton registerButton = new JButton("REGISTER");
    Icon backIcon = new ImageIcon("C:\\Users\\Raymundo\\Downloads\\BackIcon.jpg");
    JButton backButton = new JButton(backIcon);
    Icon eyeIcon = new ImageIcon("C:\\Users\\Raymundo\\Downloads\\EyeIcon.png");
    JButton showPasswordButton = new JButton(eyeIcon);
    JButton showPasswordConfirmationButton = new JButton(eyeIcon);
    Boolean passwordShowStatus = true;
    Boolean passwordConfirmationShowStatus = true;

    public RegisterInterface() {
        setTitle("SIGN UP");
        setVisible(true);
        setBounds(500,200,400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        registerContentPane.setLayout(null);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(50,50,100,30);
        passwordLabel.setBounds(50,120,100,30);
        passwordConfirmationLabel.setBounds(50, 190, 100, 30);
        usernameTextField.setBounds(150,50,150,30);
        passwordField.setBounds(150,120,150,30);
        passwordConfirmationField.setBounds(150,190,150,30);
        registerButton.setBounds(150, 260, 100, 30);
        backButton.setBounds(50, 260, 30, 30);
        showPasswordButton.setBounds(300, 120, 29, 29);
        showPasswordConfirmationButton.setBounds(300, 190, 29, 29);
    }

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

    public void addActionEvent() {
        registerButton.addActionListener(this);
        backButton.addActionListener(this);
        showPasswordButton.addActionListener(this);
        showPasswordConfirmationButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameTextField.getText();
            String password = String.copyValueOf(passwordField.getPassword());
            String passwordConfirmation = String.copyValueOf(passwordConfirmationField.getPassword());
            if (password.equals(passwordConfirmation)) {
                JOptionPane.showMessageDialog(this, "Register Successful");
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
            if (passwordShowStatus) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
            passwordShowStatus = !passwordShowStatus;
        }

        if (e.getSource() == showPasswordConfirmationButton) {
            if (passwordConfirmationShowStatus) {
                passwordConfirmationField.setEchoChar((char) 0);
            } else {
                passwordConfirmationField.setEchoChar('*');
            }
            passwordConfirmationShowStatus = !passwordConfirmationShowStatus;
        }
    }
}
