package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.dto.SmsRequest;
import com.midterm.BonkRemastered.dto.UserDTO;
import org.springframework.security.core.Authentication;

public interface SmsSender {

    void sendSMs(SmsRequest smsRequest);

    void sendSms(UserDTO userDTO, Authentication authentication);
}
