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
package org.fundacion.jala.converter.view;

import org.fundacion.jala.converter.view.compiler.CompilerInterface;
import org.fundacion.jala.converter.view.converter.AudioConverterInterface;
import org.fundacion.jala.converter.view.converter.ImageConverterInterface;
import org.fundacion.jala.converter.view.converter.VideoConverterInterface;
import org.fundacion.jala.converter.view.metadata.MetaDataInterface;
import org.fundacion.jala.converter.view.text_extractor.TextExtractorInterface;
import org.fundacion.jala.converter.view.utilities.BtnStyle;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class defines the Main Interface for the project.
 */
public class MainInterface extends JFrame implements ActionListener {
    private final JLabelStyle TITLE_APP = new JLabelStyle("PaoPao's Application", "h1");
    private final JLabelStyle COPYRIGHT = new JLabelStyle("© Copyright AT13 - 2021", "h5");
    private final Color DARK_BACKGROUND_BTN = new Color(28, 28, 28);
    private final Color OVER_BACKGROUND_BTN = new Color(48, 48, 48);
    private final EmptyBorder MARGIN_SPACE = new EmptyBorder(20, 10, 15, 10);
    private final int APP_WIDTH = 1000;
    private final int APP_HEIGHT = 820;
    private final int BTN_TYPE_MAIN = 1;
    private final int NUMBER_TEN = 10;
    private CompilerInterface compilerPanel;
    private VideoConverterInterface videoPanel;
    private MetaDataInterface metaDataPanel;
    private AudioConverterInterface audioPanel;
    private TextExtractorInterface textExtractorPanel;
    private ImageConverterInterface imagePanel;
    private BtnStyle compilerBtn;
    private BtnStyle videoConverterBtn;
    private BtnStyle audioConverterBtn;
    private BtnStyle textExtractorBtn;
    private BtnStyle metaDataBtn;
    private BtnStyle imageConverterBtn;
    private int positionXMainBtn = 0;
    private int positionYMainBtn = 0;
    private JLayeredPane mainPanel;
    private String token;
    private JPanel containerPanel;
    private JPanel buttonsPanel;

    /**
     * Initializes all the graphic components in the main Frame.
     *
     * @param newToken String with the user's token.
     */
    public void initInterface(final String newToken) {
        token = newToken;
        setComponents();
        setPanels();
        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);
        setSize(APP_WIDTH, APP_HEIGHT);
        setMinimumSize(new Dimension(APP_WIDTH, APP_HEIGHT));
        setTitle("Prog102 - PaoPao Application");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Sets all components format for Main frame.
     */
    public void setComponents() {
        compilerPanel = new CompilerInterface(token);
        videoPanel = new VideoConverterInterface(token);
        audioPanel = new AudioConverterInterface(token);
        metaDataPanel = new MetaDataInterface(token);
        textExtractorPanel = new TextExtractorInterface(token);
        imagePanel = new ImageConverterInterface(token);
        mainPanel = new JLayeredPane();
        mainPanel.setLayout(new CardLayout());
        mainPanel.setBorder(MARGIN_SPACE);
        mainPanel.add(compilerPanel);
        compilerBtn = new BtnStyle("Compiler", "MainIconCompiler.png", BTN_TYPE_MAIN);
        videoConverterBtn = new BtnStyle("Video converter", "MainIconVideo.png", BTN_TYPE_MAIN);
        audioConverterBtn = new BtnStyle("Audio converter", "MainIconAudio.png", BTN_TYPE_MAIN);
        textExtractorBtn = new BtnStyle("Text extractor", "MainIconText.png", BTN_TYPE_MAIN);
        metaDataBtn = new BtnStyle("Metadata extractor", "MainIconMeta.png", BTN_TYPE_MAIN);
        imageConverterBtn = new BtnStyle("Image converter", "MainIconImage.png", BTN_TYPE_MAIN);
        mainButtonAction(compilerBtn);
        mainButtonAction(videoConverterBtn);
        mainButtonAction(audioConverterBtn);
        mainButtonAction(textExtractorBtn);
        mainButtonAction(metaDataBtn);
        mainButtonAction(imageConverterBtn);
    }

    /**
     * Sets Panels and positions for elements in Main frame.
     */
    public void setPanels() {
        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBorder(MARGIN_SPACE);
        containerPanel.add(TITLE_APP, BorderLayout.NORTH);
        containerPanel.add(mainPanel, BorderLayout.CENTER);
        containerPanel.add(COPYRIGHT, BorderLayout.SOUTH);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBackground(DARK_BACKGROUND_BTN);
        setPosition(buttonsPanel, compilerBtn, false);
        setPosition(buttonsPanel, videoConverterBtn, false);
        setPosition(buttonsPanel, audioConverterBtn, false);
        setPosition(buttonsPanel, textExtractorBtn, false);
        setPosition(buttonsPanel, metaDataBtn, true);
        setPosition(buttonsPanel, imageConverterBtn, true);
    }

    /**
     * Sets positions for FlowLayout.
     */
    public void setPosition(final JPanel mainPanel, final BtnStyle mainBtn, final boolean lastBtn) {
        GridBagConstraints positionConstraint = new GridBagConstraints();
        positionConstraint.gridx = positionXMainBtn;
        positionConstraint.gridy = positionYMainBtn;
        positionConstraint.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(mainBtn, positionConstraint);
        if (lastBtn) {
            positionConstraint.gridy = NUMBER_TEN;
            positionConstraint.gridwidth = GridBagConstraints.REMAINDER;
            positionConstraint.weighty = 1;
            mainPanel.add(new JLabel(), positionConstraint);
        }
        positionYMainBtn += 1;
    }

    /**
     * Sets the correct panel according to selected Button.
     */
    public void switchPanels(final JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * Calls the panel for the Button option.
     *
     * @param buttonEvent Action of selected JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent buttonEvent) {
        if (buttonEvent.getSource() == compilerBtn) {
            switchPanels(compilerPanel);
        }
        if (buttonEvent.getSource() == videoConverterBtn) {
            switchPanels(videoPanel);
        }
        if (buttonEvent.getSource() == audioConverterBtn) {
            switchPanels(audioPanel);
        }
        if (buttonEvent.getSource() == textExtractorBtn) {
            switchPanels(textExtractorPanel);
        }
        if (buttonEvent.getSource() == metaDataBtn) {
            switchPanels(metaDataPanel);
        }
        if (buttonEvent.getSource() == imageConverterBtn) {
            switchPanels(imagePanel);
        }
    }

    /**
     * Adds the style hover and out for JButton.
     *
     * @param button to add style.
     */
    public BtnStyle mainButtonAction(final BtnStyle button) {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent eventListener) {
                Component btnComponent = eventListener.getComponent();
                btnComponent.setBackground(OVER_BACKGROUND_BTN);
            }

            @Override
            public void mouseExited(final MouseEvent eventListener) {
                Component btnComponent = eventListener.getComponent();
                btnComponent.setBackground(DARK_BACKGROUND_BTN);
            }
        };
        button.addActionListener(this::actionPerformed);
        button.addMouseListener(mouseListener);
        return button;
    }
}
