package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.BusinessDTO;
import com.midterm.BonkRemastered.dto.SmsRequest;

public interface SmsSender {

    void sendSMs(SmsRequest smsRequest);

    void sendSms(BusinessDTO businessDTO, Long id);
}
