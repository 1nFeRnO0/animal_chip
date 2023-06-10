package com.example.animal_chip.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.animal_chip.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // List<Animal> findByName(String type);
    // public enum criteria{
    // type,
    // name,
    // point
    // }
    // @Query(value = "SELECT * FROM animal", nativeQuery = true)
    List<Animal> findAll();

    // // @Query(value = "SELECT * FROM animal a WHERE a.type LIKE %:prompt%",
    // nativeQuery = true)
    List<Animal> findByType(String type);

    // @Query(value = "SELECT * FROM animal a WHERE a.name LIKE %:prompt%",
    // nativeQuery = true)
    List<Animal> findByName(String name);

    // @Query(value = "SELECT * FROM animal a WHERE a.point LIKE %:prompt%",
    // nativeQuery = true)
    List<Animal> findByPoint(String point);

    // @Query(value = "SELECT * FROM animal a WHERE a.type LIKE %:type% AND a.name
    // LIKE %:name%", nativeQuery = true)
    List<Animal> findByTypeAndName(String type, String name);

    // @Query(value = "SELECT * FROM animal a WHERE a.type LIKE %:type% AND a.point
    // LIKE %:point%", nativeQuery = true)
    List<Animal> findByTypeAndPoint(String type, String point);

    // @Query(value = "SELECT * FROM animal a WHERE a.name LIKE %:name% AND a.point
    // LIKE %:point%", nativeQuery = true)
    List<Animal> findByNameAndPoint(String name, String point);

    // @Query(value = "SELECT * FROM animal a WHERE a.type LIKE %:type% AND a.name
    // LIKE %:name% AND a.point LIKE %:point%", nativeQuery = true)
    List<Animal> findByTypeAndNameAndPoint(String type, String name, String point);
}
