package com.example.animal_chip.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "point")
    private String point;
    @Column(name = "description", columnDefinition = "text")
    private String description;
}