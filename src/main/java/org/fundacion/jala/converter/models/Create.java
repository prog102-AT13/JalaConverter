
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;


//import static org.fundacion.jala.converter.models.ProjectSQL.insertProjectData;
//import static org.fundacion.jala.converter.models.UserSQL.editUserData;

import static org.fundacion.jala.converter.models.UserSQL.*;//import static org.fundacion.jala.converter.models.UserSQL.insertUserData;

public final class Create {

    private Create() { }

    public static void main(final String[] args) {
        User user1;
        User user2;
//        insertUserData("Pablo Perez", "password1", "token1");
//        insertUserData("Elena Gomez", "password2", "token2");
//        insertUserData("Pablo pablo", "password1", "token1");
//        insertUserData("Elena elena", "password2", "token2");
//        insertUserData("Edson edson", "password1", "token1");
//        insertUserData("Cristian cristian", "password2", "token2");
//        insertUserData("Edson", "password1", "token1");
//        user1 = insertUserData("cris", "password2", "token2");
//        user2 = insertUserData("ed", "password2", "token2");
//        editUserData(19, "Cristi", "123456", "tokeeen");
//        deleteUser(46);

        System.out.println(findUserById(29).getName());

        insertProjectData("ProyectoCafecito", "/proyecto/users/", "pequeño", user);


    }
}
