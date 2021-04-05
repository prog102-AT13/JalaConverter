package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InsertDates {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");

    public static void insertDatos(int user_id, String userName, String pasword, String token, int project_id, String projectName, String path, String type) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        User user = new User();
        user.setId(user_id);
        user.setName(userName);
        user.setPasword(pasword);
        user.setToken(token);
        manager.persist(user);

        Project project = new Project(project_id, projectName, path, type,  user);
        project.setId(project_id);
        project.setTitulo(projectName);
        project.setPath(path);
        project.setType(type);
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
