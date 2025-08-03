package com.yourorg.library.service;

import org.springframework.stereotype.Service;

@Service
public class IncludedService {
    public String message() {
        return "Included!";
    }
}
