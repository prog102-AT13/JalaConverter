/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Edson Añawaya Rios
 */
package org.fundacion.jala.converter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This class runs a command in cmd or bash.
 */
public class RunCommand {
    private static final Logger LOGGER = LogManager.getLogger();
    private ArrayList<String> resultCommand = new ArrayList<String>();

    /**
     * Runs the command in cmd or bash.
     *
     * @param command a string with the command.
     */
    public void run(final String command) {
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows) {
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            processBuilder.command("bash", "-c", command);
        }
        LOGGER.info("start");
        try {
            LOGGER.info("Execute Try");
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                resultCommand.add(line);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(resultCommand);
                resultCommand.clear();
            } else {
                System.out.println("Fail!");
            }
            LOGGER.info("finish");
        } catch (IOException e) {
            LOGGER.error("Execute Exception" + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            LOGGER.error("Execute Exception" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
