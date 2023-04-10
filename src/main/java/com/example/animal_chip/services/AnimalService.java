package com.example.animal_chip.services;

import com.example.animal_chip.models.Animal;
import com.example.animal_chip.repositories.AnimalRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

// import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> listAnimals(String name) {
        if (name != null) {
            return animalRepository.findByName(name);
        }
        return animalRepository.findAll();
    }

    public void saveAnimal(Animal animal) {
        log.info("Saving new", animal);
        animalRepository.save(animal);
    }

    public void deleteAnimal(long id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalById(long id) {
        return animalRepository.findById(id).orElse(null);
    }
}
