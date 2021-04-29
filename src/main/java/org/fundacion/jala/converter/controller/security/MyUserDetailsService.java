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
package org.fundacion.jala.converter.controller.security;

import org.fundacion.jala.converter.models.AuthenticationRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import static org.fundacion.jala.converter.models.UserSQL.findUserById;
import static org.fundacion.jala.converter.models.UserSQL.getUserId;
import static org.fundacion.jala.converter.models.UserSQL.insertUserData;
import static org.fundacion.jala.converter.models.UserSQL.usernameExists;

/**
 * This class creates the user's details service.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    /**
     * Gets user details with the username.
     *
     * @param username a String to locate the user.
     * @return User Details a object with details of the user.
     * @throws UsernameNotFoundException when user not found or has not granted authority.
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        boolean usernameExists = usernameExists(username);
        if (usernameExists) {
            int userId = getUserId(username);
            return new User(findUserById(userId).getName(),
                    findUserById(userId).getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    /**
     * Saves user in the database.
     *
     * @param username a String with username.
     * @param password a String with password.
     * @return AuthenticationRequest with the given param.
     */
    public AuthenticationRequest save(final String username, final String password) {
        insertUserData(username, password, "");
        return new AuthenticationRequest(username, password);
    }
}
