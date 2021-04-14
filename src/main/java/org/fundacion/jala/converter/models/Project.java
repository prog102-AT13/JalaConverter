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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Project(final String newTitle, final String newPath, final String newType, final User newUser) {
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
     * @param newId int with the new project id
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     * Obtains title of the project
     * @return title of the project
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new title of the project
     * @param newTitle String with the new title
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
     * Sets the user of the project
     * @param newUser the new user
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
     * @param newType String with the new type
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     * Obtains all date of the project
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
