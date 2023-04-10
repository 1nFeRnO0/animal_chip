package com.example.animal_chip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.animal_chip.models.Animal;
import com.example.animal_chip.services.AnimalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/")
    public String animals(@RequestParam(name = "first", required = false) String name, Model model) {
        model.addAttribute("animals", animalService.listAnimals(name));
        return "animals";
    }

    @GetMapping("/animal/{id}")
    public String animalInfo(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animal-info";
    }

    @PostMapping("/animal/create")
    public String createAnimal(Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/";
    }

    @PostMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/";
    }
}
