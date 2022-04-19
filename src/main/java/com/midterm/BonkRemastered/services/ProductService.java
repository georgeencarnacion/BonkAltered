package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> list();

    void add(ProductDTO products);

    ProductDTO get(Long id);

    void update(ProductDTO updatedProducts);

    void delete(Long id);
}
