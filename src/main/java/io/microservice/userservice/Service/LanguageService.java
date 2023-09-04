package io.microservice.userservice.Service;

import io.microservice.userservice.entities.Language;
import io.microservice.userservice.repositories.LanguageRepository;
import io.microservice.userservice.Service.interfaces.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {



    @Autowired
    LanguageRepository languageRepository;

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public Language updateLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
