package com.midterm.BonkRemastered.services;

import com.midterm.BonkRemastered.dto.SmsRequest;
import com.midterm.BonkRemastered.services.impl.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class TwilioService {

    public final SmsSender smsSender;

    @Autowired
    public TwilioService(@Qualifier("twilio") TwilioSmsSender smsSender){
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSMs(smsRequest);
    }
}
