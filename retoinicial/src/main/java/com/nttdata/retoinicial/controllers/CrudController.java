package com.nttdata.retoinicial.controllers;

// IMPORTS //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/")
	public String viewLanguageList(Model model) {
		model.addAttribute("listLanguages", languageService.searchAll());
		return "index";
	}
	
	/**
	 * 
	 * Permite crear un idioma con los parámetros especificados por el usuario
	 * 
	 * @param name
	 * @param message
	 * @param id
	 * 
	 * @return String - Mensaje que informa si el idioma se ha creado satisfactoriamente o no
	 * 
	 */
	@GetMapping("/create")
	public @ResponseBody String create(
			@RequestParam("name") String name, 
			@RequestParam("message") String message,
			@RequestParam("id") int id
			
	) {		
		return name;
		
	}

}
