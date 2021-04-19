package org.fundacion.jala.converter.facade;

import org.fundacion.jala.converter.models.parameter.AudioParameter;
import org.fundacion.jala.converter.service.AudioConverter;

public class CompilerFacade {
    private CompilerFacade(){

    }

    /**
     *
     * @param filePath is the path of file to convert
     * @param format file's extension
     * @param bitrate a bitrate of the file
     * @param hz a string with hz
     * @param volume a string with a volume
     * @param audioChannels a string with audi channels
     * @return a string of output filename
     */
    public static String getAudioConverter(final String filePath, final String format, final String bitrate,
                                           final String hz, final String volume, final String audioChannels ){
        AudioParameter audioParameter =new AudioParameter(filePath, format, bitrate, hz, volume, audioChannels);
        AudioConverter audioConverter=new AudioConverter(audioParameter);
        audioConverter.audioConverter(filePath);
        return audioConverter.getOutputFileName();
    }

}
