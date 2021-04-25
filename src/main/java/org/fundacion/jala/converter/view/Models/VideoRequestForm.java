/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Edson Añawaya Rios
 */
package org.fundacion.jala.converter.view.Models;

import java.util.ArrayList;
import java.util.List;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class shows the Video's form.
 */
public class VideoRequestForm implements IRequestForm {
    private List<Parameter> bodyParameters = new ArrayList<>();
    private final String URL = dotenv.get("HTTP_URL_CONVERT_VIDEO");
    private final String FILE = "file";
    private final String OUTPUT_FORMAT = "outputformat";
    private final String RESOLUTION = "resolution";
    private final String THUMBNAIL = "thumbnail";
    private final String FRAME_RATE = "framerate";
    private final String WIDTH = "width";
    private final String HEIGHT = "height";
    private final String AUDIO = "audio";
    private final String METADATA = "metadata";
    private final String CHECKSUM = "checksum";

    /**
     * Video Request Form stores parameters for an video request
     */
    public VideoRequestForm() {
    }

    /**
     * Adds filepath parameter.
     *
     * @param filepathValue String with file's path.
     */
    public void addFilepath(final String filepathValue) {
        addParameters(new Parameter(FILE, filepathValue, true));
    }

    /**
     * Adds outputFormat parameter.
     *
     * @param outputFormatValue String with outputs format.
     */
    public void addOutputFormat(final String outputFormatValue) {
        addParameters(new Parameter(OUTPUT_FORMAT, outputFormatValue, false));
    }

    /**
     * Adds resolution parameter.
     *
     * @param resolutionValue String with resolution value.
     */
    public void addResolution(final String resolutionValue) {
        addParameters(new Parameter(RESOLUTION, resolutionValue, false));
    }
    /**
     * Adds checksum parameter.
     *
     * @param checksumValue String with checksum value.
     */
    public void addChecksum(final String checksumValue) {
        addParameters(new Parameter(CHECKSUM, checksumValue, false));
    }

    /**
     * Adds thumbnail parameter.
     *
     * @param thumbnailValue String with thumbnail value.
     */
    public void addThumbnail(final String thumbnailValue) {
        addParameters(new Parameter(THUMBNAIL, thumbnailValue, false));
    }

    /**
     * Adds frameRate parameter.
     *
     * @param frameRateValue String with frameRate value.
     */
    public void addFrameRate(final String frameRateValue) {
        addParameters(new Parameter(FRAME_RATE, frameRateValue, false));
    }

    /**
     * Adds width parameter.
     *
     * @param widthValue String with width value.
     */
    public void addWidth(final String widthValue) {
        addParameters(new Parameter(WIDTH, widthValue, false));
    }

    /**
     * Adds height parameter.
     *
     * @param heightValue String with height value.
     */
    public void addHeight(final String heightValue) {
        addParameters(new Parameter(HEIGHT, heightValue, false));
    }

    /**
     * Adds audio parameter.
     *
     * @param audioValue String with audio value.
     */
    public void addAudio(final String audioValue) {
        addParameters(new Parameter(AUDIO, audioValue, false));
    }
    /**
     * Adds metadata parameter.
     *
     * @param metadataValue String with metadata value.
     */
    public void addMetadata(final String metadataValue) {
        addParameters(new Parameter(METADATA, metadataValue, false));
    }
    /**
     * Gets the body parameters.
     *
     * @return a List<Parameter> with video's Parameters.
     */
    @Override
    public List<Parameter> getBodyParameters() {
        return bodyParameters;
    }

    /**
     * Adds parameters to bodyParameters.
     *
     * @param parameter Object Parameter.
     */
    @Override
    public void addParameters(final Parameter parameter) {
        bodyParameters.add(parameter);
    }

    /**
     * Gets the url.
     *
     * @return a String with endpoint's url.
     */
    @Override
    public String getURL() {
        return URL;
    }
}
