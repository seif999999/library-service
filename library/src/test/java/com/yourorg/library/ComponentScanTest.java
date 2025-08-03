package com.yourorg.library;

import com.yourorg.library.service.IncludedService;
import com.yourorg.library.service.UnwantedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;



public class ComponentScanTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void includedServiceShouldBeLoaded() {
        assertNotNull(context.getBean(IncludedService.class));
    }

    @Test
    void unwantedServiceShouldNotBeLoaded() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean(UnwantedService.class);
        });
    }
}