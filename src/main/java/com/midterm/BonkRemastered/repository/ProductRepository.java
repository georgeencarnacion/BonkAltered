package com.midterm.BonkRemastered.repository;

import com.midterm.BonkRemastered.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
