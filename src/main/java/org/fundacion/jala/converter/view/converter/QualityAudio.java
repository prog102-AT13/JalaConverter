package org.fundacion.jala.converter.view.converter;

import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

class QualityAudio extends JPanel implements ChangeListener {
    private JSlider qualitySlider;
    private String qualityAudio;

    public QualityAudio() {
        JLabelStyle sliderTitle = new JLabelStyle("Select quality: ","h2", 2, 70, 30);
        sliderTitle.setAlignmentX(LEFT_ALIGNMENT);
        qualitySlider = new JSlider(JSlider.HORIZONTAL, 64, 320, 64);
        qualitySlider.setPaintTrack(true);
        qualitySlider.setPaintTicks(true);
        qualitySlider.setPaintTicks(true);
        qualitySlider.setPaintLabels(true);
        qualitySlider.setMajorTickSpacing(128);
        qualitySlider.setMinorTickSpacing(64);
        qualitySlider.addChangeListener(this::stateChanged);
        Hashtable positionJSlide = new Hashtable();
        JLabel labelSlide = new JLabel();
        labelSlide.setFont(new Font("Barlow", 0, 11));
        positionJSlide.put(64, new JLabel("64"));
        positionJSlide.put(128, new JLabel("128"));
        positionJSlide.put(192, new JLabel("192"));
        positionJSlide.put(256, new JLabel("256"));
        positionJSlide.put(320, new JLabel("320"));
        qualitySlider.setLabelTable(positionJSlide);
        qualitySlider.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0, 0, 100, 70));
        add(sliderTitle.getTextLabel());
        add(qualitySlider);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.qualityAudio = qualitySlider.getValue() + " kbps";
    }

    public String getQualityAudio() {
        return qualityAudio;
    }
}
