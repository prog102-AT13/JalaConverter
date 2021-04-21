/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

/**
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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.*;

public class MainInterface extends JFrame {
    private ImageIcon compilerIcon;
    private ImageIcon converterIcon;
    private CompilerInterface compilerJP;
    private JPanel converterJP;
    private JLabelStyle titleTxt;
    private VideoConverterInterface video;
    private MetaDataInterface metaData;
    private AudioConverterInterface audio;
    private TextExtractorInterface textExtractor;
    private final int alignLabelStyle = 0;
    private final int widthLabelStyle = 0;
    private final int heightLabelStyle = 90;
    private final int witdh = 800;
    private final int height = 700;
    private final int fontStyle = 0;
    private final int fontSize = 12;
    private String token;

    /**
     * Initializes all the graphics components in the main Frame
     */
    public void initInterface(final String newToken) {
        token = newToken;
        compilerJP = new CompilerInterface(token);
        video = new VideoConverterInterface(token);
        converterJP = new JPanel();
        titleTxt = new JLabelStyle("Jala Converter Project v1.0", "h2",
                alignLabelStyle, widthLabelStyle, heightLabelStyle);
        metaData = new MetaDataInterface(token);
        audio = new AudioConverterInterface(token);
        textExtractor = new TextExtractorInterface(token);
        JTabbedPane mainTabPanel = new JTabbedPane();
        mainTabPanel.setFont(new Font("Barlow", fontStyle, fontSize));
        mainTabPanel.add("Compiler", compilerJP);
        mainTabPanel.add("Video Converter", video);
        mainTabPanel.add("Audio Converter", audio);
        mainTabPanel.add("Meta Data", metaData);
        mainTabPanel.add("Text Extractor", textExtractor);
        setLayout(new BorderLayout());
        add(titleTxt.getTextLabel(), BorderLayout.NORTH);
        add(mainTabPanel, BorderLayout.CENTER);
        setSize(witdh, height);
        setTitle("Prog102 - Final Project");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
