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
    private DownloadLinkFacade(){}

    /**
     *  Generator link to download to convert.
     *
     * @param outputFilename is path of file which are converted.
     * @return path which permit download the result process.
     */
    public static String getLinkConverter(final String outputFilename){
        String nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return  baseUrl + "/api/download/" + nameWithoutExtension + "zip";
    }

    /**
     *  Generator link to download.
     *
     * @param outputFileName is path of file which are extracted text.
     * @return path which permit download the result process.
     */
    public static String getLinkExtractText(final String outputFileName){
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String outFilename = outputFileName + ".txt";
        String downloadLink = baseUrl + "/api/download/" + outFilename;
        return downloadLink;
    }
}

