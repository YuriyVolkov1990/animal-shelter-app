package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;


@Entity
@Table(name = "shelter")
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
