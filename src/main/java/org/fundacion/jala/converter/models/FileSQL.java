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

public class FileSQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database
     * @param fileName name the file
     * @param pathFile path the file
     */
    public static void insertFileData(final String fileName, final String pathFile, final int projectId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Project idProject = manager.find(Project.class, projectId);
        File file = new File(fileName, pathFile, idProject);
        manager.persist(file);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Finds a project by its id
     * @param fileId int with the project id
     * @return a project
     */
    public static File findProjectById(final int fileId) {
        EntityManager manager = emf.createEntityManager();
        File fileResult;
        manager.getTransaction().begin();
        fileResult = manager.find(File.class, fileId);
        manager.getTransaction().commit();
        manager.close();
        return fileResult;
    }
}
