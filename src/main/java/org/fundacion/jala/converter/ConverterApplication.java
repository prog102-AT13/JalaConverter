/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.fundacion.jala.converter.service.AudioConverter;
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
