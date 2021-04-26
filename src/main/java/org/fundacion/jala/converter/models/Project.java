/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales
 */

package org.fundacion.jala.converter.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This Class is a Entity of the database with the name PROJECT.
 */
@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PATH")
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<File> files = new ArrayList<>();

    public Project() {

    }

    public Project(final String newTitle, final String newPath, final User newUser) {
        this.title = newTitle;
        this.path = newPath;
        this.user = newUser;
    }

    /**
     * Obtains Id of the project.
     *
     * @return id of the project.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id of the project.
     *
     * @param newId is a int with the new project id.
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     * Obtains title of the project.
     *
     * @return String with title of the project.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new title of the project.
     *
     * @param newTitle String with the new title.
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Gets path of the project where the project is saved.
     *
     * @return String with the path of project.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets new path of the project.
     *
     * @param newPath path of project.
     */
    public void setPath(final String newPath) {
        this.path = newPath;
    }

    /**
     * Obtains all date of the project.
     *
     * @return String of the dates.
     */
    @Override
    public String toString() {
        return "Project{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", path='" + path + '\''
                + ", user=" + user + '\''
                + '}';
    }
}
