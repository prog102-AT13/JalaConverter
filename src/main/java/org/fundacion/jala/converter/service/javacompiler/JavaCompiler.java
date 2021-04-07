package org.fundacion.jala.converter.service.javacompiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCompiler {
    /**
     * @param javaVersion has the commands according to java version
     * @param filePath represents the path of the file to compile
     * @return the result of execution in console
     */
    public String javaCompiler(final JavaVersion javaVersion, final String filePath){
        try {
            String command = javaVersion.getCompiler() + " " + filePath + "&&" + javaVersion.getExecutor() + " " + filePath;
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resultOfExecution = null;
            String result = "";
            while((resultOfExecution = bufferedReader.readLine()) != null){
                result += resultOfExecution + "\n";
            }
            return result;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
