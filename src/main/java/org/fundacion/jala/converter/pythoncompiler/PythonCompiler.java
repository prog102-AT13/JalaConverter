package org.fundacion.jala.converter.pythoncompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonCompiler {

    public String compiler(Python compilerVersion, String filePath) {
        try {
            String command = compilerVersion.getVersion() + " " + filePath;
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while((resultOfExecution = br.readLine()) != null){
                result += resultOfExecution + "\n";
            }
            return result;
        } catch (IOException exception) {
            return exception.getMessage();
        }
    }
}
