package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Experience;

import java.util.List;

public interface IExperienceService {
    Experience createExperience(Experience experience);
    List<Experience> getAllExperiences();
    Experience getExperienceById(Long id);
    Experience updateExperience(Experience experience);
    void deleteExperience(Long id);

    List<Experience> getExperiencesByUserId(long userId);
}
