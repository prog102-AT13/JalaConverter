/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Edson Añawaya Rios
 */
package org.fundacion.jala.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.models.facade.ChecksumFacade;
import org.fundacion.jala.converter.models.facade.ConverterFacade;
import org.fundacion.jala.converter.models.facade.ParameterOutputChecksum;
import org.fundacion.jala.converter.models.facade.ZipFileFacade;
import org.fundacion.jala.converter.models.facade.DownloadLinkFacade;
import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import static org.fundacion.jala.converter.service.ExtractMetadata.extractMetadata;

/**
 * This class calls endpoint of the audio.
 */
@RestController
@RequestMapping("/api")
public class AudioConverterController {
    private static final Logger LOGGER = LogManager.getLogger();
    private ParameterOutputChecksum parameterOutputChecksum;

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * Calls endpoint to audio converter.
     *
     * @param file is path of file which will be converted.
     * @param format is the format with are converted of audio.
     * @param bitrate is the bitrate with are converted of audio.
     * @param volume is the volume with are converted of audio.
     * @param hz is the hz with are converted of audio.
     * @param audioChannel is the audioChannel with are converted of audio.
     * @param checksum is checksum of audio.
     * @param metadata if metadata is extracted from the audio.
     * @return path to download files.
     * @throws IOException is a exception when invalid input is provided.
     * @throws InterruptedException is exception if process is interrupted.
     */
    @PostMapping("/convertAudio")
    public String uploadFile(final @RequestParam("file") MultipartFile file,
                             final @RequestParam("format") String format,
                             final @RequestParam("bitrate") String bitrate,
                             final @RequestParam("volume") String volume,
                             final @RequestParam("hz") String hz,
                             final @RequestParam("audiochannel") String audioChannel,
                             final @RequestParam("checksum") String checksum,
                             final @RequestParam("metadata") boolean metadata)
            throws IOException, InterruptedException {
        LOGGER.info("start");
        parameterOutputChecksum = ChecksumFacade.getChecksum(checksum, file);
        String outputFilename = ConverterFacade.getAudioConverter(
                new AudioParameter(parameterOutputChecksum.getOutputFilename(), format, bitrate, hz, volume,
                        audioChannel));
        extractMetadata(metadata, outputFilename, fileStorageService);
        ZipFileFacade.getZipFileAudio(parameterOutputChecksum, metadata, outputFilename);
        LOGGER.info("finish");
        return DownloadLinkFacade.getLinkConverter(outputFilename);
    }
}

