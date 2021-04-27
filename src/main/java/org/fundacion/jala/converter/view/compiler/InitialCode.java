package org.fundacion.jala.converter.view.compiler;

public class InitialCode {

    /**
     *
     * @param className
     * @return
     */
    public static String genetare(final String className, final String extension) {
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
     *
     * @param className
     * @return
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
     *
     * @param className
     * @return
     */
    public static String generatePythonCode(final String className) {
        if ("Main".equals(className)) {
            return "print(\"Hello World\")";
        } else {
            return "";
        }
    }
}
