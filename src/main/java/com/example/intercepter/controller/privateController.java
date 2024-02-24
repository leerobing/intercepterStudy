package com.example.intercepter.controller;

import com.example.intercepter.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Auth
@RequestMapping("/api/private")
public class privateController {

    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "hello private";
    }
}
