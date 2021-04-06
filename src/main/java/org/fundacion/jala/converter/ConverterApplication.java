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
//		SpringApplication.run(ConverterApplication.class, args);
		AudioConverter audio = new AudioConverter();
		audio.setFormat("mp3");
		audio.setBitrate("120");
		audio.setVolume("1");
		audio.setHz("49");//20,44,48
		audio.audioConverter("/c/Users/Edson/Desktop/Edson/01. Jala/03. Prog102/Practicas/archive/storage/Moana.mp4");
	}
}
