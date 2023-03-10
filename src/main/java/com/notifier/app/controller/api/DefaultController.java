package com.notifier.app.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class DefaultController {
    @GetMapping("healthcheck")
    public String healthCheck() {
        return "Running...";
    }
}
