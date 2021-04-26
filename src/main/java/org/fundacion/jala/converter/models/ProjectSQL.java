/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales
 */
package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class is to query to database.
 */
public class ProjectSQL {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database.
     *
     * @param projectName name the archive.
     * @param pathProject path the archive.
     */
    public static Project insertProjectData(final String projectName, final String pathProject, final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User idUser = manager.find(User.class, userId);
        Project project = new Project(projectName, pathProject, idUser);
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
        return project;
    }

    /**
     * Finds a project by it's id.
     *
     * @param projectId int with the project id.
     * @return a project found by id.
     */
    public static Project findProjectById(final int projectId) {
        EntityManager manager = emf.createEntityManager();
        Project projectResult;
        manager.getTransaction().begin();
        projectResult = manager.find(Project.class, projectId);
        manager.getTransaction().commit();
        manager.close();
        return projectResult;
    }
}
