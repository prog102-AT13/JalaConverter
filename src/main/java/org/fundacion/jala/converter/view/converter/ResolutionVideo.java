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

    ResolutionVideo(final String newName, final int newWidth, final int newHeight) {
        this.height = newHeight;
        this.width = newWidth;
        this.name = newName;
    }

    /**
     * Gets width of video.
     * @return width of video.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width of video.
     * @param newWidth of video.
     */
    public void setWidth(final int newWidth) {
        this.width = newWidth;
    }

    /**
     * Gets height of video.
     * @return height of video.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height of video.
     * @param newHeight of video.
     */
    public void setHeight(final int newHeight) {
        this.height = newHeight;
    }

    /**
     * Gets name to shown in combBox.
     * @return name to shown in combBox.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name to shown in combBox.
     * @param newName to shown in combBox.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets full name to shown in combBox.
     * @return full name to shown in combBox.
     */
    @Override
    public String toString() {
        return width + "X" + height + "     " + name;
    }
}
