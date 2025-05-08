package com.fitnesstracker.service;

import com.fitnesstracker.dto.UserDTO;

import java.util.List;

public interface UserServices {
    UserDTO register(UserDTO dto);
    UserDTO getByUsername(String username);

}
