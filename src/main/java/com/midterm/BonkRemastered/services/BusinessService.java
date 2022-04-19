package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.BusinessDTO;

import java.util.List;

public interface BusinessService {
    List<BusinessDTO> list();

    void add(BusinessDTO business); //1:04:46

    BusinessDTO get(Long id);

    void update(BusinessDTO updatedBusiness);

    void delete(Long id);


}

