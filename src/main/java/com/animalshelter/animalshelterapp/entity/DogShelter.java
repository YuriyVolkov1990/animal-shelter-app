package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;


@Entity
@Table(name = "dog_shelter")
public class DogShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
