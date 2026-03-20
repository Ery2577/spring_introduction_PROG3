package com.TD.spring_introduction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(
            @RequestParam (name = "name", required = false) String name){
        if (name == null || name.trim().isEmpty()) {
             return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body("Error");
        }
        return ResponseEntity.ok("Welcome " + name);
    }
}
