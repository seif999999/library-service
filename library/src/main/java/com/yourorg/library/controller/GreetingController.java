package com.yourorg.library.controller;

import com.yourorg.library.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    private GreetingService constructorInjectedService;

    @Autowired
    @Qualifier("eveningService")
    private GreetingService fieldInjectedService;

    private GreetingService setterInjectedService;

    // Constructor Injection
    public GreetingController(@Qualifier("morningService") GreetingService constructorInjectedService) {
        this.constructorInjectedService = constructorInjectedService;
    }

    // Setter Injection
    @Autowired
    public void setSetterInjectedService(@Qualifier("eveningService") GreetingService setterInjectedService) {
        this.setterInjectedService = setterInjectedService;
    }

    @GetMapping("/constructor")
    public String greetFromConstructor() {
        return constructorInjectedService.greet();
    }

    @GetMapping("/setter")
    public String greetFromSetter() {
        return setterInjectedService.greet();
    }

    @GetMapping("/field")
    public String greetFromField() {
        return fieldInjectedService.greet();
    }
}

