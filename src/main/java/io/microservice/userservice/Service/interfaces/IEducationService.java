package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Education;

import java.util.List;

public interface IEducationService {
    Education createEducation(Education education);
    List<Education> getAllEducations();
    Education getEducationById(Long id);
    Education updateEducation(Education education);
    void deleteEducation(Long id);

    List<Education> getEducationByUserId(long userId);
}
