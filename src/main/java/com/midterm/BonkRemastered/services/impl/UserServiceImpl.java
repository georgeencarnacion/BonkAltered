package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.repository.RoleRepository;
import com.midterm.BonkRemastered.repository.UserRepository;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(UserDTO userDTO) {
        User user = new User(userDTO);
        user.setRole(roleRepository.findByName(userDTO.getRole()));
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDTO get(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }

    @Override
    public UserDTO get(String email){return new UserDTO(userRepository.findByEmail(email));}

    @Override
    public void update(UserDTO updatedUser) {
        User user = new User(updatedUser);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO validateUser(String emailAddress, String password) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(emailAddress);

        if (passwordEncoder.matches(password, user.getPasswordHash())) {
            return new UserDTO(user);
        } else {
            return null;
        }

    }

    @Override
    public void updateBusiness(UserDTO userDTO) {
        User user = new User(userDTO);
        User previousUser = userRepository.findById(userDTO.getId()).get();
        user.setFirstName(previousUser.getFirstName());
        user.setMiddleName(previousUser.getMiddleName());
        user.setLastName(previousUser.getLastName());
        user.setEmail(previousUser.getEmail());
        user.setPasswordHash(previousUser.getPasswordHash());
        user.setPhoneNum(previousUser.getPhoneNum());


        userRepository.save(user);
    }

    @Override
    public void updatePass(UserDTO updateUser)
    {
        User user = userRepository.findByEmail(updateUser.getEmail());
        user.setPasswordHash((passwordEncoder.encode(updateUser.getPassword())));
        userRepository.save(user);
    }


}
