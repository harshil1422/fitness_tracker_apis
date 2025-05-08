package com.fitnesstracker.dao;


import com.fitnesstracker.model.User;

import java.util.Optional;

public interface UserDAO {

    User save(User user);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    public Optional<User> findById(Long id);
}
