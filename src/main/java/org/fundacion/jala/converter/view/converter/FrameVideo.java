/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Gustavo Huanca
 */
package org.fundacion.jala.converter.view.converter;

public class FrameVideo {
    private String name = "F";
    private String frame;

    public FrameVideo(final String newFrame) {
        this.name = name;
        this.frame = newFrame;
    }

    /**
     * Gets frame select of video.
     *
     * @return a String with teh name of frame.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets frame select of video.
     *
     * @param newName is select options.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets frame select of video.
     *
     * @return a String with frame is value select options.
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
     * Gets string select of comboBox.
     *
     * @return a String is value displayed in comboBox.
     */
    @Override
    public String toString() {
        return frame + name;
    }
}
