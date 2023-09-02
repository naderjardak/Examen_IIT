package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ILanguageService;
import io.microservice.userservice.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {


    @Autowired
    ILanguageService iLanguageService;

    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language createdLanguage = iLanguageService.createLanguage(language);
        return ResponseEntity.ok(createdLanguage);
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = iLanguageService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        Language language = iLanguageService.getLanguageById(id);
        if (language != null) {
            return ResponseEntity.ok(language);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language language) {
        Language existingLanguage = iLanguageService.getLanguageById(id);
        if (existingLanguage != null) {
            language.setId(id);
            Language updatedLanguage = iLanguageService.updateLanguage(language);
            return ResponseEntity.ok(updatedLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        iLanguageService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }
}
