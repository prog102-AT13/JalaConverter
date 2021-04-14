/**
 * Copyright (c) 2021 Fundacion Jala.
 * 
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.view.converter;

public class ResolutionVideo {
    private int width;
    private int height;
    private String name;

    ResolutionVideo(String name, int width, int height) {
        this.height = height;
        this.width = width;
        this.name = name;
    }

    /**
     * Get width of video.
     *
     * @return width of video.
     */
    public int getWidth() {
        return width;
    }

    /**
     * set width of video.
     *
     * @param width of video.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get height of video.
     *
     * @return height of video.
     */
    public int getHeight() {
        return height;
    }

    /**
     * set height of video.
     *
     * @param height of video.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get name to shown in combBox.
     *
     * @return name to shown in combBox.
     */
    public String getName() {
        return name;
    }

    /**
     * set name to shown in combBox..
     *
     * @param name to shown in combBox..
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get full name to shown in combBox.
     *
     * @return full name to shown in combBox.
     */
    @Override
    public String toString() {
        return width + "X" + height + "     " + name;
    }
}
