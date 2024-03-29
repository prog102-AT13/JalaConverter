/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzalez Alvarado
 */
package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to query to database.
 */
public class FileSQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * Inserts data into the database.
     *
     * @param fileName is a name the file.
     * @param pathFile is a path the file.
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
     * Finds a project by id.
     *
     * @param fileId is an int with the project id.
     * @return File with the project found.
     */
    public static File findFileById(final int fileId) {
        EntityManager manager = emf.createEntityManager();
        File fileResult;
        manager.getTransaction().begin();
        fileResult = manager.find(File.class, fileId);
        manager.getTransaction().commit();
        manager.close();
        return fileResult;
    }

    /**
     * Deletes a file.
     *
     * @param fileId int with the file's id to be deleted
     */
    public static void deleteFile(final int fileId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        File deleteFile = manager.find(File.class, fileId);
        manager.remove(deleteFile);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Gets the userId from the database.
     *
     * @param idProject a int with project Id
     * @return a List<File> with all project's files
     */
    public static List<File> listFileById(final int idProject) {
        List<File> list = listFile();
        List<File> newList = new ArrayList<>();
        for (File file : list) {
            if (idProject == file.getProject().getId()) {
                newList.add(file);
            }
        }
        return newList;
    }

    /**
     * Lists all files in the db.
     *
     * @return a List<File> with all files.
     */
    public static List<File> listFile() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<File> filesList = manager.createQuery("from File", File.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return filesList;
    }
}
