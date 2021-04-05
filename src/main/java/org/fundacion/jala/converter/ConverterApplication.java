package org.fundacion.jala.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("start");
        SpringApplication.run(ConverterApplication.class, args);
        logger.info("finish");
    }

}
