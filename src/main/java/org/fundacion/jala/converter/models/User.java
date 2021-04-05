
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
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASWORD")
    private String pasword;

    @Column(name = "TOKEN")
    private String token;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();

    public User() {

    }

    public User(final int newId, final String newName, final String newPasword, final String newToken) {
        this.id = newId;
        this.name = newName;
        this.pasword = newPasword;
        this.token = newToken;
    }

    /**
     * obtains Ids of the User
     * @return id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * sets new Id of the User
     * @param newId
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     * Obtains Name of the User
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * sets new name of the user
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Obtains pasword of the User
     * @return pasword of the user
     */
    public String getPasword() {
        return pasword;
    }

    /**
     * sets new pasword of the User
     * @param newPasword
     */
    public void setPasword(final String newPasword) {
        this.pasword = newPasword;
    }

    /**
     * Obtains token of the user
     * @return code token of the user
     */
    public String getToken() {
        return token;
    }

    /**
     * sets new token of the User
     * @param newToken
     */
    public void setToken(final String newToken) {
        this.token = newToken;
    }

    /**
     * Obtains all the projects that realized the user
     * @return all the projects of the user
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Set projects of the user
     * @param newProjects
     */
    public void setProjects(final List<Project> newProjects) {
        this.projects = newProjects;
    }

    /**
     * Obtains all dates of the user
     * @return String of the dates
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id
                + ", name='" + name + '\''
                + ", pasword='" + pasword + '\''
                + ", token='" + token + '\''
                + ", projects=" + projects
                + '}';
    }
}