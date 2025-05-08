package com.fitnesstracker.service.impl;



import com.fitnesstracker.dao.UserDAO;
import com.fitnesstracker.dto.UserDTO;
import com.fitnesstracker.exception.ValidationException;
import com.fitnesstracker.model.Role;
import com.fitnesstracker.model.User;
import com.fitnesstracker.exception.ResourceNotFoundException;
import com.fitnesstracker.service.UserServices;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserServices {

    private final UserDAO userDAO;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserDAO userDAO, ModelMapper mapper, PasswordEncoder encoder) {
        this.userDAO = userDAO;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public UserDTO register(UserDTO dto) {
        if (userDAO.existsByUsername(dto.getUsername())) {
            throw new ValidationException("Username already exists");
        }
        if (userDAO.existsByEmail(dto.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        User user = mapper.map(dto, User.class);
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole() != null ? dto.getRole() : Role.ROLE_USER);
        userDAO.save(user);
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return mapper.map(user, UserDTO.class);
    }


}