package com.TD.spring_introduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(
            @RequestParam (name = "name", defaultValue = "Guest") String name){
    return "Welcome " + name;
    }
}
