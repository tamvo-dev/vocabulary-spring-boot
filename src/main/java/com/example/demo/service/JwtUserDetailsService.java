package com.example.demo.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author tamvo
 * @created 14/03/2020 - 9:16 PM
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static final String USER_NAME = "tamvo";
    // 1234
    private static final String PASSWORD = "$2a$10$wbJhCE46KB3QCJ0UtAhEi.siKQmbpPjsGL/eZMnGcO1EF7blxHfie";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (USER_NAME.equals(s)){
            return new User(USER_NAME, PASSWORD, new ArrayList<>());
        }

        throw new UsernameNotFoundException(s);
    }
}