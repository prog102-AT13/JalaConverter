/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.converter;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.checkerframework.checker.units.qual.C;
import org.fundacion.jala.converter.view.Controller.ClientRequest;
import org.fundacion.jala.converter.view.Models.AudioRequestForm;
import org.fundacion.jala.converter.view.utilities.JLabelStyle;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AudioConverterInterface extends JPanel implements ActionListener {
    private SelectFile file;
    private ConvertTypeSelectAudio audioSelect;
    private QualityAudio quality;
    private OutputSettingsAudio settings;
    private ClientRequest clientRequest = new ClientRequest();

    /**
     * Initialize of graphics elements for Audio converter interface.
     */
    public AudioConverterInterface() {
        JLabelStyle audioTitle = new JLabelStyle("Audio converter", "h1", 2, 70, 30);
        JLabelStyle audioSettings = new JLabelStyle("Audio settings", "h1", 2, 70, 30);
        audioTitle.setAlignmentX(LEFT_ALIGNMENT);
        audioSettings.setAlignmentX(LEFT_ALIGNMENT);
        JButton convertAudio = new JButton("Convert");
        convertAudio.setAlignmentX(LEFT_ALIGNMENT);
        convertAudio.setFont(new Font("Barlow", 0, 12));
        convertAudio.addActionListener(this::actionPerformed);
        file = new SelectFile();
        file.setAlignmentX(LEFT_ALIGNMENT);
        audioSelect = new ConvertTypeSelectAudio();
        audioSelect.setAlignmentX(LEFT_ALIGNMENT);
        quality = new QualityAudio();
        quality.setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(40, 40, 100, 0));
        settings = new OutputSettingsAudio();
        settings.setAlignmentX(LEFT_ALIGNMENT);
        add(audioTitle.getTextLabel());
        add(file);
        add(audioSettings.getTextLabel());
        add(audioSelect);
        add(quality);
        add(settings);
        add(convertAudio);
    }

    /**
     * Action of JButton convert, send information for metadataCLASS conversion.
     * Show a Dialog with the information.
     * @param e event of the JButton.
     */
    @Override
    public void actionPerformed(final ActionEvent e)  {
        JOptionPane.showMessageDialog(this, "File Path: "
                + file.getOriginFilePath()
                + "\nConvert to: "
                + audioSelect.getConvertTo()
                + "\nQuality: "
                + quality.getQualityAudio()
                + "\nVolume: "
                + settings.getVolume()
                + "\nAudio Channel: "
                + settings.getAudioChannel()
                + "\nHz: "
                + settings.getHz()
                + "\nwith metadata: "
                + settings.isMetadata());
        try {
            callRequest();
        } catch (Exception r) {

        }

    }
    private void callRequest() throws IOException{
        String storagePath=file.getOriginFilePath();
        String format=audioSelect.getConvertTo();
        String[] s=quality.getQualityAudio().split(" ");
        String bitrate=s[0];
        String volume=settings.getVolume();
        String hz=settings.getHz();
        String audiochannel = settings.getAudioChannel();
        boolean metadata = settings.isMetadata();
        AudioRequestForm audioRequestForm=new AudioRequestForm();
        audioRequestForm.addFilepath(storagePath);
        audioRequestForm.addFormat(format);
        audioRequestForm.addBitrate(bitrate);
        audioRequestForm.addVolume(volume);
        audioRequestForm.addHz(hz);
        audioRequestForm.addAudiochannel(audiochannel);
        audioRequestForm.addMetadata(String.valueOf(metadata));

        clientRequest.executeRequest(audioRequestForm);
        try {
            String result= clientRequest.executeRequest(audioRequestForm);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
