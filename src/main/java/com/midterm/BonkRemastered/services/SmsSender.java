package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.SmsRequest;

public interface SmsSender {

    void sendSMs(SmsRequest smsRequest);
}
