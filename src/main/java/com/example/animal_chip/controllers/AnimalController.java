package com.example.animal_chip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.animal_chip.models.Animal;
import com.example.animal_chip.repositories.AnimalRepository;
import com.example.animal_chip.services.AnimalService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/search")
    public String animalSearch(@RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "point", required = false) String point, Model model) {
        model.addAttribute("animals", animalService.listAnimals(type, name, point));
        return "search";
    }

    @GetMapping("/")
    public String animals() {
        return "animals";
    }

    @GetMapping("/map")
    public String animalMap() {
        return "map";
    }

    @GetMapping("/about")
    public String info() {
        return "about";
    }

    @GetMapping("/account")
    public String animalAccount() {
        return "account";
    }

    @GetMapping("/animal/{id}")
    public String animalInfo(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("images", animal.getImages());
        return "animal-info";
    }

    @PostMapping("/animal/create")
    public String createAnimal(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3") MultipartFile file3,
            Animal animal) throws IOException {
        animalService.saveAnimal(animal, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/";
    }
}
