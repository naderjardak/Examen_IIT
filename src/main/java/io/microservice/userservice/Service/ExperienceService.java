package io.microservice.userservice.Service;

import io.microservice.userservice.entities.Experience;
import io.microservice.userservice.repositories.ExperienceRepository;
import io.microservice.userservice.Service.interfaces.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService {



    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public Experience updateExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public List<Experience> getExperiencesByUserId(long userId) {
        return experienceRepository.findByUserId(userId);
    }


}
