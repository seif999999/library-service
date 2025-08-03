package com.yourorg.library.controller;

import com.yourorg.library.config.LibraryConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final LibraryConfig config;

    public ConfigController(LibraryConfig config) {
        this.config = config;
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return Map.of(
                "libraryName", config.getName(),
                "libraryMode", config.getMode()
        );
    }
}
