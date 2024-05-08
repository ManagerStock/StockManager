package com.allali.Stock.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/ok")
    public String getMessage() {
        return "Hello, world!";
    }
}

