package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.model.User;
import com.midterm.BonkRemastered.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.midterm.BonkRemastered.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("forgot-password")
public class ForgotController {
    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public UserDTO user() {
        return new UserDTO();
    }

    @GetMapping
    private String index(Model model) {
        model.addAttribute("user", new UserDTO());
        return "forgot/index";
    }

    @PutMapping
    private String changePass(@ModelAttribute("user") @Valid UserDTO user, BindingResult bindingResult){
        String password = user.getPassword();
        String newPassword = user.getNewPassword();

        if(bindingResult.hasErrors()){
            return "forgot/index";
        }

        if (userService.get(user.getEmail()) != null){
            if(newPassword.equals(password)){
                userService.updatePass(user);
                return "login/index";
            }
        }

        return "forgot/index";
    }
}
