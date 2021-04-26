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

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * This class is to query to database.
 */
public class UserSQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    public UserSQL() {
    }

    /**
     * Inserts users in the db.
     *
     * @param userName String with the user name.
     * @param password String with the password of the user.
     * @param token    String the token.
     */
    public static User insertUserData(final String userName, final String password, final String token) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User user = new User();
        user.setName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setToken(token);
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
        return user;
    }

    /**
     * Edits the data of the user.
     *
     * @param userId   int with the id of the user to be edited.
     * @param userName String with the new user name.
     * @param password String with the new password of the user.
     * @param token    String with the new token.
     */
    public static void editUserData(final int userId, final String userName, final String password,
                                    final String token) {
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
     * Deletes a user of the database.
     *
     * @param userId int with the id of the user to be deleted.
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
     * Finds a user by it's id.
     *
     * @param userId is a int with the user id.
     * @return a user found by id.
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
     * Verifies if a username exists in the database.
     *
     * @param username a String with the username to check.
     * @return a boolean with the response.
     */
    public static boolean usernameExists(final String username) {
        List<User> list = listUser();
        Boolean usernameExists = false;
        for (User user : list) {
            if (username.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Edits the token value in the database.
     *
     * @param username a String with the username.
     * @param token    a String with the token.
     */
    public static void editToken(final String username, final String token) {
        int userId = getUserId(username);
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editUser = manager.find(User.class, userId);
        editUser.setToken(token);
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Gets the userId from the database.
     *
     * @param username a String to look for the userId.
     * @return an int with the userId.
     */
    public static int getUserId(final String username) {
        List<User> list = listUser();
        for (User user : list) {
            if (username.equals(user.getName())) {
                return user.getId();
            }
        }
        return 0;
    }

    /**
     * Lists all users in the db.
     *
     * @return a list of users.
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
