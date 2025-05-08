package com.fitnesstracker.service;

import com.fitnesstracker.dao.UserDAO;
import com.fitnesstracker.dto.UserDTO;
import com.fitnesstracker.exception.ResourceNotFoundException;
import com.fitnesstracker.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO getUserByUsername(String username) {
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));


        return modelMapper.map(user, UserDTO.class);
    }

    public User createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userDAO.save(user);
    }
}
