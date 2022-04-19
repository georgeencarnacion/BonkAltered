package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping
    private String getUserAddForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login/index";
    }


}
