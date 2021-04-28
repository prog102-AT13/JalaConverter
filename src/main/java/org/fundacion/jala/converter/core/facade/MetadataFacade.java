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

import org.fundacion.jala.converter.core.ExtractMetadata;
import org.fundacion.jala.converter.core.FileStorageService;
import org.fundacion.jala.converter.core.exceptions.MetadataException;

import java.io.File;

/**
 * This class calls facade of metadata.
 */
public class MetadataFacade {
    private MetadataFacade(){};

    /**
     * Extracts metadata from a file.
     *
     * @param metadata a String with metadata request.
     * @param outputFileName a String with the new file's name.
     * @param fileStorageService an object to create the path.
     */
    public static void extractMetadata(final boolean metadata, final String outputFileName, final FileStorageService fileStorageService) throws MetadataException {
        String outputPath = fileStorageService.getOutputPath(outputFileName);
        String outputPathWithoutFileName = fileStorageService.getOutputPathWithoutFileName(outputFileName);
        if (metadata) {
            ExtractMetadata extractMetadata = new ExtractMetadata(new File(outputPath), new File(outputPathWithoutFileName));
            extractMetadata.extractMetadata();
        }
    }
}
