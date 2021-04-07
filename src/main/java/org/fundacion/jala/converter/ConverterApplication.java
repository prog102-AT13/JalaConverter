package org.fundacion.jala.converter;

import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(final String[] args) {
        LOGGER.info("start");
//        SpringApplication.run(ConverterApplication.class, args);
        VideoParameter parameter = new VideoParameter();
        parameter.setOutputFormat("avi");
        parameter.setWidth(1280);
        parameter.setHeight(720);
        parameter.setFrameRate(60);
        parameter.setMetaData(false);
        parameter.setTumbnail(true);
        parameter.setAudio(true);
        Converter converter = new Converter(parameter);
        converter.convertVideo("/C/Jala/Progra102/Proy/JalaConverter/archive/storage/aguinaldo.mp4");
        LOGGER.info("finish");
    }

}
