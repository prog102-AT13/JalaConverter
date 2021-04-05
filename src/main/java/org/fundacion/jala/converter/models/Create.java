package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Create {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    public static void main(String[] args) {

        crearDatos();
        imprimirDatos();

    }

    static void crearDatos() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        User user1 = new User(1,"Pablo Perez", "pasword1","token1");
        User user2 = new User(2,"Elena Gomez", "pasword2","token2");
        User user3 = new User(3,"Miguel Lopez", "pasword3","token3");

        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);

        Project project1 = new Project(1,"Project1", "/folder1/folder2/", "movie",  user2);
        Project project2 = new Project(2,"project2", "/folder/folder2/", "movie", user3);
        Project project3 = new Project(3,"project3", "/folder5/folder/", "movie", user1);
        Project project4 = new Project(4,"project4", "/folderprueba/folder/", "movie", user2);
        Project project5 = new Project(5,"project5", "/name/folder2/", "movie", user2);

        manager.persist(project1);
        manager.persist(project2);
        manager.persist(project3);
        manager.persist(project4);
        manager.persist(project5);

        manager.getTransaction().commit();
        manager.close();
    }

    static void imprimirDatos() {
        EntityManager manager = emf.createEntityManager();

        User user = manager.find(User.class, 3);

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
