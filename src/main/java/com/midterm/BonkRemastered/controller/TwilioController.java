package com.midterm.BonkRemastered.controller;

import com.midterm.BonkRemastered.dto.SmsRequest;
import com.midterm.BonkRemastered.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("someSms")
public class TwilioController {

    private final TwilioService twilioService;

    @Autowired
    public TwilioController(TwilioService twilioService){
        this.twilioService = twilioService;
    }

    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        twilioService.sendSms(smsRequest);
    }
}
