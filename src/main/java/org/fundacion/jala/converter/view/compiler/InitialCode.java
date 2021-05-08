/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.view.compiler;

/**
 * This class generates inicial code and name of main classes.
 */
public class InitialCode {

    /**
     * Generates initial code of any language.
     *
     * @param className represents name of the class.
     * @param extension represents what language the class is.
     * @return a string that is generated code.
     */
    public static String generate(final String className, final String extension) {
        switch (extension) {
            case "java":
                return generateJavaCode(className);
            case "py":
                return generatePythonCode(className);
            default:
                return "";
        }
    }

    /**
     * Generates initial code of java.
     *
     * @param className represents name of the java class.
     * @return a string that is generated java code.
     */
    public static String generateJavaCode(final String className) {
        if ("Main".equals(className)) {
            return "public class Main {\n"
                    + "        public static void main(String[] args) {\n"
                    + "                System.out.println(\"Hello World\");\n"
                    + "        }\n"
                    + "}";
        } else {
            return "class " + className + " {\n"
                    + "}";
        }
    }

    /**
     * Generates initial code of python.
     *
     * @param className represents name of the python class.
     * @return a string that is generated python code.
     */
    public static String generatePythonCode(final String className) {
        if ("__main__".equals(className)) {
            return "print(\"Hello World\")";
        } else {
            return "";
        }
    }

    /**
     * Gets name of main class.
     *
     * @param extension represents what language the class is.
     * @return a string with name of main class.
     */
    public static String getNameMain(final String extension) {
        switch (extension) {
            case "java":
                return "Main";
            case "py":
                return "__main__";
            default:
                return "";
        }
    }
}

