/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Rodrigo Caceres Velasco
 */
package org.fundacion.jala.converter.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.NodeJsParameter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class compiles a Node.Js file.
 */
public class NodeJsCompiler {
    private NodeJsParameter nodeJsParameter;
    private BufferedReader bufferedReader;
    private String nodeExe = "\"" + "thirdparty\\windows\\nodebin\\node-v16.0.0-win-x64\\node.exe" + "\"";
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Compiles a java file.
     *
     * @param newNodeJsParameter for all the parameters needed for NodeJs Compiler.
     * @return the result of execution in console.
     * @throws CompilerException if process is interrupted.
     */
    public String nodeCompiler(final NodeJsParameter newNodeJsParameter) throws CompilerException{
        try {
            nodeJsParameter = newNodeJsParameter;
            String nodeFilePath = "\"" + nodeJsParameter.getFilePath() + "\"";
            ProcessBuilder processBuilder = new ProcessBuilder(nodeExe, nodeFilePath);
            Process process = processBuilder.start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while ((resultOfExecution = bufferedReader.readLine()) != null) {
                result += resultOfExecution + "\n";
            }
            return result;
        } catch (IOException exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return String.valueOf(new CompilerException(exception));
        }finally {
            try {
                LOGGER.info("Close bufferedReader Stream");
                bufferedReader.close();
            } catch (IOException exception) {
                LOGGER.error("Close Stream error" + exception.getLocalizedMessage());
                throw new CompilerException(exception);
            }
        }
    }
}
