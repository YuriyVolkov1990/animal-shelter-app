package com.animalshelter.animalshelterapp.entity;

import com.animalshelter.animalshelterapp.interfaces.DogRepository;

public abstract class Dog implements DogRepository {
    private int id;
    private int age;
    private int weight;
}
