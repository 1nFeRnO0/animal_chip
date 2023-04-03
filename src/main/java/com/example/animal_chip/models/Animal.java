package com.example.animal_chip.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {
    private Long animalID;
    private String animalSpecie;
    private String animalType;
    private Long organizationID;
}