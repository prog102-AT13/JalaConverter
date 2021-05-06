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
package org.fundacion.jala.converter.core.parameter;

import org.fundacion.jala.converter.core.RunCommand;

/**
 * This class contains utilities for the core.
 */
public class Utils {

    /**
     * Clear the name of blanks
     *
     * @param fileName with spaces of blanks
     * @return a String of fileName without spaces of blanks
     */
    public static String cleanFileNameParameter(final String fileName) {
        String cleanedFileName = "";
        final int asciiSpace = 32;
        for (int i = 0; i < fileName.length(); i++) {
            if ((int) fileName.charAt(i) != asciiSpace) {
                cleanedFileName += fileName.charAt(i);
            }
        }
        return cleanedFileName;
    }

    public static void changeNameFile(final String storagePath, final String fileName) {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        RunCommand runCommand = new RunCommand();
        if (isWindows) {
            runCommand.run("cd archive && ren " + "\"" + storagePath + "\"" + " " + fileName);
        } else {
            runCommand.run("cd archive && mv " + "\"" + storagePath + "\"" + " " + fileName);
        }
    }
}
