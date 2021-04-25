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
package org.fundacion.jala.converter.models.facade;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Class to do link to download.
 */
public class DownloadLinkFacade {
    private DownloadLinkFacade() {
    }

    private static String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

    /**
     *  Generator link to download to convert.
     *
     * @param outputFilename is path of file which are converted.
     * @return path which permit download the result process.
     */
    public static String getLinkConverter(final String outputFilename) {
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        return baseUrl + "/api/download/" + nameWithoutExtension + "zip";
    }

    /**
     *  Generator link to download.
     *
     * @param outputFileName is path of file which are extracted text.
     * @return path which permit download the result process.
     */
    public static String getLinkExtractText(final String outputFileName) {
        return baseUrl + "/api/download/" + outputFileName + ".txt";
    }

    /**
     *
     * @param filename is name of file which are extracted metadata.
     * @param format is format which the result process do.
     * @return path which permit download the result process.
     */
    public static String getLinkMetadata(final String filename, final String format) {
        return baseUrl + "/api/download/" + filename + "." + format;
    }
}

