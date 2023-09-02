package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.IEducationService;
import io.microservice.userservice.entities.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {



    @Autowired
    IEducationService iEducationService;
    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education createdEducation = iEducationService.createEducation(education);
        return ResponseEntity.ok(createdEducation);
    }

    @GetMapping("/getAllEducations")
    public ResponseEntity<List<Education>> getAllEducations() {
        List<Education> educations = iEducationService.getAllEducations();
        return ResponseEntity.ok(educations);
    }

    @GetMapping("/getEducationById")
    public ResponseEntity<Education> getEducationById(@RequestParam Long id) {
        Education education = iEducationService.getEducationById(id);
        if (education != null) {
            return ResponseEntity.ok(education);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateEducation")
    public ResponseEntity<Education> updateEducation(@RequestParam Long id, @RequestBody Education education) {
        Education existingEducation = iEducationService.getEducationById(id);
        if (existingEducation != null) {
            education.setId(id);
            Education updatedEducation = iEducationService.updateEducation(education);
            return ResponseEntity.ok(updatedEducation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEducation")
    public ResponseEntity<Void> deleteEducation(@RequestParam Long id) {
        iEducationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getEducationByUserId")
    public ResponseEntity<List<Education>> getEducationByUserId(@RequestParam long userId) {
        List<Education> educationRecords = iEducationService.getEducationByUserId(userId);
        return ResponseEntity.ok(educationRecords);
    }

}
