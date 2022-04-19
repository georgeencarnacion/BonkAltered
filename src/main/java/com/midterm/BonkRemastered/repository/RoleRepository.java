package com.midterm.BonkRemastered.repository;

import com.midterm.BonkRemastered.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
