package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.model.Product;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.repository.ProductRepository;
import com.midterm.BonkRemastered.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> list() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(ProductDTO productDTO) {
        productRepository.save(new Product(productDTO));
    }

    @Override
    public ProductDTO get(Long id) {
        return new ProductDTO(productRepository.findById(id).get());
    }

    @Override
    public void update(ProductDTO productDTO) {

        Product product = new Product(productDTO);
        Product data = productRepository.findById(productDTO.getProductId()).get();
        product.setIncome((data.getTotalInventory() - data.getQuantity()) * (data.getResellPrice() - data.getPrice()));
        product.setExpenses(data.getTotalInventory() * data.getPrice());
        product.setItemSold(data.getTotalInventory() - data.getQuantity());
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
