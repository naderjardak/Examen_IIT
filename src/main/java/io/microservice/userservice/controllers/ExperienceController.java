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

    @PostMapping("/createExperience")
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        Experience createdExperience = iExperienceService.createExperience(experience);
        return ResponseEntity.ok(createdExperience);
    }

    @GetMapping("/getAllExperiences")
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = iExperienceService.getAllExperiences();
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/getExperienceById")
    public ResponseEntity<Experience> getExperienceById(@RequestParam long id) {
        Experience experience = iExperienceService.getExperienceById(id);
        if (experience != null) {
            return ResponseEntity.ok(experience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateExperience")
    public ResponseEntity<Experience> updateExperience(@RequestParam long id, @RequestBody Experience experience) {
        Experience existingExperience = iExperienceService.getExperienceById(id);
        if (existingExperience != null) {
            experience.setId(id);
            Experience updatedExperience = iExperienceService.updateExperience(experience);
            return ResponseEntity.ok(updatedExperience);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteExperience")
    public ResponseEntity<Void> deleteExperience(@RequestParam long id) {
        iExperienceService.deleteExperience(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/getExperiencesByUserId")
    public ResponseEntity<List<Experience>> getExperiencesByUserId(@RequestParam long userId) {
        List<Experience> experiences = iExperienceService.getExperiencesByUserId(userId);
        return ResponseEntity.ok(experiences);
    }


}
