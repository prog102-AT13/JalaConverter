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
package org.fundacion.jala.converter.core.parameter;

/**
 * This class are the options for the image parameters.
 */
public class ImageParameter extends Parameter {
    private String outputFormat;
    private int width;
    private boolean grayScale;

    public ImageParameter(final String newFilePath, final String newOutputFormat, final int newWidth,
                          final boolean newGrayScale) {
        super(newFilePath);
        this.outputFormat = newOutputFormat;
        this.width = newWidth;
        this.grayScale = newGrayScale;
    }

    /**
     * Sets the name of the output image.
     *
     * @param newOutputFormat is a String with the output format.
     */
    public void setOutputFormat(final String newOutputFormat) {
        this.outputFormat = newOutputFormat;
    }

    /**
     * Sets the width of the output image.
     *
     * @param newWidth is a int with the image width.
     */
    public void setWidth(final int newWidth) {
        this.width = newWidth;
    }

    /**
     * Sets the grayScale of the output image.
     *
     * @param newGrayScale is a boolean that indicates if the image needs grayScale.
     */
    public void setGrayScale(final boolean newGrayScale) {
        this.grayScale = newGrayScale;
    }

    /**
     * Gets the name of the output image.
     *
     * @return output Format of the image file.
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Gets the width of the output image.
     *
     * @return width of the image file.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the image of the output image.
     *
     * @return image of the image file.
     */
    public boolean hasGrayScale() {
        return grayScale;
    }
}
