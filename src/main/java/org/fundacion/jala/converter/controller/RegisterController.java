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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.fundacion.jala.converter.models.UserSQL;
import org.fundacion.jala.converter.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * Inserts users to the database.
     *
     * @param username a String with the username
     * @param password a String with the password
     * @return an entity response with the user
     */
    @PostMapping("/register")
    @ApiOperation(value = "Inserts users to the database", notes = "Provide username and password to register",
            authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")})
    public ResponseEntity<?> insertUser(final @ApiParam(value = "Introduce the username", required = true)
                                            @RequestParam("username") String username,
                                        final @ApiParam(value = "Introduce the password", required = true)
                                        @RequestParam("password") String password) throws Exception {
        if (usernameExists(username) || username.trim().isEmpty()) {
            throw new Exception("Invalid Username");
        }
        return ResponseEntity.ok(myUserDetailsService.save(username, password));
    }
}
