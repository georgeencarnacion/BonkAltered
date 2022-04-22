package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.SmsRequest;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.services.TwilioService;
import com.midterm.BonkRemastered.services.UserService;
import com.midterm.BonkRemastered.services.impl.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
public class RegisterController {

    private static final String USER_ROLE = "ROLE_USER";

    @Autowired
    private UserService userService;

    @Autowired
    private TwilioService twilioService;

    @GetMapping("/login")
    private String getUserAddForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/login";
    }

    @PostMapping
    private String addUser(UserDTO user, Model model) {//, SmsRequest smsRequest
        String password = user.getPassword();
        String newPassword = user.getNewPassword();

        if(newPassword.equals(password)){
            user.setRole(USER_ROLE);
            userService.add(user);
//            twilioService.sendSms(smsRequest);
            return "redirect:user/login";
        }

        return "redirect:user/login";
    }

}
