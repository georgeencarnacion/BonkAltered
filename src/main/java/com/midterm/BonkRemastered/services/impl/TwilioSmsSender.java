package com.midterm.BonkRemastered.services.impl;

import com.midterm.BonkRemastered.config.TwilioConfig;
import com.midterm.BonkRemastered.dto.SmsRequest;
import com.midterm.BonkRemastered.dto.UserDTO;
import com.midterm.BonkRemastered.services.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    public static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfig twilioConfig;
    private UserDTO userDTO;

    @Autowired
    public TwilioSmsSender(TwilioConfig twilioConfig){
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void sendSMs(SmsRequest smsRequest) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());

            String message = smsRequest.getMessage();

            MessageCreator creator = Message.creator(to,from,message);
            creator.create();
            LOGGER.info("Send sms{}" +smsRequest);

    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return true;
    }
}
