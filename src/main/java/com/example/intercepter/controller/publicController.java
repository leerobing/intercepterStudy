package com.example.intercepter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class publicController {

    @GetMapping("/hello")
    public String hello() {
        return "hello public";
    }
}
