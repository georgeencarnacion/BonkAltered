package com.midterm.BonkRemastered.repository;

import com.midterm.BonkRemastered.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
