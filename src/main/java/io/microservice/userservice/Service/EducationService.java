package io.microservice.userservice.Service;

import io.microservice.userservice.entities.Education;
import io.microservice.userservice.repositories.EducationRepository;
import io.microservice.userservice.Service.interfaces.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {



    @Autowired
    EducationRepository iEducationRepository;

    @Override
    public Education createEducation(Education education) {
        return iEducationRepository.save(education);
    }

    @Override
    public List<Education> getAllEducations() {
        return iEducationRepository.findAll();
    }

    @Override
    public Education getEducationById(Long id) {
        return iEducationRepository.findById(id).orElse(null);
    }

    @Override
    public Education updateEducation(Education education) {
        return iEducationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        iEducationRepository.deleteById(id);
    }

    @Override
    public List<Education> getEducationByUserId(long userId) {
        return iEducationRepository.findByUserId(userId);
    }
}
