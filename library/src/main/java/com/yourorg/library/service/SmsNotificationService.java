package com.yourorg.library.service;


import org.springframework.stereotype.Service;

@Service("sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public String send(String message) {
        return "SMS sent: " + message;
    }
}

