package com.example.animal_chip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.animal_chip.models.Animal;



public interface AnimalRepository extends JpaRepository<Animal, Long> {
    //List<Animal> findByName(String type);
    public enum criteria{
        type,
        name,
        point
    }
    
    @Query("Select a from Animal a where p.?2 like %?1%")
    List<Animal> findAll(String prompt, criteria c);
}
