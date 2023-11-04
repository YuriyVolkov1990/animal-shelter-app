package com.animalshelter.animalshelterapp.service;

import com.animalshelter.animalshelterapp.entity.Volunteer;
import com.animalshelter.animalshelterapp.exception.CatNotFoundException;
import com.animalshelter.animalshelterapp.repository.VolunteerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolunteerService {
    private static final Logger logger = LoggerFactory.getLogger(DogService.class);
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }
    public Volunteer registerVolunteer(Volunteer volunteer) {
        logger.info("Запускаем метод registerVolunteer.Регистрируем кота в приюте");
        return volunteerRepository.save(volunteer);
    }

    public Volunteer findVolunteerById(Long volunteerId) {
        logger.info("Запускаем метод findCatById. Ищем кота по id");
        return volunteerRepository.findById(volunteerId)
                .orElseThrow(CatNotFoundException::new);
    }

    public Volunteer updateVolunteer(Long volunteerId, Volunteer volunteer) {
        logger.info("Запускаем метод updateVolunteer. Изменяем информацию о волонтере");
        Volunteer existingDog = volunteerRepository.findById(volunteerId)
                .orElseThrow(CatNotFoundException::new);
        existingDog.setName(volunteer.getName());
        existingDog.setSurname(volunteer.getSurname());
        return volunteerRepository.save(existingDog);
    }

    public Volunteer deleteDog(Long volunteerId) {
        logger.info("Запускаем метод deleteCat. Удаляем кота из базы");
        Volunteer volunteer = volunteerRepository.findById(volunteerId).orElseThrow(CatNotFoundException::new);
        volunteerRepository.delete(volunteer);
        return volunteer;
    }
}
