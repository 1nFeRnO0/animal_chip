package com.example.animal_chip.services;

import com.example.animal_chip.models.Animal;
import com.example.animal_chip.models.Image;
import com.example.animal_chip.repositories.AnimalRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> listAnimals(String type) {
        if (type != null) return animalRepository.findByName(type);
        return animalRepository.findAll();
    }

    public void saveAnimal(Animal animal, @org.jetbrains.annotations.NotNull MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            animal.addImageToAnimal(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            animal.addImageToAnimal(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            animal.addImageToAnimal(image3);
        }
        log.info("Saving new Animal.type: {}; .name: {}", animal.getType(), animal.getName());
        Animal animalFromDb = animalRepository.save(animal);
        animalFromDb.setPreviewImageId(animalFromDb.getImages().get(0).getId());
        animalRepository.save(animal);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteAnimal(long id) {
        animalRepository.deleteById(id);
    }

    public Animal getAnimalById(long id) {
        return animalRepository.findById(id).orElse(null);
    }
}
