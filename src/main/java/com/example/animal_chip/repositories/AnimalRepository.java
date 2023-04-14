package com.example.animal_chip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal_chip.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByName(String type);
}
