/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.models.FileSQL;
import org.fundacion.jala.converter.models.Project;
import org.fundacion.jala.converter.models.ProjectSQL;
import org.fundacion.jala.converter.service.RunCommand;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;

/**
 * This class creates a project and saves it in the database.
 */
@RestController
@RequestMapping("/api")
public class ProjectController {

    /**
     * Endpoint for creating a project in data base.
     *
     * @return int with the id of the project
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
     * @return a String with the path of files
     */
    @PostMapping("/projects/{id}/file")
    public String createFiles(final @RequestParam("fileName") String fileName,
                              final @PathVariable("id") int idProject,
                              final @RequestParam("extension") String extension,
                              final @RequestParam("code") String code) throws IllegalStateException, IOException {
        Project project = ProjectSQL.findProjectById(idProject);
        String pathFile = project.getPath();
        FileSQL.insertFileData(fileName, pathFile, idProject);
        Transform.createFile(code, fileName, extension, pathFile);
        return pathFile;
    }
}
