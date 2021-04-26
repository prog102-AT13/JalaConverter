/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Cristian Felix Choque Quispe
 */
package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * This class is to query to database.
 */
public class AssetSQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * Inserts data into the database.
     *
     * @param projectName is a name of the file to save in the database.
     * @param pathProject is a path of the file to save in the database.
     * @param checksum is a String of the checksum to save in the database.
     * @param userId is a id of the user to identify the user.
     */
    public static void insertAssetData(final String projectName, final String pathProject,
                                       final String checksum, final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editUser = manager.find(User.class, userId);
        Asset asset = new Asset();
        asset.setTitle(projectName);
        asset.setPath(pathProject);
        asset.setChecksum(checksum);
        asset.setUser(editUser);
        manager.persist(asset);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Edits the data of the project.
     *
     * @param projectId is a id of the audio or video converter.
     * @param projectName is a name of the file to edit in the database.
     * @param pathProject is a path of the file to save in the database.
     * @param type is a String with the type of the audio or video converter.
     * @param user is all the data of the user.
     */
    public static void editProjectData(final int projectId, final String projectName,
                                       final String pathProject, final String type, final User user) {
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
     * Deletes a data from the database of the audio or video converter.
     *
     * @param assetId is a int with the id of the audio or video converter.
     */
    public static void deleteProject(final int assetId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Asset deleteProject = manager.find(Asset.class, assetId);
        manager.remove(deleteProject);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Lists all the data of the audio and video converter in the db.
     *
     * @return a list of the all the data of the database.
     */
    @SuppressWarnings("unchecked")
    public static List<Asset> listAsset() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Asset> assetList = manager.createQuery("from Asset", Asset.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return assetList;
    }
}
