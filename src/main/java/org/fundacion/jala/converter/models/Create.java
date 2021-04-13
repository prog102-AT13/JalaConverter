
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

//        insertUserData("Pablo Perez", "pasword1", "token1");
//        insertUserData("Elena Gomez", "pasword2", "token2");
//        insertUserData("Pablo pablo", "pasword1", "token1");
//        insertUserData("Elena elena", "pasword2", "token2");
//        insertUserData("Edson edson", "pasword1", "token1");
//        insertUserData("Cristian cristian", "pasword2", "token2");
//        insertUserData("Edson", "pasword1", "token1");
        User user = insertUserData("edsonsito", "pasword2", "token2");
       // editUserData(user);

//        insertProjectData("ProyectoCafecito", "/proyecto/users/", "pequeño", user);


    }
}
