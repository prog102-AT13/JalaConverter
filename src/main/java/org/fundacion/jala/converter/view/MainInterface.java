/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
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
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class MainInterface extends JFrame implements ActionListener {
    private CompilerInterface compilerPanel;
    private VideoConverterInterface videoPanel;
    private MetaDataInterface metaDataPanel;
    private AudioConverterInterface audioPanel;
    private TextExtractorInterface textExtractorPanel;

    private JButton compilerBtn;
    private JButton videoConverterBtn;
    private JButton audioConverterBtn;
    private JButton textExtractorBtn;
    private JButton metaDataBtn;

    private int positionXMainBtn = 0;
    private int positionYMainBtn = 0;

    private final Color DARK_BACKGROUND_BTN = new Color(28, 28, 28);
    private final Color OVER_BACKGROUND_BTN = new Color(48, 48, 48);
    private final EmptyBorder MARGIN_SPACE = new EmptyBorder(20, 10, 15, 10);

    private JLayeredPane mainPanel;

    private String token;


    /**
     * Initializes all the graphic components in the main Frame.
     *
     * @param newToken String with the user's token.
     */
    public void initInterface(final String newToken) {
        token = newToken;
        compilerPanel = new CompilerInterface(token);
        videoPanel = new VideoConverterInterface(token);
        audioPanel = new AudioConverterInterface(token);
        metaDataPanel = new MetaDataInterface(token);
        textExtractorPanel = new TextExtractorInterface(token);
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBorder(MARGIN_SPACE);

        mainPanel = new JLayeredPane();
        mainPanel.setLayout(new CardLayout());
        mainPanel.setBorder(MARGIN_SPACE);
        mainPanel.add(compilerPanel);

        JLabel titleApp = new JLabel("PaoPao's Application", SwingConstants.CENTER);
        titleApp.setFont(new Font("Barlow", Font.BOLD, 20));
        titleApp.setForeground(Color.DARK_GRAY);
        containerPanel.add(titleApp, BorderLayout.NORTH);
        containerPanel.add(mainPanel, BorderLayout.CENTER);
        JLabel copyrightAT13 = new JLabel("© Copyright AT13 - 2021", SwingConstants.CENTER);
        copyrightAT13.setFont(new Font("Barlow", Font.PLAIN, 10));
        copyrightAT13.setForeground(Color.DARK_GRAY);
        containerPanel.add(copyrightAT13, BorderLayout.SOUTH);

        compilerBtn = mainButton("Compiler", "MainIconCompiler.png");
        videoConverterBtn = mainButton("Video converter", "MainIconVideo.png");
        audioConverterBtn = mainButton("Audio converter", "MainIconAudio.png");
        textExtractorBtn = mainButton("Text extractor", "MainIconText.png");
        metaDataBtn = mainButton("Metadata extractor", "MainIconMeta.png");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBackground(DARK_BACKGROUND_BTN);
        setPosition(buttonsPanel, compilerBtn, false);
        setPosition(buttonsPanel, videoConverterBtn, false);
        setPosition(buttonsPanel, audioConverterBtn, false);
        setPosition(buttonsPanel, textExtractorBtn, false);
        setPosition(buttonsPanel, metaDataBtn, true);
        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.LINE_START);
        add(containerPanel, BorderLayout.CENTER);
        setSize(1000, 820);
        setMinimumSize(new Dimension(1000, 820));
        setTitle("Prog102 - PaoPao Application");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ImageIcon createImage(String path) {
        return new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getClass().getResource(path));
    }

    public void setPosition(JPanel mainPanel, JButton mainBtn, boolean lastBtn) {
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

    public void switchPanels(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

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

    public JButton mainButton(String btnText, String icon) {
        int marginIcon = 20;
        int widthBtn = 200;
        int heightBtn = 50;

        Icon buttonIcon = new ImageIcon("img/mainButtons/" + icon);

        JButton button = new JButton(btnText);
        button.setIcon(buttonIcon);
        button.setIconTextGap(marginIcon);

        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setHorizontalTextPosition(SwingConstants.RIGHT);

        button.setOpaque(true);
        button.setBackground(DARK_BACKGROUND_BTN);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        Border border = new LineBorder(Color.WHITE, 0);
        button.setBorder(border);
        button.setFont(new Font("Barlow", Font.PLAIN, 13));
        button.setPreferredSize(new Dimension(widthBtn, heightBtn));

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

    private static class RoundedBorder implements Border {

        private int radius = 10;
        private Color color;

        private RoundedBorder(Color color, int radius) {
            this.color = color;
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
