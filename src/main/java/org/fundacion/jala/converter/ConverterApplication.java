/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.service.AudioConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		logger.info("start");
//		SpringApplication.run(ConverterApplication.class, args);
		logger.info("finish");

		//Usage example for the audio converter object

		AudioConverter audio = new AudioConverter();
 		audio.setFormat("mp3");//mp3,wav
 		audio.setBitrate("320");//64,128,192,320
 		audio.setVolume("1");//1-5 or 1-10
 		audio.setHz("20");//20,44,48
 		audio.audioConverter("/c/Users/Edson/Desktop/Edson/01. Jala/03. Prog102/JalaConverter/archive/Moana.mp4");


	}
}
