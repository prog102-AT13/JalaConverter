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
    public static final String TXT_FILE_EXTENSION = ".txt";
    public static final String HTML_FILE_EXTENSION = ".html";
    public static final String XMP_FILE_EXTENSION = ".xmp";

    private ExtractFacade() {
    }

    /**
     * Extracts text from image.
     *
     * @param extractTextParameter is a object with parameter of extractText to convert.
     */
    public static void getTextExtract(final ExtractTextParameter extractTextParameter) {
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
     */
    public static String getMetadataExtract(final MultipartFile file, final Boolean isMoreInfo,
                                            final String nameExport, final String format) throws IOException {
        FileStorageService fileStorageService = new FileStorageService();
        String pathFile = fileStorageService.uploadFile(file);
        TypeFileExport typeFileExport = stringToEnum(format);
        String outPath = fileStorageService.getOutputPathWithoutFileName(fileStorageService.getOutputPath(pathFile));
        File fileToExtract = new File(pathFile);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setNameExport(nameExport + "");
        objectMetadata.setFileToExtract(fileToExtract);
        objectMetadata.setFileToExport(new File(outPath));
        objectMetadata.setMoreInfo(isMoreInfo);
        objectMetadata.setTypeFileExport(typeFileExport);
        ExtractMetadata extractMetadata = new ExtractMetadata(objectMetadata);
        extractMetadata.extractMetadata();
        if ("Default".equals(nameExport)) {
            return fileToExtract.getName().substring(0, fileToExtract.getName().lastIndexOf(".") + 0);
        } else {
            return nameExport;
        }
    }

    /**
     * Converts string to enum for metadata.
     *
     * @param format define type of file which it is exported.
     * @return format type TypeFileExport.
     */
    private static TypeFileExport stringToEnum(final String format) {
        if (TXT_FILE_EXTENSION.equals(format)) {
            return TypeFileExport.TXT;
        }
        if (HTML_FILE_EXTENSION.equals(format)) {
            return TypeFileExport.HTML;
        }
        if (XMP_FILE_EXTENSION.equals(format)) {
            return TypeFileExport.XMP;
        }
        return TypeFileExport.TXT;
    }
}