/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.fundacion.jala.converter.core.facade.CompilerFacade;
import org.fundacion.jala.converter.core.javacompiler.JavaVersion;
import org.fundacion.jala.converter.core.parameter.JavaParameter;
import org.fundacion.jala.converter.core.parameter.PythonEnum;
import org.fundacion.jala.converter.core.parameter.PythonParameter;
import org.fundacion.jala.converter.models.File;
import org.fundacion.jala.converter.models.FileSQL;
import org.fundacion.jala.converter.models.Project;
import org.fundacion.jala.converter.models.ProjectSQL;
import org.fundacion.jala.converter.core.RunCommand;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.io.IOException;
import java.util.List;

/**
 * This class creates a project and saves it in the database.
 */
@RestController
@RequestMapping("/api")
public class ProjectController {

    /**
     * Creates a project in data base.
     *
     * @param projectName is a String with the project's name.
     * @param userId      is an integer with the user's id.
     * @return integer with the id of the project.
     * @throws IllegalStateException when method invoked at an illegal time.
     */
    @PostMapping("/projects")
    public int createProject(final @RequestParam("projectName") String projectName,
                             final @RequestParam("userId") int userId) throws IllegalStateException {
        String command = "mkdir " + System.getProperty("user.dir") + "\\" + projectName;
        RunCommand runCommand = new RunCommand();
        runCommand.run(command);
        String pathProject = (System.getProperty("user.dir") + "\\" + projectName);
        Project project = ProjectSQL.insertProjectData(projectName, pathProject, userId);
        return project.getId();
    }

    /**
     * Endpoint for creating a project in data base.
     *
     * @param fileName  is a String with the file's name.
     * @param idProject is an integer with the project's id.
     * @param extension is a String with file's extension.
     * @param code      is a String with the code for the file.
     * @return String with the path of files.
     * @throws IllegalStateException when method invoked at an illegal time.
     * @throws IOException           is a exception when invalid input is provided.
     */
    @PostMapping("/projects/{id}/file")
    public String createFiles(final @RequestParam("fileName") String fileName,  final @PathVariable("id") int idProject,
                              final @RequestParam("extension") String extension,
                              final @RequestParam("code") String code) throws IllegalStateException, IOException {
        Project project = ProjectSQL.findProjectById(idProject);
        String pathFile = project.getPath();
        FileSQL.insertFileData(fileName + "." + extension, pathFile, idProject);
        Transform.createFile(code, fileName, extension, pathFile);
        return pathFile;
    }

    /**
     * Endpoint for creating a project in data base.
     *
     * @param idFile is a String with the file's name.
     * @throws IllegalStateException when method invoked at an illegal time.
     */
    @DeleteMapping("/projects/file/{id}")
    public void deleteFile(final @PathVariable("id") int idFile) throws IllegalStateException {
        File file = FileSQL.findFileById(idFile);
        String command = "del " + file.getPathFile() + "\\" + file.getName();
        RunCommand runCommand = new RunCommand();
        runCommand.run(command);
        FileSQL.deleteFile(idFile);
    }

    /**
     * Endpoint for creating a project in data base.
     *
     * @param idProject is an integer with the project's id.
     * @return String with the path of files.
     * @throws IllegalStateException when method invoked at an illegal time.
     */
    @PostMapping("/projects/{id}")
    public String runProject(final @PathVariable("id") int idProject) throws IllegalStateException {
        Project project = ProjectSQL.findProjectById(idProject);
        List<File> fileList = FileSQL.listFileById(idProject);
        File mainFife = null;
        for (File file : fileList) {
            if (file.getName().toLowerCase().contains("main")) {
                mainFife = file;
            }
        }
        if (mainFife != null) {
            String[] extesion = mainFife.getName().split("[.]");
            if ("py".equals(extesion[extesion.length - 1])) {
                return CompilerFacade.facadePythonProjectCompile(new PythonParameter(mainFife.getPathFile(), PythonEnum.V3));
            }
            if ("java".equals(extesion[extesion.length - 1])) {
                try {
                    return CompilerFacade.facadeJavaProjectCompile(new JavaParameter(JavaVersion.JAVA_11, mainFife.getPathFile(),
                            mainFife.getName()));
                } catch (CompilerException e) {
                    e.printStackTrace();
                }
            }
        }
        return "main file not found";
    }
}
