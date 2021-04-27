package org.fundacion.jala.converter.core.facade;

import org.fundacion.jala.converter.core.ExtractMetadata;
import org.fundacion.jala.converter.core.FileStorageService;
import java.io.File;

public class MetadataFacade {
    private MetadataFacade(){};

    /**
     * Extracts metadata from a file.
     *
     * @param metadata a String with metadata request.
     * @param outputFileName a String with the new file's name.
     * @param fileStorageService an object to create the path.
     */
    public static void extractMetadata(final boolean metadata, final String outputFileName, final FileStorageService fileStorageService) {
        String outputPath = fileStorageService.getOutputPath(outputFileName);
        String outputPathWithoutFileName = fileStorageService.getOutputPathWithoutFileName(outputFileName);
        if (metadata) {
            ExtractMetadata extractMetadata = new ExtractMetadata(new File(outputPath), new File(outputPathWithoutFileName));
            extractMetadata.extractMetadata();
        }
    }
}
