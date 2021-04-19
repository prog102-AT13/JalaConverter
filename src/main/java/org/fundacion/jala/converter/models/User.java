/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TOKEN")
    private String token;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Asset> assets = new ArrayList<>();

    public User() {

    }

    public User(final String newName, final String newPassword, final String newToken) {
        this.name = newName;
        this.password = newPassword;
        this.token = newToken;
    }

    /**
     * Obtains Ids of the User
     * @return id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new Id of the User
     * @param newId int with the new id
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
     * Sets new name of the user
     * @param newName String with the new name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Obtains password of the User
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets new password of the User
     * @param newPassword String with the password
     */
    public void setPassword(final String newPassword) {
        this.password = newPassword;
    }

    /**
     * Obtains token of the user
     * @return code token of the user
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets new token of the User
     * @param newToken String with the token
     */
    public void setToken(final String newToken) {
        this.token = newToken;
    }

    /**
     * Obtains all the projects that realized the user
     * @return all the projects of the user
     */
    public List<Asset> getProjects() {
        return assets;
    }

    /**
     * Sets projects of the user
     * @param newProjects a list of projects
     */
    public void setProjects(final List<Asset> newProjects) {
        this.assets = newProjects;
    }

    /**
     * Obtains all date of the user
     * @return String of the dates
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id
                + ", name='" + name + '\''
                + ", pasword='" + password + '\''
                + ", token='" + token + '\''
                + ", projects=" + assets
                + '}';
    }
}
