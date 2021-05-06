/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Zacarias Huanca Alconz
 */
package org.fundacion.jala.converter.view.converter;

public class FrameVideo {
    private String name = "F";
    private String frame;

    public FrameVideo(final String newFrame) {
        this.frame = newFrame;
    }

    /**
     * Gets the name select of video.
     *
     * @return a String with the name of frame.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets selected video's name.
     *
     * @param newName is select options.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets frame select of video.
     *
     * @return a String with the video frame.
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Sets value frame select of video.
     *
     * @param newFrame is value select options.
     */
    public void setFrame(final String newFrame) {
        this.frame = newFrame;
    }

    /**
     * Gets the selected String form the comboBox.
     *
     * @return a String with the displayed value on the comboBox.
     */
    @Override
    public String toString() {
        return frame + name;
    }
}
