/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.fundacion.jala.converter.models.UserSQL.findUserById;

@Service
public class MyUserDetailsService implements UserDetailsService {
    /**
     * Gets user details with the username
     * @param username to locate the user
     * @return User Details
     * @throws UsernameNotFoundException when user not found or has not granted authority
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return new User(findUserById(2).getName(),
                findUserById(2).getPassword(),
                new ArrayList<>());
    }
}
