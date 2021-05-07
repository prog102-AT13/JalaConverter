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
package org.fundacion.jala.converter.core.facade;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.fundacion.jala.converter.core.parameter.Utils.cleanFileNameParameter;

/**
 * Class to do link to download.
 */
public class DownloadLinkFacade {
    private static String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

    private DownloadLinkFacade() {
    }

    /**
     *  Generators link to download to convert.
     *
     * @param outputFilename is path of file which are converted.
     * @returna a String of path which permit download the result process.
     */
    public static String getLinkConverter(final String outputFilename) {
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        return baseUrl + "/api/download/" + nameWithoutExtension + "zip";
    }

    /**
     *  Generators link to download.
     *
     * @param file is path of file which are extracted text.
     * @return a String of path which permit download the result process.
     */
    public static String getLinkExtractText(final MultipartFile file) {
        String fileOut = file.getOriginalFilename();
        String outputFileName = fileOut.substring(0, fileOut.lastIndexOf("."));
        String filenameWithoutSpaces = cleanFileNameParameter(outputFileName);
        return baseUrl + "/api/download/" + filenameWithoutSpaces + ".txt";
    }

    /**
     * Gets the metadata link.
     *
     * @param filename is name of file which are extracted metadata.
     * @param format is format which the result process do.
     * @return a String of path which permit download the result process.
     */
    public static String getLinkMetadata(final String filename, final String format) {
        String filenameWithoutSpaces = cleanFileNameParameter(filename);
        return baseUrl + "/api/download/" + filenameWithoutSpaces + "." + format;
    }
}
