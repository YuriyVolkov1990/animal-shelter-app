package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Cat;
import com.animalshelter.animalshelterapp.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CatService {
    private static final Logger logger = LoggerFactory.getLogger(CatService.class);

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat registerCat(Cat cat) {
        logger.info("Запускаем метод registerCat.Регистрируем кота в приюте");
        return catRepository.save(cat);
    }

    public Cat findCatById(Long catId) {
        logger.info("Запускаем метод findCatById. Ищем кота по id");
        return catRepository.findById(catId)
                .orElseThrow(CatNotFoundException::new);
    }

    public Cat updateCat(Long catId, Cat cat) {
        logger.info("Запускаем метод updateCat. Изменяем информацию о коте");
        Cat existingCat = catRepository.findById(catId)
                .orElseThrow(CatNotFoundException::new);

    }
}
