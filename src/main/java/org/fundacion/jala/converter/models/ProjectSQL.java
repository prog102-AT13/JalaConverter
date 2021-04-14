package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProjectSQL {
    public ProjectSQL() {
    }
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jalaPersistence");
    /**
     * This method is for to insert dates for database
     * @param projectName
     * @param pathProject
     * @param checksum
     */
    public static void insertProjectData(final String projectName, final String pathProject, final String checksum, final int userId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User editUser = manager.find(User.class, userId);
        Project project = new Project();
        project.setTitle(projectName);
        project.setPath(pathProject);
        project.setChecksum(checksum);
        project.setUser(editUser);
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
    }
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

    public static void deleteProject(final int projectId) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        User deleteProject = manager.find(User.class, projectId);
        manager.remove(deleteProject);
        manager.getTransaction().commit();
        manager.close();
    }
}
