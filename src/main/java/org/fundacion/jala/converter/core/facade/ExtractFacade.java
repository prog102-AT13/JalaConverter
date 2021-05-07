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

import org.fundacion.jala.converter.core.exceptions.FileStorageException;
import org.fundacion.jala.converter.core.exceptions.MetadataException;
import org.fundacion.jala.converter.core.exceptions.TextExtractorException;
import org.fundacion.jala.converter.core.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.core.ExtractMetadata;
import org.fundacion.jala.converter.core.ExtractText;
import org.fundacion.jala.converter.core.FileStorageService;
import org.fundacion.jala.converter.core.ObjectMetadata;
import org.fundacion.jala.converter.core.metadata.TypeFileExport;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

import static org.fundacion.jala.converter.core.parameter.Utils.changeNameFile;
import static org.fundacion.jala.converter.core.parameter.Utils.cleanFileNameParameter;

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
     * @throws TextExtractorException if process is interrupted.
     */
    public static void getTextExtract(final MultipartFile file, final String language) throws TextExtractorException {
        String fileOut = file.getOriginalFilename();
        String fileUpload = fileStorageService.uploadFile(file);
        fileOut = cleanFileNameParameter(fileOut);
        changeNameFile(fileUpload, fileOut);
        fileUpload = fileUpload.substring(0,fileUpload.lastIndexOf(System.getProperty("file.separator"))+1) + fileOut;
        String outputFileName = fileOut.substring(0, fileOut.lastIndexOf("."));
        ExtractTextParameter extractTextParameter;
        try {
            extractTextParameter = new ExtractTextParameter(fileUpload, language, outputFileName);
            ExtractText extractText = new ExtractText(extractTextParameter);
            extractText.extractText();
        } catch (FileStorageException exception) {
            throw new TextExtractorException(exception);
        }
    }

    /**
     * Extracts metadata from file.
     *
     * @param file is the path of file to extract metadata.
     * @param isMoreInfo is get more info of file.
     * @param nameExport  is the name of file where metadata are extracted.
     * @param format is the format of file where metadata are extracted.
     * @return a String with name of file which contains metadata.
     * @throws MetadataException if process is interrupted.
     */
    public static String getMetadataExtract(final MultipartFile file, final Boolean isMoreInfo, final String nameExport,
                                            final String format) throws MetadataException {
        String pathFile = null;
        try {
            pathFile = fileStorageService.uploadFile(file);
        } catch (FileStorageException exception) {
            throw new MetadataException(exception);
        }
        String outPath = FileStorageService.getOutputPathWithoutFileName(pathFile);
        String nameExportWithoutSpaces = cleanFileNameParameter(nameExport);
        String nameFile = pathFile.substring(pathFile.lastIndexOf(System.getProperty("file.separator")) + 1, pathFile.length());
        nameFile = cleanFileNameParameter(nameFile);
        String storagePath = outPath.substring(0,outPath.length()-1);
        String fullPath = storagePath + nameFile;
        changeNameFile(pathFile, nameFile);
        File fileToExtract = new File(fullPath);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setNameExport(nameExportWithoutSpaces);
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
