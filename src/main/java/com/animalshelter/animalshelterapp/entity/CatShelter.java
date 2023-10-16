package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;


@Entity
@Table(name = "cat_shelter")
public class CatShelter extends Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
