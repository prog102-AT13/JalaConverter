/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {
    public static final String PATH = System.getProperty("user.dir");
    public static final String ARCHIVE = "archive";
    public static final String STORAGE = "storage";
    public static final String OUTPUT = "output";
    public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storageDir = PATH + File.separator + ARCHIVE + File.separator + STORAGE + File.separator + filename;
        file.transferTo(new File(storageDir));
        return storageDir;
    }
    public Resource downloadFile(String fileName) {
        Path path = Paths.get(getOutputPath(fileName));
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Url malformed", e);
        }
        if (resource.exists()) {
            return resource;
        }
        else {
            throw new RuntimeException("File doesn't exist");
        }
    }
    public static String getOutputPath(String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + OUTPUT + File.separator + filename;
    }
}