package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.IExperienceService;
import io.microservice.userservice.entities.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {



    @Autowired
    IExperienceService iExperienceService;

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        Experience createdExperience = iExperienceService.createExperience(experience);
        return ResponseEntity.ok(createdExperience);
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = iExperienceService.getAllExperiences();
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable long id) {
        Experience experience = iExperienceService.getExperienceById(id);
        if (experience != null) {
            return ResponseEntity.ok(experience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable long id, @RequestBody Experience experience) {
        Experience existingExperience = iExperienceService.getExperienceById(id);
        if (existingExperience != null) {
            experience.setId(id);
            Experience updatedExperience = iExperienceService.updateExperience(experience);
            return ResponseEntity.ok(updatedExperience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable long id) {
        iExperienceService.deleteExperience(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/getExperiencesByUserId")
    public ResponseEntity<List<Experience>> getExperiencesByUserId(@RequestParam long userId) {
        List<Experience> experiences = iExperienceService.getExperiencesByUserId(userId);
        return ResponseEntity.ok(experiences);
    }


}
