/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.models.facade;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.AudioConverter;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ConverterFacade {

    private ConverterFacade() {
    }

    /**
     * The method to convert Audio
     *
     * @param filePath is the path of file to convert
     * @param format file's extension
     * @param bitrate is bitrate of the file
     * @param hz is string with hz
     * @param volume is string with a volume
     * @param audioChannels is string with audi channels
     * @return a string of output filename
     */
    public static String getAudioConverter(final String filePath, final String format, final String bitrate,
                                               final String hz, final String volume, final String audioChannels) {
        AudioParameter audioParameter = new AudioParameter(filePath, format, bitrate, hz, volume, audioChannels);
        AudioConverter audioConverter = new AudioConverter(audioParameter);
        audioConverter.audioConverter(filePath);
        return audioConverter.getOutputFileName();
    }

    /**
     * The method to convert Video
     *
     * @param file is the file of video to convert
     * @param outputFormat video's extension
     * @param resolution is resolution of the video
     * @param thumbnail is thumbnail of the video
     * @param frameRate is frameRate of the video
     * @param width is width of the video
     * @param height is height of the video
     * @param audio if video has audio
     * @return string of output filename
     * @throws IOException of video
     */
    public static String getVideoConverter(MultipartFile file, String outputFormat, String resolution,
                                           boolean thumbnail, int frameRate, int width, int height, boolean audio) throws IOException {
        FileStorageService fileStorageService = new FileStorageService();
        String storagePath = fileStorageService.uploadFile(file);
        VideoParameter videoParameter = new VideoParameter();
        Converter converter = new Converter(videoParameter);
        videoParameter.setOutputFormat(outputFormat);
        videoParameter.setResolution(resolution);
        videoParameter.setThumbnail(thumbnail);
        videoParameter.setFrameRate(frameRate);
        videoParameter.setWidth(width);
        videoParameter.setHeight(height);
        videoParameter.setAudio(audio);
        converter.convertVideo(storagePath);
        return converter.getOutputFileName();
    }
}
