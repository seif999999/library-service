package com.yourorg.library.service;

import org.springframework.stereotype.Service;

@Service("eveningService")
public class EveningGreetingService implements GreetingService {
    public String greet() {
        return "Good Evening!";
    }
}

