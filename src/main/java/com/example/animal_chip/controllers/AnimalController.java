package com.example.animal_chip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {
    @GetMapping("/")
    public String animals() {
        return "animals";
    }
}