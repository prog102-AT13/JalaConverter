/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service.pythoncompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonCompiler {

    /**
     * @param compilerVersion has command according version
     * @param filePath represents what file we want to compile
     * @return the result of execution in console
     */
    public String compiler(final Python compilerVersion, final String filePath) {
        try {
            String command = compilerVersion.getVersion() + " " + filePath;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReaderr = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while((resultOfExecution = bufferedReaderr.readLine()) != null) {
                result += resultOfExecution + "\n";
            }
            return result;
        } catch (IOException exception) {
            return exception.getMessage();
        }
    }
}
