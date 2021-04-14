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

public class UserSQL {
    public UserSQL() {
    }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    /**
     * Inserts users in the db
     * @param userName String with the user name
     * @param password String with the password of the user
     * @param token String the token
     */
    public static User insertUserData(final String userName, final String password, final String token) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setToken(token);
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
        return user;
    }

    /**
     * Edits the data of the user
     * @param userId int with the id of the user to be edited
     * @param userName String with the new user name
     * @param password String with the new password of the user
     * @param token String with the new token
     */
    public static void editUserData(final int userId, final String userName, final String password, final String token) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editUser = manager.find(User.class, userId);
        editUser.setName(userName);
        editUser.setPassword(password);
        editUser.setToken(token);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Deletes a user
     * @param userId int with the id of the user to be deleted
     */
    public static void deleteUser(final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User deleteUser = manager.find(User.class, userId);
        manager.remove(deleteUser);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Finds a user by it's id
     * @param userId int with the user id
     * @return a user
     */
    public static User findUserById(final int userId) {
        EntityManager manager = emf.createEntityManager();
        User userResult;
        manager.getTransaction().begin();
        User user = manager.find(User.class, userId);
        userResult = user;
        manager.getTransaction().commit();
        manager.close();
        return userResult;
    }

    /**
     *Lists all users in the db
     * @return a list of users
     */
    @SuppressWarnings("unchecked")
    public static List<User> listUser() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<User> userList = manager.createQuery("from User", User.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return userList;
    }
}
