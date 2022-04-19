package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> list();

    void add(UserDTO user);

    UserDTO get(Long id);

    void update(UserDTO updatedUser);

    void delete(Long id);

    UserDTO validateUser(String emailAddress, String password);

    void updateBusiness(UserDTO updatedUser, User userM);
}

