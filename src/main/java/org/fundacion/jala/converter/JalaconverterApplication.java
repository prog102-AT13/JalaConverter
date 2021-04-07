/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.view.MainInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class JalaconverterApplication {
	private final static Logger logger = LoggerFactory.getLogger(JalaconverterApplication.class);

	public static void main(String[] args) {
		MainInterface main = new MainInterface();
		SpringApplication.run(JalaconverterApplication.class, args);
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(()-> {
			main.initInterface();
		});
	}

}
