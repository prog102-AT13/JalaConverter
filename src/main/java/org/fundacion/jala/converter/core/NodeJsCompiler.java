package org.fundacion.jala.converter.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.parameter.NodeJsParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NodeJsCompiler {
    private NodeJsParameter nodeJsParameter;
    private static final Logger LOGGER = LogManager.getLogger();
    private BufferedReader bufferedReader;
    private String nodeExe = "\"" +"thirdparty\\windows\\nodebin\\node-v16.0.0-win-x64\\node.exe"+ "\"";

    public String nodeCompiler(final NodeJsParameter newNodeJsParameter){
        try {
            nodeJsParameter= newNodeJsParameter;
            String nodeFilePath = "\"" + nodeJsParameter.getFilePath() + "\"";
            ProcessBuilder processBuilder = new ProcessBuilder(nodeExe,nodeFilePath);
            Process process = processBuilder.start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while ((resultOfExecution = bufferedReader.readLine()) != null) {
                result += resultOfExecution + "\n";
            }
            return  result;
        }catch (IOException exception) {
            LOGGER.error("Execute Exception" + exception.getLocalizedMessage());
            return String.valueOf(new CompilerException(exception));
        }
    }
//
//    public static void main(String[] args) {
//        NodeJsCompiler node = new NodeJsCompiler();
//
//       String res = node.nodeCompiler("C:\\Users\\Jorge Caceres\\Documents\\Jala\\Prog102\\FinalProject\\JalaConverter\\archive\\storage\\test.js");
//       LOGGER.info("init");
//       System.out.println(res);
//        LOGGER.info("end");
//
//    }
}

