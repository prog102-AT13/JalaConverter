/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProjectSQL {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database
     * @param projectName
     * @param pathProject
     * @param checksum
     */
    public static void insertProjectData(final String projectName, final String pathProject, final String checksum, final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editUser = manager.find(User.class, userId);
        Project project = new Project();
        project.setTitle(projectName);
        project.setPath(pathProject);
        project.setChecksum(checksum);
        project.setUser(editUser);
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Edits the data of the project
     * @param projectId int with the project id
     * @param projectName String with the name of the project
     * @param pathProject String with the path of the project
     * @param type String with the type og¿f the project
     * @param user a User
     */
    public static void editProjectData(final int projectId, final String projectName, final String pathProject, final String type, final User user) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editProject = manager.find(User.class, projectId);
        editProject.setName(projectName);
        editProject.setPassword(pathProject);
        editProject.setToken(type);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Deletes a project
     * @param projectId int with the project id
     */
    public static void deleteProject(final int projectId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Project deleteProject = manager.find(Project.class, projectId);
        manager.remove(deleteProject);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Lists the project in the db
     * @return a list of projects
     */
    @SuppressWarnings("unchecked")
    public static List<Project> listProject() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Project> projectList = manager.createQuery("from Project", Project.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return projectList;
    }
}
