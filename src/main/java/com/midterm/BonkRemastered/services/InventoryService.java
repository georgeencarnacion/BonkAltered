package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {

    List<InventoryDTO> list();

    void add(InventoryDTO inventory);

    InventoryDTO get(Long id);

    void update(InventoryDTO updatedInventory);

    void delete(Long id);
}
