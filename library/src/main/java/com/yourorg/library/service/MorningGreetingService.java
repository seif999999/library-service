package com.yourorg.library.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("morningService")
public class MorningGreetingService implements GreetingService {
    public String greet() {
        return "Good Morning!";
    }
}
