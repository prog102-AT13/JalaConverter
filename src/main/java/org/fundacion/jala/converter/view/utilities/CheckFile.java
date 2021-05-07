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
package org.fundacion.jala.converter.view.utilities;

import javax.swing.JOptionPane;
import static org.fundacion.jala.converter.ConverterApplication.dotenv;

/**
 * This class verify si is selected a file.
 */
public class CheckFile {

    /**
     * Verify that a file is selected.
     *
     * @param file Path String.
     * @return a boolean with the confirmation.
     */
    public static boolean checkFileSelect(final String file) {
        if (file != null) {
            return true;
        } else {
            messageError("You need to select a file");
            return false;
        }
    }

    /**
     * Verify that an output name was placed for the file.
     *
     * @param nameOutput String of name.
     * @return a boolean with the confirmation.
     */
    public static boolean checkOutputNameMetadata(final boolean checkHasMoreInfo, final String nameOutput) {
        if (!checkHasMoreInfo) {
            String nameOutputLocal = nameOutput.trim();
            if (!nameOutputLocal.equals("")) {
                return true;
            } else {
                messageError("You need to specify an output name ");
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Checks if the format is supported.
     *
     * @param fileName a string with de name of file.
     * @param supportedFormats a string with the all formats supported.
     * @return a boolean with the confirmation
     */
    public static boolean checkFormatAudioSupport(final String fileName, final String supportedFormats) {
        String fileNameLocal = fileName.substring(fileName.lastIndexOf(".") + 1);
        String arrayFormatSupports [] = supportedFormats.split(",");
        for (int i = 0; i < arrayFormatSupports.length; i++) {
            if (arrayFormatSupports[i].equals(fileNameLocal)) {
                return true;
            }
        }
        messageError("Unsupported format ");
        return false;
    }

    /**
     * Shows error message in UI.
     *
     * @param message a string with the custom message for the error.
     */
    public static void messageError(final String message) {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
}
