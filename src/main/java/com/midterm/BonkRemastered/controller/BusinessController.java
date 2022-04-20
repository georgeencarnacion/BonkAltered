package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("business")
public class BusinessController {

    @Autowired
    private UserService userService;

    @Autowired
    private BusinessService businessService;

    @GetMapping
    private String index(Model model){
        model.addAttribute("user", new User());

        return "/index";

    }
    @GetMapping("/{id}")
    private String getUser(@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.get(id));
        model.addAttribute("business", new BusinessDTO());
        return "business/form";
    }

    @PostMapping("/{userId}")
    private String adduserBusiness(@PathVariable Long userId, BusinessDTO businessDTO, Model model){
        businessDTO.setOwner(userId);
        businessService.add(businessDTO);
        return index(model);
    }

}
