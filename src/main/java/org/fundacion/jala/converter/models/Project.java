
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PATH")
    private String path;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Project() {

    }

    public Project(final int newId, final String newTitle, final String newPath, final String newType, final User newUser) {
        this.id = newId;
        this.title = newTitle;
        this.path = newPath;
        this.type = newType;
        this.user = newUser;
    }

    /**
     * Obtains Id of the project
     * @return id of the project
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id of the project
     * @param newId
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     * Obtains title of the projetc
     * @return title of the project
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new title of the project
     * @param newTitle
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Obtains the user that realized the project
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets User of the project
     * @param newUser
     */
    public void setUser(final User newUser) {
        this.user = newUser;
    }

    /**
     * Gets path of the project where the project is saved
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets new path of the project
     * @param newPath
     */
    public void setPath(final String newPath) {
        this.path = newPath;
    }

    /**
     * Obtains type of the project
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Sets new path of the project
     * @param newType
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     * Obtains all dates of the project
     * @return String of the dates
     */
    @Override
    public String toString() {
        return "Project{" + "id=" + id
                + ", titulo='" + title + '\''
                + ", path='" + path + '\''
                + ", type='" + type + '\''
                + '}';
    }
}
