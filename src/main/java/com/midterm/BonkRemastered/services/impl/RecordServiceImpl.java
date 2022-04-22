package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.dto.RecordDTO;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.model.Business;
import com.midterm.BonkRemastered.model.Product;
import com.midterm.BonkRemastered.model.Record;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.repository.RecordRepository;
import com.midterm.BonkRemastered.repository.UserRepository;
import com.midterm.BonkRemastered.services.RecordService;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;


    @Autowired
    private UserService userService;

    @Override
    public List<RecordDTO> list() {
        return StreamSupport.stream(recordRepository.findAll().spliterator(),false)
                .map(RecordDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(RecordDTO record){
        recordRepository.save(new Record(record));
    }

    @Override
    public RecordDTO get(Long id){
        return new RecordDTO(recordRepository.findById(id).get());
    }

    @Override
    public void update(RecordDTO updatedRecord){
        recordRepository.save(new Record(updatedRecord));
    }

    @Override
    public void delete(Long id){
        recordRepository.deleteById(id);
    }



}

