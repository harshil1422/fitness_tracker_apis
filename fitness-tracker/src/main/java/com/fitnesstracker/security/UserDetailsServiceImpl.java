package com.fitnesstracker.security;


import com.fitnesstracker.dao.UserDAO;
import com.fitnesstracker.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

    @Service
    public class UserDetailsServiceImpl implements UserDetailsService {

        private final UserDAO userDAO;

        public UserDetailsServiceImpl(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userDAO.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
            );
        }
    }

