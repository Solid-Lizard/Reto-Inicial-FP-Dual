package com.nttdata.retoinicial.controllers;

// IMPORTS //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;

/**
 * 
 * Controlador para realizar operaciones CRUD contra la BDD, para ello consume el servicio
 * de gestión de idiomas.
 * 
 * @author Santiago López
 * 
 * @see LanguageManagementServiceI
 *
 */
@Controller
@RequestMapping("/languages")
public class CrudController {
	// ATRIBUTOS //
	/**
	 * 
	 * Servicio de gestión de idiomas.
	 * 
	 */
	@Autowired
	LanguageManagementServiceI languageService;
	
	// MÉTODOS //
	/**
	 * 
	 * Devuelve una vista que contiene una tabla con todos los
	 * idiomas existentes
	 * 
	 * @param model
	 * 
	 * @return
	 * 
	 */
	@GetMapping("/languageList")
	public String viewLanguageList(Model model) {
		model.addAttribute("listLanguages", languageService.searchAll());
		return "LanguageList";
	}
	
	/**
	 * 
	 * Permite crear un idioma con los parámetros especificados por el usuario
	 * 
	 * @param name
	 * @param message
	 * @param id
	 * 
	 * @return String - Devuelve al usuario a la página de lista de idiomas
	 * 
	 */
	@GetMapping("/createLanguage")
	public String createLanguage(Model m) {	
		Language language = new Language();
		
		m.addAttribute("language", language);
		
		return "newLanguage";
		
	}
	
	@GetMapping("/updateLanguage/{id}")
	public String updateLanguage(@PathVariable int id, Model model) {
		model.addAttribute("language", languageService.searchById(id));
		return "update_language";
	}
	
	@PostMapping("/editLanguage/{id}")
	public String editLanguage(@PathVariable int id,
			@ModelAttribute("language") Language language,
			Model model) {
		
		// Recuperamos el idioma de la BDD, modificamos sus parámetros
		Language l = languageService.searchById(id);
		l.setId(language.getId());
		l.setName(language.getName());
		l.setMessage(language.getMessage());
		
		// Almacenamos el idioma actualizado nuevamente en la BDD
		languageService.update(l);
				
		return "redirect:/languages/languageList";
		
	}
	
	@PostMapping("/saveLanguage")
	public String saveLanguage (@ModelAttribute("language") Language language) {
		languageService.create(language);
		return "redirect:/languages/languageList";
	}
	
	@GetMapping ("/deleteLanguage/{id}")
	public String deleteStudent(@PathVariable int id) {
		Language l = languageService.searchById(id);
		languageService.delete(l);
		return "redirect:/languages/languageList";
	}

}
