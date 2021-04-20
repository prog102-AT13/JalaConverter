/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.facade;

import org.fundacion.jala.converter.models.parameter.ExtractTextParameter;
import org.fundacion.jala.converter.service.ExtractText;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public class ExtractFacade {
    private ExtractFacade(){
    }

    /**
     * The method to extract text from image
     *
     * @param file is the path of file to extract text.
     * @param language is the language which file are written
     * @param nameOutput is the name of file where text are extracted
     * @throws IOException is the exception if File doesn't exist
     */
    public static void getTextExtract(MultipartFile file,String language,String nameOutput) throws IOException {
        FileStorageService fileStorageService=new FileStorageService();
        String filename = file.getOriginalFilename();
        String storagePath = fileStorageService.uploadFile(file);
        ExtractText extractText = new ExtractText(new ExtractTextParameter(storagePath, language, nameOutput));
        extractText.extractText();
    }
}
