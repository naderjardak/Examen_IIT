package io.microservice.userservice.controllers;

import io.microservice.userservice.entities.Language;
import io.microservice.userservice.Service.interfaces.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {


    @Autowired
    ILanguageService iLanguageService;

    @PostMapping("createLanguage")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language createdLanguage = iLanguageService.createLanguage(language);
        return ResponseEntity.ok(createdLanguage);
    }

    @GetMapping("getAllLanguages")
    public ResponseEntity<List<Language>> getAllLanguages() {
        List<Language> languages = iLanguageService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/getLanguageById")
    public ResponseEntity<Language> getLanguageById(@RequestParam Long id) {
        Language language = iLanguageService.getLanguageById(id);
        if (language != null) {
            return ResponseEntity.ok(language);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateLanguage")
    public ResponseEntity<Language> updateLanguage(@RequestParam Long id, @RequestBody Language language) {
        Language existingLanguage = iLanguageService.getLanguageById(id);
        if (existingLanguage != null) {
            language.setId(id);
            Language updatedLanguage = iLanguageService.updateLanguage(language);
            return ResponseEntity.ok(updatedLanguage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteLanguage")
    public ResponseEntity<Void> deleteLanguage(@RequestParam Long id) {
        iLanguageService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }
}
