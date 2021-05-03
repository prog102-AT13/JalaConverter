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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.RunCommand;
import org.fundacion.jala.converter.models.Asset;
import org.fundacion.jala.converter.core.FileStorageService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;
import static org.fundacion.jala.converter.core.ChecksumService.getFileChecksum;
import static org.fundacion.jala.converter.core.parameter.Utils.cleanFileNameParameter;
import static org.fundacion.jala.converter.models.AssetSQL.*;

/**
 * This class calls facade of checksum.
 */
public class ChecksumFacade {
    private static final Logger LOGGER = LogManager.getLogger();

    private ChecksumFacade() {
    }

    /**
     * Calls to review checksum in database.
     *
     * @param checksum is a date of file, it is unique for each file.
     * @param file is a file which is applied.
     * @return object of ParameterOutputChecksum.
     * @throws IOException is a exception when invalid file's path.
     */
    public static ParameterOutputChecksum getChecksum(final String checksum, final MultipartFile file)
            throws IOException, InterruptedException {
        FileStorageService fileStorageService = new FileStorageService();
        String filename;
        String storagePath;
        String checksumLocal = checksum;
        boolean exist = false;
        List<Asset> assets = listAsset();
        List<String> resultTitle = getTitles(checksum, assets);
        List<String> resultPath = getPath(checksum, assets);
        exist = resultTitle.size() > 0;
        if (exist) {
            filename = resultTitle.get(0);
            storagePath = resultPath.get(0) + filename;
        } else {
            filename = file.getOriginalFilename();
            storagePath = fileStorageService.uploadFile(file);
            try {
                LOGGER.info("Execute Try");
                checksumLocal = getFileChecksum(storagePath);
                LOGGER.info("finish");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                LOGGER.error("Execute Exception" + e.getLocalizedMessage());
            }
        }
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        RunCommand runCommand = new RunCommand();
        filename = cleanFileNameParameter(filename);
        if (isWindows) {
            runCommand.run("cd archive && ren " + "\"" + storagePath + "\"" + " " + filename);
        } else {
            runCommand.run("cd archive && mv " + "\"" + storagePath + "\"" + " " + filename);
        }
        storagePath = storagePath.substring(0,storagePath.lastIndexOf(System.getProperty("file.separator"))+1) + filename;
        return new ParameterOutputChecksum(checksumLocal, storagePath, resultTitle.size(), filename);
    }

    /**
     * Obtains the path of the file.
     *
     * @param checksum is checksum of file.
     * @param assets list of file in database.
     * @return return a List<String> with path of file with same checksum.
     */
    private static List<String> getPath(final String checksum, final List<Asset> assets) {
        return assets.stream().filter(project -> project.getChecksum().equals(checksum)).map(asset -> asset.getPath())
                .collect(Collectors.toList());
    }

    /**
     * Obtains the name of the file.
     *
     * @param checksum is checksum of file.
     * @param assets list of file in database.
     * @return return a List<String> with name of file with same checksum.
     */
    private static List<String> getTitles(final String checksum, final List<Asset> assets) {
        return assets.stream()
                .filter(project -> project.getChecksum().equals(checksum)).map(asset -> asset.getTitle())
                .collect(Collectors.toList());
    }
}

