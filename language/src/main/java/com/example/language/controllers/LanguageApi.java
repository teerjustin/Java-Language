package com.example.language.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.language.models.Language;
import com.example.language.services.LanguageService;


@RestController
public class LanguageApi {
    private final LanguageService languageService;
    
    public LanguageApi(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/languageTest")
    public List<Language> index() {
    	System.out.println("I am here");
        return languageService.allLanguages();
    }
    
//    @RequestMapping(value="/language/create", method=RequestMethod.POST)
//    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") Double version) {
//        Language language = new Language(name, creator, version);
//        return languageService.createLanguage(language);
//    }
//    
//    @RequestMapping("/language/{id}")
//    public Language show(@PathVariable("id") Long id) {
//        Language language = languageService.findLanguage(id);
//        return language;
//    }
//    
//    //DELETE WORKS
//    @RequestMapping("/language/{id}/delete")
//    public void deleteLanguage(@PathVariable("id") Long id) {
//        languageService.deleteLanguage(id);
//    }
//    
//    //UPDATE WORKS
//    @RequestMapping(value="/languages/{id}/edit", method=RequestMethod.PUT)
//    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") Double version) {
//        Language language = languageService.updateLanguage(id, name, creator, version);
//        return language;
//    }
}
