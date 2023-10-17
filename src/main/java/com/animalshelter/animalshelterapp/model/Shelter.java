package com.animalshelter.animalshelterapp.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Shelter {
    private String address;
    @Autowired
    public Shelter(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
