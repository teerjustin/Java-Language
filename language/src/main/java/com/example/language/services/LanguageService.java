package com.example.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.language.models.Language;
import com.example.language.repositories.LanguageRepository;

@Service
public class LanguageService {
    // adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
    
	//update language
	public Language updateLanguage(Long id, String name, String creator, Double version) {
		Optional<Language> language = languageRepository.findById(id);
		Language b = language.get();
		b.setName(name);
		b.setCreator(creator);
		b.setVersion(version);
		return languageRepository.save(b);
	}
    
   
    
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

}