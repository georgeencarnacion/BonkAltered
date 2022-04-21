package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.dto.ProductDTO;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.ProductService;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    private String list(@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.get(id));
        model.addAttribute("product", new ProductDTO());


        return "product/view-inventory";
    }

    @GetMapping("/add")
    private String getProductAddForm( Model model) {


        model.addAttribute("product", new ProductDTO());
        return "product/add-product";
    }

    @PostMapping("/{id}")
    private String add(@Valid @ModelAttribute("product") @PathVariable Long id,  ProductDTO product, BindingResult bindingResult, Model model) {

        product.setUniqueId(id);
        productService.add(product);
        return list(id, model);
    }

    @GetMapping("/{id}/view")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "product/view-product";
    }

    @PutMapping("/{id}")
    private String update(@PathVariable Long id, ProductDTO product, Model model) {

        product.setUniqueId(id);
        productService.update(product);
        return list(id, model);
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable Long id, ProductDTO product, Model model) {
        product.setUniqueId(id);
        productService.delete(product.getProductId());
        return list(id, model);
    }

}