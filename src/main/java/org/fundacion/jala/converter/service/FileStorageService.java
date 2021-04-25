/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
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

/**
 * This class makes the file storage.
 */
@Service
public class FileStorageService {
    public static final String PATH = System.getProperty("user.dir");
    public static final String ARCHIVE = "archive";
    public static final String STORAGE = "storage";
    public static final String OUTPUT = "output";

    /**
     * Uploads a file to designed storage path.
     *
     * @param file to be updated.
     * @return storageDir the storage path.
     */
    public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storageDir = PATH + File.separator + ARCHIVE + File.separator + filename;
        file.transferTo(new File(storageDir));
        return storageDir;
    }

    /**
     * Returns a resource from given filename.
     *
     * @param fileName of the resource.
     * @throws RuntimeException if the file does not exist.
     * @return resource from a file name.
     */
    public Resource downloadFile(String fileName) {
        Path path = Paths.get(getArchivePath(fileName));
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Url malformed", e);
        }
        if (resource.exists()) {
            return resource;
        } else {
            throw new RuntimeException("File doesn't exist");
        }
    }

    /**
     * Returns the designed output path.
     *
     * @param filename to get an output path.
     * @return output path.
     */
    public static String getOutputPath(String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + File.separator + filename;
    }

    /**
     * Returns the designed output path without the file's name.
     *
     * @param filename to get an output path.
     * @return path withour the file name.
     */
    public static String getOutputPathWithoutFileName(String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + File.separator;
    }

    /**
     * Returns archive path.
     *
     * @param filename to get an archive path.
     * @return the archive path.
     */
    public String getArchivePath(String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + filename;
    }
}