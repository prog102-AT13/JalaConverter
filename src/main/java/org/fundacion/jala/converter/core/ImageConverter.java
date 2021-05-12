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
package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.ConverterException;
import org.fundacion.jala.converter.core.parameter.ImageParameter;
import org.fundacion.jala.converter.core.results.Result;

/**
 * This class converts a image to an specified format.
 */
public class ImageConverter {
    private String startFirstCommand = "ffmpeg -i ";
    private ImageParameter parameter;
    private String format;
    private String output;
    private String pathOutput;
    private String outputFileName;
    private final int HIGH_LIMIT = 1000;
    private Result result;
    private RunCommand runCommand = new RunCommand();

    public ImageConverter(final ImageParameter imageParameter) {
        this.parameter = imageParameter;
    }

    /**
     * Converts the input image.
     */
    public void convertImage() {
        String adaptPath = "\"" + parameter.getFilePath() + "\"";
        format = parameter.getOutputFormat();
        output = adaptPath.substring((adaptPath.lastIndexOf(System.getProperty("file.separator")) + 1), adaptPath.lastIndexOf(".") + 1) + format;
        setOutputFileName(output);
        pathOutput = adaptPath.substring(0, (adaptPath.lastIndexOf("archive"))) + "archive" + System.getProperty("file.separator");
        String ffmpegCommand = startFirstCommand + adaptPath + " ";
        String parameters = changeSize() + grayScale() + "\" ";
        String theCommand = ffmpegCommand + parameters + pathOutput + output  + "\" -y";
        runCommand.run(theCommand);
        result = new Result();
        result.setFilename(outputFileName);
    }

    /**
     * Changes the resolution and aspect ratio of the input image.
     *
     * @return a String with the resolution command.
     */
    private String changeSize() {
        int width = parameter.getWidth();
        String resolutionCommand;
        if (width > 0 && width < HIGH_LIMIT) {
            resolutionCommand = " -vf \"scale=" + width + ":-1";
            return resolutionCommand;
        }
        return "";
    }

    /**
     * Removes the audio of the input image.
     *
     * @return a String with the grayScale command.
     */
    private String grayScale() {
        boolean grayScale = parameter.hasGrayScale();
        String grayScaleCommand;
        if (grayScale) {
            grayScaleCommand = ",format=gray";
            return grayScaleCommand;
        }
        return "";
    }

    /**
     * Sets the output file name.
     *
     * @param newOutputFileName String with the output file name.
     */
    public void setOutputFileName(final String newOutputFileName) {
        this.outputFileName = newOutputFileName;
    }

    /**
     * Gets the output file name.
     *
     * @return a String with the outputFileName.
     */
    public String getOutputFileName() {
        return outputFileName;
    }

    /**
     * Returns the object result for the operation.
     *
     * @return extractorResult.
     */
    public Result getResult() {
        return result;
    }
}
