
/**
 * Copyright (c) 2021 Fundacion Jala.
 * <p>
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Insert {

    public Insert() {
    }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database
     * @param userName
     * @param pasword
     * @param token
     */
    public static User insertUserData(final String userName, final String pasword, final String token) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user = new User();
        user.setName(userName);
        user.setPassword(pasword);
        user.setToken(token);
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
        return user;
    }

    /**
     * This method is for to insert dates for database
     * @param projectName
     * @param pathProject
     * @param type
     */
    public static void insertProjectData(final String projectName, final String pathProject, final String type, final User user) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Project project = new Project();
        project.setTitle(projectName);
        project.setPath(pathProject);
        project.setType(type);
        project.setUser(user);
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
    }
}
