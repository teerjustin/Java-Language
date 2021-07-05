package com.example.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.language.models.Language;
import com.example.language.services.LanguageService;




@Controller
public class LanguageController {
    private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/language")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        System.out.println("I am here");
        return "/languages/index.jsp";
    }
    
    @RequestMapping(value="/language/create", method=RequestMethod.POST)
	  public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	  if (result.hasErrors()) {
	      return "redirect:/language";
	  } else {
	      languageService.createLanguage(language);
	      return "redirect:/language";
	  }
	}
     
    @RequestMapping(value="/language/{id}/edit")
    public String editPage(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	System.out.println("I SHOULD BE HERE");
    	return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/language/{id}/edit", method=RequestMethod.POST)
    public String edit(@PathVariable("id") Long id, String name, String creator, Double version) {
    	System.out.println("I TRIED TO EDIT");
    	System.out.println(id + name + creator + version);
    	languageService.updateLanguage(id, name, creator, version);
    	System.out.println("I TRIED TO EDIT X 2");
    	return "redirect:/language";
    }
    
    @RequestMapping("/language/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
    	System.out.println("I TRIED TO DELETE");
    	languageService.deleteLanguage(id);
    	System.out.println("I TRIED TO DELETE X 2");
    	return "redirect:/language";
    }
   
}