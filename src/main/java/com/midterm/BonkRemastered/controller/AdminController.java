package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.services.BusinessService;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {


    @Autowired
    private UserService userService;


    @Autowired
    private BusinessService businessService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("users", userService.list());
        return "admin/index";
    }

    @GetMapping("/{id}")
    private String getUser(@PathVariable Long id, Model model) {

        List<String> availableRoles = Arrays.asList("ROLE_PENDING", "ROLE_APPROVED", "ROLE_DECLINED");

        model.addAttribute("user", userService.get(id));
        model.addAttribute("business", new BusinessDTO());
        model.addAttribute("roles", availableRoles);

        return "admin/review";
    }



    @PatchMapping
    private String updateAdmin(UserDTO user, Model model) {


        model.addAttribute("user", new User());

        userService.updateBusiness(user);

        return list(model);
    }

    @DeleteMapping
    private String deleteUser(UserDTO user, Model model) {
        userService.delete(user.getId());
        return list(model);

    }



}
