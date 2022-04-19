package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.dto.InventoryDTO;
import com.midterm.BonkRemastered.model.Inventory;
import com.midterm.BonkRemastered.repository.InventoryRepository;
import com.midterm.BonkRemastered.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public void add(InventoryDTO inventory) {

        inventoryRepository.save(new Inventory(inventory));
    }

    ;

    @Override
    public List<InventoryDTO> list() {
        return StreamSupport.stream(inventoryRepository.findAll().spliterator(), false)
                .map(InventoryDTO::new)
                .collect(Collectors.toList());
    }


    @Override
    public InventoryDTO get(Long id) {
        return new InventoryDTO(inventoryRepository.findById(id).get());
    }

    @Override
    public void update(InventoryDTO updatedInventory) {
        inventoryRepository.save(new Inventory(updatedInventory));
    }

    @Override
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
}