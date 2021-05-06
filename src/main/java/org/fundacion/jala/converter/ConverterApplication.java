/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.view.MainInterface;
import org.fundacion.jala.converter.view.login.LoginInterface;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import javax.swing.SwingUtilities;

/**
 * This class is the main class of the software.
 */
@SpringBootApplication
public class ConverterApplication {
    private static final Logger LOGGER = LogManager.getLogger();
    public static Dotenv dotenv = Dotenv.configure().filename(".env.develop").ignoreIfMalformed().ignoreIfMissing().load();
    public static void main(final String[] args) {
        LOGGER.info("start");
        SpringApplication.run(ConverterApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        SwingUtilities.invokeLater(LoginInterface::new);
        LOGGER.info("finish");
    }
}
