/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Cristian Choque Quispe
 */
package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssetSQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * This method is for to insert dates for database.
     *
     * @param projectName name the archive.
     * @param pathProject path the archive.
     * @param checksum string checksum of the archive.
     */
    public static void insertAssetData(final String projectName, final String pathProject, final String checksum, final int userId) {
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
     * Edits the data of the project
     *
     * @param projectId int with the project id.
     * @param projectName String with the name of the project.
     * @param pathProject String with the path of the project.
     * @param type String with the type og¿f the project.
     * @param user a User.
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
     * Deletes a project.
     *
     * @param assetId int with the project id.
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
     * Lists the project in the db.
     *
     * @return a list of projects.
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
