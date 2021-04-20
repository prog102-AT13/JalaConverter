package org.fundacion.jala.converter.facade;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.AudioConverter;
import org.fundacion.jala.converter.service.FileStorageService;
import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class CompilerFacade {

    private CompilerFacade() {

    }

    /**
     * The method to convert Audio
     * @param filePath      is the path of file to convert
     * @param format        file's extension
     * @param bitrate       a bitrate of the file
     * @param hz            a string with hz
     * @param volume        a string with a volume
     * @param audioChannels a string with audi channels
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
     *
     * @param file
     * @param outputFormat
     * @param resolution
     * @param thumbnail
     * @param frameRate
     * @param width
     * @param height
     * @param audio
     * @return
     * @throws IOException
     */
    public static String getVideoConverter(MultipartFile file,String outputFormat,String resolution,
                                           boolean thumbnail,int frameRate,int width,int height,boolean audio ) throws IOException {
        Converter converter = new Converter();
        FileStorageService fileStorageService=new FileStorageService();
        String storagePath=fileStorageService.uploadFile(file);
        VideoParameter videoParameter=new VideoParameter();
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
