package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

//    public static void editUserData(final User user) {
//        EntityManager manager = emf.createEntityManager();
//        manager.getTransaction().begin();
//        User editUset = manager.find(User.class, user.getId());
//        editUset.setName("NuevoNombre");
//        manager.getTransaction().commit();
//        manager.close();
//    }
}
