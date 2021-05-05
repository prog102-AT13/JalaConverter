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
package org.fundacion.jala.converter.core;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class makes the file storage.
 */
public class FileStorageService {
    public static final String PATH = System.getProperty("user.dir");
    public static final String ARCHIVE = "archive";
    public static final String STORAGE = "storage";
    public static final String OUTPUT = "output";

    /**
     * Uploads a file to designed storage path.
     *
     * @param file a MultipartFile file to be updated.
     * @return a String with the storageDir.
     */
    public String uploadFile(final MultipartFile file) throws IllegalStateException, IOException {
        String filename = file.getOriginalFilename();
        String storageDir = PATH + File.separator + ARCHIVE + File.separator + filename;
        file.transferTo(new File(storageDir));
        return storageDir;
    }

    /**
     * Returns a resource from given filename.
     *
     * @param fileName a String of the resource.
     * @throws RuntimeException if the file does not exist.
     * @return a String with the resource from a file name.
     */
    public Resource downloadFile(final String fileName) {
        try {
            Path path = Paths.get(getArchivePath(fileName));
            Resource resource;
            resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File doesn't exist");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Url malformed", e);
        }
    }

    /**
     * Returns a String with the designed output path.
     *
     * @param filename a String to get an output path.
     * @return a String with the output path.
     */
    public static String getOutputPath(final String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + File.separator + filename;
    }

    /**
     * Returns the designed output path without the file's name.
     *
     * @param filename a String to get an output path.
     * @return a String path without the file name.
     */
    public static String getOutputPathWithoutFileName(final String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + File.separator;
    }

    /**
     * Returns a String archive path.
     *
     * @param filename a String to get an archive path.
     * @return a String with the archive path.
     */
    public String getArchivePath(final String filename) {
        return PATH + File.separator + ARCHIVE + File.separator + filename;
    }
}
