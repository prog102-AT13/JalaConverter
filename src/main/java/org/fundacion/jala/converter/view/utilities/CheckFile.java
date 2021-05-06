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
            JOptionPane.showMessageDialog(null, "You need to select a file", "Error Message", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "You need to specify an output name ", "Error Message", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            return true;
        }
    }
}
