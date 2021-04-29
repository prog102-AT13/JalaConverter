/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Aguilar Quiñones
 */
package org.fundacion.jala.converter.view;

import org.fundacion.jala.converter.view.compiler.CompilerInterface;
import org.fundacion.jala.converter.view.converter.AudioConverterInterface;
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
    private CompilerInterface compilerPanel;
    private VideoConverterInterface videoPanel;
    private MetaDataInterface metaDataPanel;
    private AudioConverterInterface audioPanel;
    private TextExtractorInterface textExtractorPanel;
    private BtnStyle compilerBtn;
    private BtnStyle videoConverterBtn;
    private BtnStyle audioConverterBtn;
    private BtnStyle textExtractorBtn;
    private BtnStyle metaDataBtn;
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
        mainPanel = new JLayeredPane();
        mainPanel.setLayout(new CardLayout());
        mainPanel.setBorder(MARGIN_SPACE);
        mainPanel.add(compilerPanel);
        compilerBtn = new BtnStyle("Compiler", "MainIconCompiler.png");
        videoConverterBtn = new BtnStyle("Video converter", "MainIconVideo.png");
        audioConverterBtn = new BtnStyle("Audio converter", "MainIconAudio.png");
        textExtractorBtn = new BtnStyle("Text extractor", "MainIconText.png");
        metaDataBtn = new BtnStyle("Metadata extractor", "MainIconMeta.png");
        mainButtonAction(compilerBtn);
        mainButtonAction(videoConverterBtn);
        mainButtonAction(audioConverterBtn);
        mainButtonAction(textExtractorBtn);
        mainButtonAction(metaDataBtn);
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
    }

    /**
     * Sets positions for FlowLayout.
     */
    public void setPosition(JPanel mainPanel, BtnStyle mainBtn, boolean lastBtn) {
        GridBagConstraints positionConstraint = new GridBagConstraints();
        positionConstraint.gridx = positionXMainBtn;
        positionConstraint.gridy = positionYMainBtn;
        positionConstraint.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(mainBtn, positionConstraint);
        if (lastBtn) {
            positionConstraint.gridy = 10;
            positionConstraint.gridwidth = GridBagConstraints.REMAINDER;
            positionConstraint.weighty = 1;
            mainPanel.add(new JLabel(), positionConstraint);
        }
        positionYMainBtn += 1;
    }

    /**
     * Sets the correct panel according to selected Button.
     */
    public void switchPanels(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * Call the panel for the Button option.
     *
     * @param e Action of selected JButton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compilerBtn) {
            switchPanels(compilerPanel);
        }
        if (e.getSource() == videoConverterBtn) {
            switchPanels(videoPanel);
        }
        if (e.getSource() == audioConverterBtn) {
            switchPanels(audioPanel);
        }
        if (e.getSource() == textExtractorBtn) {
            switchPanels(textExtractorPanel);
        }
        if (e.getSource() == metaDataBtn) {
            switchPanels(metaDataPanel);
        }
    }

    /**
     * Adds the style hover and out for JButton.
     *
     * @param button to add style.
     */
    public BtnStyle mainButtonAction(BtnStyle button) {
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Component c = e.getComponent();
                c.setBackground(OVER_BACKGROUND_BTN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Component c = e.getComponent();
                c.setBackground(DARK_BACKGROUND_BTN);
            }
        };
        button.addActionListener(this::actionPerformed);
        button.addMouseListener(ml);
        return button;
    }
}

