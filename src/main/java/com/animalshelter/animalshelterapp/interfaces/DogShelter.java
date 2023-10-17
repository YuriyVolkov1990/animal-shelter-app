package com.animalshelter.animalshelterapp.interfaces;

import com.animalshelter.animalshelterapp.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogShelter extends JpaRepository<Dog, Long> {
}
