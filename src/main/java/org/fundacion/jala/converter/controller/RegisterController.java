/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.fundacion.jala.converter.models.UserSQL.usernameExists;

/**
 * This class registers a user in the database.
 */
@RestController
public class RegisterController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * * Inserts users to the database.
     *
     * @param username is a String with the username.
     * @param password is a String with the password.
     * @return an entity response with the user.
     * @throws Exception when invalid username or password is given.
     */
    @PostMapping("/register")
    public ResponseEntity<?> insertUser(final @RequestParam("username") String username,
                                        final @RequestParam("password") String password) throws Exception {
        if (usernameExists(username) || username.trim().isEmpty()) {
            throw new Exception("Invalid Username");
        }
        return ResponseEntity.ok(myUserDetailsService.save(username, password));
    }
}
