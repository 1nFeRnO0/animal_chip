package com.example.animal_chip.services;

import com.example.animal_chip.models.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getlistAnimals() {
        return animals;
    }

    public void saveAnimal(Animal animal) {
        animals.add(animal);
    }
    
    public void deleteAnimal(long id) {
        animals.removeIf(animal -> animal.getAnimalID().equals(id));
    }
}
