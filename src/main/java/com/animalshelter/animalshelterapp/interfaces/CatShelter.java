package com.animalshelter.animalshelterapp.interfaces;

import com.animalshelter.animalshelterapp.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatShelter extends JpaRepository<Cat, Long> {
}
