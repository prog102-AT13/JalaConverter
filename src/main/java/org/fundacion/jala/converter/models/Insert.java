
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

public final class Insert {

    private Insert() { }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database
     * @param userId
     * @param userName
     * @param pasword
     * @param token
     * @param projectId
     * @param projectName
     * @param pathProject
     * @param type
     */
    public static void insertData(
            final int userId,
            final String userName,
            final String pasword,
            final String token,
            final int projectId,
            final String projectName,
            final String pathProject,
            final String type
    ) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setPassword(pasword);
        user.setToken(token);
        manager.persist(user);
        Project project = new Project();
        project.setId(projectId);
        project.setTitle(projectName);
        project.setPath(pathProject);
        project.setType(type);
        project.setUser(user);
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Example method to insert data
     */
    public static void insert() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user1 = new User(1, "Pablo Perez", "pasword1", "token1");
        User user2 = new User(2, "Elena Gomez", "pasword2", "token2");
        User user3 = new User(3, "Miguel Lopez", "pasword3", "token3");

        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);

        Project project1 = new Project(1, "Project1", "/folder1/folder2/", "movie", user2);
        Project project2 = new Project(2, "project2", "/folder/folder2/", "movie", user3);
        Project project3 = new Project(3, "project3", "/folder5/folder/", "movie", user1);
        Project project4 = new Project(4, "project4", "/folderprueba/folder/", "movie", user2);
        Project project5 = new Project(5, "project5", "/name/folder2/", "movie", user2);

        manager.persist(project1);
        manager.persist(project2);
        manager.persist(project3);
        manager.persist(project4);
        manager.persist(project5);

        manager.getTransaction().commit();
        manager.close();
    }
}
