
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;


import static org.fundacion.jala.converter.models.ProjectSQL.insertProjectData;
//import static org.fundacion.jala.converter.models.UserSQL.editUserData;
import static org.fundacion.jala.converter.models.UserSQL.insertUserData;

public final class Create {

    private Create() { }

    public static void main(final String[] args) {

        insertData(9, "Pablo Perez", "pasword1", "token1", 7, "Project1", "/folder1/folder2/", "movie");
//        insertData(6, "Elena Gomez", "pasword2", "token2", 3, "Project1", "/folder1/folder2/", "movie");

    }
}
