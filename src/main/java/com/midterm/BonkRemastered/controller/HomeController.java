package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping
    private String index( Model model) {
        model.addAttribute("user", new User());
        return "home/index";
    }



}

