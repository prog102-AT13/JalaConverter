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

import org.apache.http.client.ClientProtocolException;
import org.fundacion.jala.converter.controller.response.PaoPaoResponse;
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
import java.io.IOException;

/**
 * This class creates the Register UI.
 */
public class RegisterInterface extends JFrame implements ActionListener {
    private final Container REGISTER_CONTENT_PANE = getContentPane();
    private final JLabel USERNAME_LABEL = new JLabel("USERNAME");
    private final JLabel PASSWORD_LABEL = new JLabel("PASSWORD");
    private final JLabel PASSWORD_CONFIRMATION_LABEL = new JLabel("<html>CONFIRM<br/>PASSWORD</html>");
    private final JTextField USERNAME_TEXT_FIELD = new JTextField();
    private final JPasswordField PASSWORD_FIELD = new JPasswordField();
    private final JPasswordField PASSWORD_CONFIRMATION_FIELD = new JPasswordField();
    private final Icon BACK_ICON = new ImageIcon("img/BackIcon.jpg");
    private final Icon EYE_ICON = new ImageIcon("img/EyeIcon.png");
    private final JButton REGISTER_BUTTON = new JButton("REGISTER");
    private final JButton BACK_BUTTON = new JButton(BACK_ICON);
    private final JButton SHOW_PASSWORD_BUTTON = new JButton(EYE_ICON);
    private final JButton SHOW_PASSWORD_CONFIRMATION_BUTTON = new JButton(EYE_ICON);
    private final ClientRequest CLIENT_REQUEST = new ClientRequest();
    private final int REGISTER_X_POSITION = 500;
    private final int REGISTER_Y_POSITION = 200;
    private final int REGISTER_WIDTH = 400;
    private final int REGISTER_HEIGHT = 350;
    private final int LABEL_X_POSITION = 50;
    private final int TEXT_FIELD_X_POSITION = 150;
    private final int PASSWORD_SHOW_X_POSITION = 300;
    private final int FIRST_COMPONENTS_Y_POSITION = 50;
    private final int SECOND_COMPONENTS_Y_POSITION = 120;
    private final int THIRD_COMPONENTS_Y_POSITION = 190;
    private final int FOURTH_COMPONENTS_Y_POSITION = 260;
    private final int LABEL_BUTTON_WIDTH = 100;
    private final int TEXT_FIELD_WIDTH = 150;
    private final int SMALL_BUTTON_SIZE = 29;
    private final int LABEL_TEXT_FIELD_HEIGHT = 30;
    private Boolean passwordShowStatus = true;
    private Boolean passwordConfirmationShowStatus = true;

    /**
     * Initializes the graphics components for the Register interface.
     */
    public RegisterInterface() {
        setTitle("SIGN UP");
        setVisible(true);
        setBounds(REGISTER_X_POSITION, REGISTER_Y_POSITION, REGISTER_WIDTH, REGISTER_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    /**
     * Sets the layout Manager for the Container.
     */
    public void setLayoutManager() {
        REGISTER_CONTENT_PANE.setLayout(null);
    }

    /**
     * Sets the position and size for the components.
     */
    public void setLocationAndSize() {
        USERNAME_LABEL.setBounds(LABEL_X_POSITION, FIRST_COMPONENTS_Y_POSITION,
                LABEL_BUTTON_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        PASSWORD_LABEL.setBounds(LABEL_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                LABEL_BUTTON_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        PASSWORD_CONFIRMATION_LABEL.setBounds(LABEL_X_POSITION, THIRD_COMPONENTS_Y_POSITION,
                LABEL_BUTTON_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        USERNAME_TEXT_FIELD.setBounds(TEXT_FIELD_X_POSITION, FIRST_COMPONENTS_Y_POSITION,
                TEXT_FIELD_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        PASSWORD_FIELD.setBounds(TEXT_FIELD_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                TEXT_FIELD_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        PASSWORD_CONFIRMATION_FIELD.setBounds(TEXT_FIELD_X_POSITION, THIRD_COMPONENTS_Y_POSITION,
                TEXT_FIELD_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        REGISTER_BUTTON.setBounds(TEXT_FIELD_X_POSITION, FOURTH_COMPONENTS_Y_POSITION,
                LABEL_BUTTON_WIDTH, LABEL_TEXT_FIELD_HEIGHT);
        BACK_BUTTON.setBounds(LABEL_X_POSITION, FOURTH_COMPONENTS_Y_POSITION,
                SMALL_BUTTON_SIZE, SMALL_BUTTON_SIZE);
        SHOW_PASSWORD_BUTTON.setBounds(PASSWORD_SHOW_X_POSITION, SECOND_COMPONENTS_Y_POSITION,
                SMALL_BUTTON_SIZE, SMALL_BUTTON_SIZE);
        SHOW_PASSWORD_CONFIRMATION_BUTTON.setBounds(PASSWORD_SHOW_X_POSITION, THIRD_COMPONENTS_Y_POSITION,
                SMALL_BUTTON_SIZE, SMALL_BUTTON_SIZE);
    }

    /**
     * Adds all the components to the Container.
     */
    public void addComponentsToContainer() {
        REGISTER_CONTENT_PANE.add(USERNAME_LABEL);
        REGISTER_CONTENT_PANE.add(PASSWORD_LABEL);
        REGISTER_CONTENT_PANE.add(PASSWORD_CONFIRMATION_LABEL);
        REGISTER_CONTENT_PANE.add(USERNAME_TEXT_FIELD);
        REGISTER_CONTENT_PANE.add(PASSWORD_FIELD);
        REGISTER_CONTENT_PANE.add(PASSWORD_CONFIRMATION_FIELD);
        REGISTER_CONTENT_PANE.add(REGISTER_BUTTON);
        REGISTER_CONTENT_PANE.add(BACK_BUTTON);
        REGISTER_CONTENT_PANE.add(SHOW_PASSWORD_BUTTON);
        REGISTER_CONTENT_PANE.add(SHOW_PASSWORD_CONFIRMATION_BUTTON);
    }

    /**
     * Adds the different events to the ActionListener.
     */
    public void addActionEvent() {
        REGISTER_BUTTON.addActionListener(this);
        BACK_BUTTON.addActionListener(this);
        SHOW_PASSWORD_BUTTON.addActionListener(this);
        SHOW_PASSWORD_CONFIRMATION_BUTTON.addActionListener(this);
    }

    /**
     * Sends a request with given information.
     *
     * @param username a String with username.
     * @param password a String with password.
     */
    public void callRequest(final String username, final String password) {
        RegisterRequestForm registerRequestForm = new RegisterRequestForm();
        registerRequestForm.addUsername(username);
        registerRequestForm.addPassword(password);
        try {
            PaoPaoResponse result = CLIENT_REQUEST.executeRequestWithoutToken(registerRequestForm);
            if ("200".equals(result.getStatus())) {
                JOptionPane.showMessageDialog(this, "Register successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the actions performed on the components.
     *
     * @param e an action event.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == REGISTER_BUTTON) {
            String username = USERNAME_TEXT_FIELD.getText();
            String password = String.copyValueOf(PASSWORD_FIELD.getPassword());
            String passwordConfirmation = String.copyValueOf(PASSWORD_CONFIRMATION_FIELD.getPassword());
            if (password.equals(passwordConfirmation)) {
                callRequest(username, password);
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            }
            USERNAME_TEXT_FIELD.setText("");
            PASSWORD_FIELD.setText("");
            PASSWORD_CONFIRMATION_FIELD.setText("");
        }
        if (e.getSource() == BACK_BUTTON) {
            this.dispose();
            new LoginInterface();
        }
        if (e.getSource() == SHOW_PASSWORD_BUTTON) {
            showOrHidePassword(PASSWORD_FIELD, passwordShowStatus);
            passwordShowStatus = !passwordShowStatus;
        }
        if (e.getSource() == SHOW_PASSWORD_CONFIRMATION_BUTTON) {
            showOrHidePassword(PASSWORD_CONFIRMATION_FIELD, passwordConfirmationShowStatus);
            passwordConfirmationShowStatus = !passwordConfirmationShowStatus;
        }
    }

    /**
     * Shows or Hides a JPasswordField depending on its status.
     *
     * @param jPasswordField the field to change.
     * @param status a boolean with current status.
     */
    public void showOrHidePassword(final JPasswordField jPasswordField, final boolean status) {
        if (status) {
            jPasswordField.setEchoChar((char) 0);
        } else {
            jPasswordField.setEchoChar('*');
        }
    }
}
