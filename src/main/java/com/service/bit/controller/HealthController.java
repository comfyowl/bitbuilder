package com.service.bit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final LocalDateTime startTime = LocalDateTime.now();

    @GetMapping
    public Map<String, Object> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "bitbuilder");
        health.put("version", "0.0.1-SNAPSHOT");
        health.put("timestamp", LocalDateTime.now());
        health.put("uptime", "Started at " + startTime);
        
        Map<String, String> components = new HashMap<>();
        components.put("database", "UP");
        components.put("application", "UP");
        health.put("components", components);
        
        return health;
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "bitbuilder");
        return status;
    }
}