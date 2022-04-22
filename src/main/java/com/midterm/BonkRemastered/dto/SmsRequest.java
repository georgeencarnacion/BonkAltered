package com.midterm.BonkRemastered.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String message;

    public SmsRequest(String phoneNumber, String message){
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber(){
        String phoneNum = new UserDTO().getPhoneNum();
        phoneNumber = phoneNum;
        return phoneNumber;
    }

    public String getMessage() {
        message = "You have registered for Merkante! if this was not you then please contact support.";
        return message;
    }

    @Override
    public String toString(){
        return "SmsRequest{" +
                "phoneNumber='"+phoneNumber+'\'' +
                ", message ='" + message + '\'' +
                '}';
    }
}
