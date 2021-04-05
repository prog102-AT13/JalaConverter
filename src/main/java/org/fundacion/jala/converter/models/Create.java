
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;

import static org.fundacion.jala.converter.models.InsertDates.imprimirDatos;
import static org.fundacion.jala.converter.models.InsertDates.insertDatos;

public class Create {

    public static void main(String[] args) {

        insertDatos(1, "Pablo Perez", "pasword1", "token1", 1, "Project1", "/folder1/folder2/", "movie");
        insertDatos(2, "Elena Gomez", "pasword2", "token2", 3, "Project1", "/folder1/folder2/", "movie");
        insertDatos(3, "Miguel Lopez", "pasword3", "token3", 2, "project2", "/folder/folder2/", "movie");
        imprimirDatos();

    }
}
