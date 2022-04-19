package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("inventory")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("products", productService.list());
        return "inventory/view-inventory";
    }

    @GetMapping("/add")
    private String getProductAddForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "inventory/add-product";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "inventory/add-product";
        }
        productService.add(product);
        return list(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "inventory/view-product";
    }

    @PutMapping
    private String update(ProductDTO product, Model model) {
        productService.update(product);
        return list(model);
    }

    @DeleteMapping
    private String delete(ProductDTO product, Model model) {
        productService.delete(product.getProductId());
        return list(model);
    }

}