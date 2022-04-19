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
@RequestMapping("register")
public class RegisterController {

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private String getUserAddForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/login";
    }

    @PostMapping
    private String addUser(UserDTO user, Model model) {
        user.setRole(USER_ROLE);
        userService.add(user);
        return "redirect:user/login";
    }

}
