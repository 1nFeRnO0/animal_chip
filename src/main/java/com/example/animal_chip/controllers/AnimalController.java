package com.example.animal_chip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.animal_chip.services.AnimalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/")
    public String animals(Model model) {
        model.addAttribute("animals", animalService.getlistAnimals());
        return "animals";
    }
}