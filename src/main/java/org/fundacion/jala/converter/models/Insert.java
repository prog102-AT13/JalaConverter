
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

public final class Insert {

    private Insert() { }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    public static void insertDatos(final int userId, final String userName, final String pasword, final String token, final int projectId, final String projectName, final String pathProject, final String type) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setPasword(pasword);
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

    public static void imprimirDatos() {
        EntityManager manager = emf.createEntityManager();

        User user = manager.find(User.class, 1);

        List<Project> projects = user.getProjects();

        System.out.println("--------------------------------------");
        for (Project project: projects) {
            System.out.println("* " + project.toString());
        }

        System.out.println("--------------------------------------");
        System.out.println(user.toString());

        manager.close();
    }
}
