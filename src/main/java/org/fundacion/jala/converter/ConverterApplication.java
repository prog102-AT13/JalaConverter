/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.service.videoclasses.Converter;
import org.fundacion.jala.converter.service.videoclasses.VideoParameter;
import org.fundacion.jala.converter.view.MainInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(final String[] args) {
        MainInterface main = new MainInterface();
        LOGGER.info("start");
        SpringApplication.run(ConverterApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(() -> {
            main.initInterface();
        });
        LOGGER.info("finish");
    }
}
