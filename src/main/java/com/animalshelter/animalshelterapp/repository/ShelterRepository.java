package com.animalshelter.animalshelterapp.repository;

import com.animalshelter.animalshelterapp.entity.DogShelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<DogShelter, Long> {
}
