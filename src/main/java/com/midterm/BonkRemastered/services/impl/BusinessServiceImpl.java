package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.model.Business;
import com.midterm.BonkRemastered.repository.BusinessRepository;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public List<BusinessDTO> list() {
        return StreamSupport.stream(businessRepository.findAll().spliterator(), false)
                .map(BusinessDTO::new)
                .collect(Collectors.toList());
    }


    @Override
    public void add(BusinessDTO bussinessDTO) {
        Business business = new Business(bussinessDTO);

        if (bussinessDTO.getImage() != null) {
            fileStorageService.save(bussinessDTO.getImage());
            business.setImageLoc(bussinessDTO.getImage().getOriginalFilename());

        }
        businessRepository.save(business);
    }
    @Override
    public BusinessDTO get(Long id) {
        return new BusinessDTO(businessRepository.findById(id).get());
    }

    @Override
    public void update(BusinessDTO updatedBusiness) {
        businessRepository.save(new Business(updatedBusiness));
    }

    @Override
    public void delete(Long id) {
        businessRepository.deleteById(id);
    }
}
