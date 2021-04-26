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

import org.fundacion.jala.converter.view.converter.AudioConverterInterface;
import org.fundacion.jala.converter.view.text_extractor.TextExtractorInterface;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import org.fundacion.jala.converter.view.compiler.CompilerInterface;
import org.fundacion.jala.converter.view.converter.VideoConverterInterface;
import org.fundacion.jala.converter.view.metadata.MetaDataInterface;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.BorderLayout;

/**
 * This class defines main UI.
 */
public class MainInterface extends JFrame {
    private CompilerInterface compilerJPanel;
    private JLabelStyle titleTxt;
    private VideoConverterInterface video;
    private MetaDataInterface metaData;
    private AudioConverterInterface audio;
    private TextExtractorInterface textExtractor;
    private final int ALIGN_LABEL_STYLE = 0;
    private final int WIDTH_LABEL_STYLE = 0;
    private final int HEIGHT_LABEL_STYLE = 90;
    private final int WITDH = 800;
    private final int HEIGHT = 700;
    private final int FONT_STYLE = 0;
    private final int FONT_SIZE = 12;
    private String token;

    /**
     * Initializes all the graphic components in the main Frame.
     *
     * @param newToken String with the user's token.
     */
    public void initInterface(final String newToken) {
        token = newToken;
        compilerJPanel = new CompilerInterface(token);
        video = new VideoConverterInterface(token);
        titleTxt = new JLabelStyle("Jala Converter Project v1.0", "h2",
                ALIGN_LABEL_STYLE, WIDTH_LABEL_STYLE, HEIGHT_LABEL_STYLE);
        metaData = new MetaDataInterface(token);
        audio = new AudioConverterInterface(token);
        textExtractor = new TextExtractorInterface(token);
        JTabbedPane mainTabPanel = new JTabbedPane();
        mainTabPanel.setFont(new Font("Barlow", FONT_STYLE, FONT_SIZE));
        mainTabPanel.add("Compiler", compilerJPanel);
        mainTabPanel.add("Video Converter", video);
        mainTabPanel.add("Audio Converter", audio);
        mainTabPanel.add("Meta Data", metaData);
        mainTabPanel.add("Text Extractor", textExtractor);
        setLayout(new BorderLayout());
        add(titleTxt.getTextLabel(), BorderLayout.NORTH);
        add(mainTabPanel, BorderLayout.CENTER);
        setSize(WITDH, HEIGHT);
        setTitle("Prog102 - Final Project");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
