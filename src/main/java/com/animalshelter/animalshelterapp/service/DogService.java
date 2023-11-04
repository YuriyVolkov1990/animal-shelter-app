package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Dog;
import com.animalshelter.animalshelterapp.exception.CatNotFoundException;
import com.animalshelter.animalshelterapp.repository.DogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    private static final Logger logger = LoggerFactory.getLogger(DogService.class);

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog registerCat(Dog dog) {
        logger.info("Запускаем метод registerCat.Регистрируем кота в приюте");
        return dogRepository.save(dog);
    }

    public Dog findCatById(Long dogId) {
        logger.info("Запускаем метод findCatById. Ищем кота по id");
        return dogRepository.findById(dogId)
                .orElseThrow(CatNotFoundException::new);
    }

    public Dog updateCat(Long dogId, Dog dog) {
        logger.info("Запускаем метод updateCat. Изменяем информацию о коте");
        Dog existingDog = dogRepository.findById(dogId)
                .orElseThrow(CatNotFoundException::new);
        existingDog.setName(dog.getName());
        existingDog.setAge(dog.getAge());
        return dogRepository.save(existingDog);
    }

    public Dog deleteCat(Long dogId) {
        logger.info("Запускаем метод deleteCat. Удаляем кота из базы");
        Dog dog = dogRepository.findById(dogId).orElseThrow(CatNotFoundException::new);
        dogRepository.delete(dog);
        return dog;
    }
}
