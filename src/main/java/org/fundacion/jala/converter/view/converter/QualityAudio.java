/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Daniela Santa Cruz Andrade
 */
package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.util.Hashtable;

/**
 * This class defines the interface for quality of audio.
 */
class QualityAudio extends JPanel implements ChangeListener {
    private JSlider qualitySlider;
    private String qualityAudio;
    private final int qualitySliderMin = 64;
    private final int qualitySliderMax = 320;
    private final int qualitySliderValue = 64;
    private final int topBorder = 0;
    private final int leftBorder = 0;
    private final int bottomBorder = 100;
    private final int rightBorder = 70;
    private final int qualitySliderMajorTickSpacing = 128;
    private final int qualitySliderMinorTickSpacing = 64;

    protected QualityAudio() {
        JLabelStyle sliderTitle = new JLabelStyle("Select quality: ", "h2");
        sliderTitle.setAlignmentX(LEFT_ALIGNMENT);
        qualitySlider = new JSlider(JSlider.HORIZONTAL, qualitySliderMin, qualitySliderMax, qualitySliderValue);
        qualitySlider.setPaintTrack(true);
        qualitySlider.setPaintTicks(true);
        qualitySlider.setPaintTicks(true);
        qualitySlider.setPaintLabels(true);
        qualitySlider.setMajorTickSpacing(qualitySliderMajorTickSpacing);
        qualitySlider.setMinorTickSpacing(qualitySliderMinorTickSpacing);
        qualitySlider.addChangeListener(this::stateChanged);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(topBorder, leftBorder, bottomBorder, rightBorder));
        add(sliderTitle);
        add(qualitySlider);
    }

    /**
     * Changes the audio's quality state.
     *
     * @param e a ChangeEvent.
     */
    @Override
    public void stateChanged(final ChangeEvent e) {
        this.qualityAudio = qualitySlider.getValue() + " kbps";
    }

    /**
     * Gets the audio's quality.
     *
     * @return a String with the qualityAudio.
     */
    public String getQualityAudio() {
        return qualityAudio;
    }
}
