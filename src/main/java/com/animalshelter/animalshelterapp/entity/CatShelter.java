package com.animalshelter.animalshelterapp.entity;

import javax.persistence.*;


@Entity
@Table(name = "cat_shelter")
public class CatShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "info")
    private String info;
    @Column(name = "guardData")
    private String guardData;
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "contact")
    private String contact;
}
