/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Juan Pablo Gonzales Alvarado
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
 * This Class is a Entity of the database with the name FILE.
 */
@Entity
@Table(name = "FILE")
public class File {

    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFile;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PATH_FILE")
    private String pathFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    public File() {
    }

    public File(final String newName, final String newPathFile, final Project newProject) {
        this.name = newName;
        this.pathFile = newPathFile;
        this.project = newProject;
    }

    /**
     * Obtains Id of the file to java or python compiler.
     *
     * @return id of the File.
     */
    public int getIdFile() {
        return idFile;
    }

    /**
     * Sets new Id of the User.
     *
     * @param newIdFile int with the new id.
     */
    public void setIdFile(final int newIdFile) {
        this.idFile = newIdFile;
    }

    /**
     * Obtains name of the file.
     *
     * @return name of the file.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name of the file.
     *
     * @param newName String with the name of the file.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Obtains path of the File.
     *
     * @return path of the File.
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * Sets new path of the File.
     *
     * @param newPathFile String with the new path.
     */
    public void setPathFile(final String newPathFile) {
        this.pathFile = newPathFile;
    }
}
