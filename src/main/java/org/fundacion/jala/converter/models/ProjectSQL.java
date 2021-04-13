package org.fundacion.jala.converter.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
