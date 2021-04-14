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
    public static void insertProjectData(final String projectName, final String pathProject, final String checksum, final User user) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Project project = new Project();
        project.setTitle(projectName);
        project.setPath(pathProject);
        project.setChecksum(checksum);
        project.setUser(user);
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
        Project deleteProject = manager.find(Project.class, projectId);
        manager.remove(deleteProject);
        manager.getTransaction().commit();
        manager.close();
    }

    @SuppressWarnings("unchecked")
    public static List<Project> listProject() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Project> projectList = manager.createQuery("from Project", Project.class).getResultList();
        System.out.println("----------------------------------------------");
        System.out.println(projectList);
        System.out.println("----------------------------------------------");
        manager.getTransaction().commit();
        manager.close();
        return projectList;
    }
}
