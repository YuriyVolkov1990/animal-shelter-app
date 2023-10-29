package com.animalshelter.animalshelterapp.service.impl;

import com.animalshelter.animalshelterapp.entity.Shelter;
import com.animalshelter.animalshelterapp.service.ShelteringService;

public class DogShelteringService implements ShelteringService {
    private Shelter shelter;
    @Override
    public String getInfo(String shelterId) {
        return shelter.getAddress();
    }
}
