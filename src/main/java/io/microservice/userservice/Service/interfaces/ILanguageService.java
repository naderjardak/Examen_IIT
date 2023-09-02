package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Language;

import java.util.List;

public interface ILanguageService {
    Language createLanguage(Language language);
    List<Language> getAllLanguages();
    Language getLanguageById(Long id);
    Language updateLanguage(Language language);
    void deleteLanguage(Long id);
}
