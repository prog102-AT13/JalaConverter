/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.view.converter;

public class FrameVideo {
    private String name = "F";
    private int frame;

    public FrameVideo(int frame) {
        this.name = name;
        this.frame = frame;
    }

    /**
     * Get frame select of video.
     *
     * @return name of frame.
     */
    public String getName() {
        return name;
    }

    /**
     * set frame select of video.
     *
     * @param name is select options.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get frame select of video.
     *
     * @return frame is value select options.
     */
    public int getFrame() {
        return frame;
    }

    /**
     * set value frame select of video.
     *
     * @param frame is value select options.
     */
    public void setFrame(final int frame) {
        this.frame = frame;
    }

    /**
     * Get string select of combBox.
     *
     * @return string is value displayed in combBox.
     */
    @Override
    public String toString() {
        return frame + name;
    }
}
