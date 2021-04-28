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
import org.fundacion.jala.converter.core.facade.ChecksumFacade;
import org.fundacion.jala.converter.core.facade.ConverterFacade;
import org.fundacion.jala.converter.core.facade.ParameterOutputChecksum;
import org.fundacion.jala.converter.core.facade.ZipFileFacade;
import org.fundacion.jala.converter.core.parameter.AudioParameter;
import org.fundacion.jala.converter.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import static org.fundacion.jala.converter.core.ExtractMetadata.extractMetadata;

/**
 * This class calls endpoint of the audio.
 */
@RestController
@RequestMapping("/api")
public class AudioConverterController {
    private static final Logger LOGGER = LogManager.getLogger();
    private ParameterOutputChecksum paramChecksum;
    private FileStorageService fileStorageService = new FileStorageService();

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
                             final @RequestParam("metadata") String metadata) throws IOException, InterruptedException {
        final String baseUrl;
        String downloadLink;
        String nameWithoutExtension;
        String outputFilename;
        paramChecksum = ChecksumFacade.getChecksum(checksum, file);
        AudioParameter audioParam;
        audioParam = new AudioParameter(paramChecksum.getOutputFilename(), format, bitrate, hz, volume, audioChannel);
        outputFilename = ConverterFacade.getAudioConverter(audioParam);
        extractMetadata(metadata, outputFilename, fileStorageService);
        ZipFileFacade.getZipFileAudio(paramChecksum, metadata, outputFilename);
        nameWithoutExtension = outputFilename.substring(0, outputFilename.lastIndexOf(".") + 1);
        baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        downloadLink = baseUrl + "/api/download/" + nameWithoutExtension + "zip";
        return downloadLink;
    }
}
