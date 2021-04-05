package org.fundacion.jala.converter.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_ID")
    private int id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "PATH")
    private String path;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Project() {

    }

    public Project(int id, String titulo, String path, String type, User user) {
        this.id = id;
        this.titulo = titulo;
        this.path = path;
        this.type = type;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(titulo, project.titulo) &&
                Objects.equals(path, project.path) &&
                Objects.equals(type, project.type) &&
                Objects.equals(user, project.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, path, type, user);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
