package com.example.animal_chip.repositories;

import com.example.animal_chip.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
