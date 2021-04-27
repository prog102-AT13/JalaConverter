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

import org.fundacion.jala.converter.core.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.core.ExtractMetadata;
import org.fundacion.jala.converter.core.ExtractText;
import org.fundacion.jala.converter.core.FileStorageService;
import org.fundacion.jala.converter.core.ObjectMetadata;
import org.fundacion.jala.converter.core.metadata.TypeFileExport;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * This class calls facade of extract.
 */
public class ExtractFacade {
    private static FileStorageService fileStorageService = new FileStorageService();

    private ExtractFacade() {
    }

    /**
     * Extracts text from image.
     *
     * @param file file is image file to extract text.
     * @param  language is a type of language of the text.
     * @throws IOException is a exception when invalid input is provided.
     */
    public static void getTextExtract(final MultipartFile file, final String language) throws IOException {

        String fileOut = file.getOriginalFilename();
        String outputFileName = fileOut.substring(0, fileOut.lastIndexOf("."));
        ExtractTextParameter extractTextParameter;
        extractTextParameter = new ExtractTextParameter(fileStorageService.uploadFile(file), language, outputFileName);
        ExtractText extractText = new ExtractText(extractTextParameter);
        extractText.extractText();
    }

    /**
     * Extracts metadata from file.
     *
     * @param file is the path of file to extract metadata.
     * @param isMoreInfo is get more info of file.
     * @param nameExport  is the name of file where metadata are extracted.
     * @param format is the format of file where metadata are extracted.
     * @return string with name of file which contains metadata.
     * @throws IOException is exception when invalid path.
     * @throws IllegalArgumentException is exception when string not correspond enum.
     */
    public static String getMetadataExtract(final MultipartFile file, final Boolean isMoreInfo,
                                            final String nameExport, final String format)
            throws IOException, IllegalArgumentException {
        String pathFile = fileStorageService.uploadFile(file);
        String outPath = FileStorageService.getOutputPathWithoutFileName(pathFile);
        File fileToExtract = new File(pathFile);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setNameExport(nameExport);
        objectMetadata.setFileToExtract(fileToExtract);
        objectMetadata.setFileToExport(new File(outPath));
        objectMetadata.setMoreInfo(isMoreInfo);
        objectMetadata.setTypeFileExport(TypeFileExport.valueOf(format.toUpperCase()));
        ExtractMetadata extractMetadata = new ExtractMetadata(objectMetadata);
        extractMetadata.extractMetadata();
        if ("".equals(nameExport)) {
            return fileToExtract.getName().substring(0, fileToExtract.getName().lastIndexOf(".") + 0);
        } else {
            return nameExport;
        }
    }
}
