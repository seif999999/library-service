package com.yourorg.library.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService primaryService;
    private final NotificationService smsService;

    public NotificationController(
            NotificationService primaryService,
            @Qualifier("sms") NotificationService smsService) {
        this.primaryService = primaryService;
        this.smsService = smsService;
    }

    @GetMapping("/email")
    public String notifyByEmail(@RequestParam(defaultValue = "Hello via Email!") String msg) {
        return primaryService.send(msg);
    }

    @GetMapping("/sms")
    public String notifyBySms(@RequestParam(defaultValue = "Hello via SMS!") String msg) {
        return smsService.send(msg);
    }
}