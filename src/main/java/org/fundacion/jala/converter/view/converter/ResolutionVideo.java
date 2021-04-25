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

/**
 * This class defines the interface for resolution of video.
 */
public class ResolutionVideo {
    private String width;
    private String height;
    private String name;

    ResolutionVideo(final String newName, final String newWidth, final String newHeight) {
        this.height = newHeight;
        this.width = newWidth;
        this.name = newName;
    }

    /**
     * Gets width of video.
     *
     * @return a width of video.
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets width of video.
     *
     * @param newWidth of video.
     */
    public void setWidth(final String newWidth) {
        this.width = newWidth;
    }

    /**
     * Gets height of video.
     *
     * @return a height of video.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets height of video.
     *
     * @param newHeight of video.
     */
    public void setHeight(final String newHeight) {
        this.height = newHeight;
    }

    /**
     * Gets name to shown in combBox.
     *
     * @return a name to shown in combBox.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name to shown in combBox.
     *
     * @param newName to shown in combBox.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets full name to shown in combBox.
     *
     * @return a String with the full name to shown in combBox.
     */
    @Override
    public String toString() {
        String spaces = addSpaces(numberSpaces(name));
        return name + spaces + width + "x" + height;
    }

    /**
     * Adds space depending for length of name.
     *
     * @param nameLength of name.
     * @return an int with the long necessary for blank spaces.
     */
    public int numberSpaces(final String nameLength) {
        final int spacesFor720 = 59;
        final int spacesFor1920 = 66;
        final int spacesFor480 = 69;
        final int spacesFor240 = 69;
        final int spacesForDVD = 70;
        final int spacesForTV = 74;
        final int spacesForMobile = 67;
        switch (nameLength) {
            case "720p(HD)":
                return spacesFor720;
            case "1920p":
                return spacesFor1920;
            case "480p":
                return spacesFor480;
            case "240p":
                return spacesFor240;
            case "DVD":
                return spacesForDVD;
            case "TV":
                return spacesForTV;
            case "Mobile":
                return spacesForMobile;
            default:
                return 0;
        }
    }

    /**
     * Adds blank spaces.
     *
     * @param numberSpaces int with number of spaces .
     * @return a String with necessary spaces.
     */
    public String addSpaces(final int numberSpaces) {
        String spaces = "";
        for (int i = 0; i < numberSpaces; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
