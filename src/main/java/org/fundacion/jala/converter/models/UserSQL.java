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
     * This method is for to insert dates for database
     * @param userName
     * @param password
     * @param token
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

    public static void deleteUser(final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User deleteUser = manager.find(User.class, userId);
        manager.remove(deleteUser);
        manager.getTransaction().commit();
        manager.close();
    }

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

    @SuppressWarnings("unchecked")
    public static List<User> listUser() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<User> userList = manager.createQuery("from User", User.class).getResultList();
        System.out.println("----------------------------------------------");
        System.out.println(userList);
        System.out.println("----------------------------------------------");
        manager.getTransaction().commit();
        manager.close();
        return userList;
    }
}
