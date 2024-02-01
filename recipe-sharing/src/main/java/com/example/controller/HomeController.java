package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HomeController {
    
    @GetMapping
    public String homeController() {
        return "Hello World!";
    }
    

}
