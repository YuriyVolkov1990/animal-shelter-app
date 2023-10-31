package com.animalshelter.animalshelterapp.entity;

import com.animalshelter.animalshelterapp.repository.DogRepository;

import javax.persistence.Entity;

@Entity
public abstract class Dog implements DogRepository {
    private int id;
    private int age;
    private int weight;
}
