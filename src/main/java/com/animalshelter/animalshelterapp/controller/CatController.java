package com.animalshelter.animalshelterapp.controller;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cat")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public ResponseEntity<Cat> registerCat(@RequestBody Cat cat) {
        Cat registredCat =
    }
    }
}
