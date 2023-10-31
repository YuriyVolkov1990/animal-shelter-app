package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.repository.CatShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {

    private final CatShelterRepository catShelterRepository;

    public ShelterService(CatShelterRepository catShelterRepository) {
        this.catShelterRepository = catShelterRepository;
    }
    public String getInfo(Long shelterId) {
        return catShelterRepository.findById(shelterId).toString();
    }

}
