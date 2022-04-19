package com.midterm.BonkRemastered.repository;

import com.midterm.BonkRemastered.model.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessRepository extends CrudRepository<Business, Long> {

    Business findByOwner(Long Id);
}

