
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.models;

import static org.fundacion.jala.converter.models.Insert.imprimirDatos;
import static org.fundacion.jala.converter.models.Insert.insertDatos;

public final class Create {

    private Create() { }

    public static void main(final String[] args) {

        insertDatos(1, "Pablo Perez", "pasword1", "token1", 0, "Project1", "/folder1/folder2/", "movie");
        insertDatos(2, "Elena Gomez", "pasword2", "token2", 1, "Project1", "/folder1/folder2/", "movie");
        imprimirDatos();

    }
}
