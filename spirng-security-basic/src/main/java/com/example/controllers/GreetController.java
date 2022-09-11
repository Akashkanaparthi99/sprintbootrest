package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {
    @GetMapping("/greet")
    public String greetUser(){
        return "Have a Great day";
    }

}
