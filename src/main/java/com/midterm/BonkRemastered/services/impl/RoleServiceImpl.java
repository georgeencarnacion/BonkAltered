package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.repository.RoleRepository;
import com.midterm.BonkRemastered.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Long getRoleId(String name) {
        return roleRepository.findByName(name).getId();
    }

}
