package org.fundacion.jala.converter.controller;

import org.fundacion.jala.converter.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    /**
     * Inserts users to the database
     * @param username a String with the username
     * @param password a String with the password
     * @return an entity response with the user
     */
    @PostMapping("/register")
    public ResponseEntity<?> insertUser(final @RequestParam("username") String username, final @RequestParam("password") String password) {
        return ResponseEntity.ok(myUserDetailsService.save(username, password));
    }
}
