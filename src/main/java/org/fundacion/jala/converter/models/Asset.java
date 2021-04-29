/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Cristian Felix Choque Quispe
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

/**
 * This Class is a Entity of the database with the name ASSET.
 */
@Entity
@Table(name = "ASSET")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSET_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PATH")
    private String path;

    @Column(name = "CHECKSUM")
    private String checksum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Asset() {
    }

    public Asset(final String newTitle, final String newPath, final String newChecksum, final User newUser) {
        this.title = newTitle;
        this.path = newPath;
        this.checksum = newChecksum;
        this.user = newUser;
    }

    /**
     * Obtains Id from the database.
     *
     * @return id from the audio or video converter.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets new id of the audio or video converter.
     *
     * @param newId is a int if the new audio or video converter.
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     * Obtains title of the audio or video converter.
     *
     * @return title of the project.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new title of the audio or video converter.
     *
     * @param newTitle String with the new title.
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Obtains the user that realized the project.
     *
     * @return name of the user that used the audio or video converter.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user of the audio or video converter.
     *
     * @param newUser the new user that used the audio or video converter.
     */
    public void setUser(final User newUser) {
        this.user = newUser;
    }

    /**
     * Gets path of the audio or video where the project is saved.
     *
     * @return path of the audio or video converted.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets new path of the audio or video.
     *
     * @param newPath is a new path of the audio or video converter.
     */
    public void setPath(final String newPath) {
        this.path = newPath;
    }

    /**
     * Obtains the checksum's value of the audio or video file.
     *
     * @return a string of checksum.
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets new checksum value of the audio or video file.
     *
     * @param newChecksum is a String with the new checksum.
     */
    public void setChecksum(final String newChecksum) {
        this.checksum = newChecksum;
    }

    /**
     * Obtains all data of the audio or video converter.
     *
     * @return String of the data of the audio or video converter.
     */
    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", titulo='" + title + '\'' + ", path='" + path + '\'' + ", type='"
                + checksum + '\'' + '}';
    }
}
