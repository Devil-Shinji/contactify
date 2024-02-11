package com.example.contactify;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ping")
public class PingController {
    @GetMapping
    public String getAll() { return "Pong"; }
}