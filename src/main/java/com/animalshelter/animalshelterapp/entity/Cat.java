package com.animalshelter.animalshelterapp.entity;

import com.animalshelter.animalshelterapp.repository.CatRepository;

import javax.persistence.Entity;

@Entity
public abstract class Cat implements CatRepository {
    private int id;
    private int age;
    private int weight;


}
