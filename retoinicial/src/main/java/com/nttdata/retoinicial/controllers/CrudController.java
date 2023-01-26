package com.nttdata.retoinicial.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * Controlador para realizar operaciones CRUD contra la BDD mediante vistas, para ello consume el servicio
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
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
	 * @return String - Página de lista de idiomas
	 * 
	 */
	@ApiOperation(
			value = "Muestra todos los idiomas existentes en la BDD"
			)
	
	@GetMapping("/languageList")
	public String viewLanguageList(Model model) {
		log.info("Mostrando vista: LanguageList.html");
		
		model.addAttribute("listLanguages", languageService.searchAll());
		return "LanguageList";
	}
	
	/**
	 * 
	 * Permite crear un idioma con los parámetros especificados en el modelo por el usuario
	 * 
	 * @param name
	 * @param message
	 * @param id
	 * 
	 * @return String - Página de lista de idiomas
	 * 
	 */
	@ApiOperation(
			value = "Crea un idioma con los parametros especificados en la BDD"
			)
	
	@GetMapping("/createLanguage")
	public String createLanguage(Model m) {	
		log.info("Mostrando vista: newLanguage.html");
		
		Language language = new Language();
		
		m.addAttribute("language", language);
		
		return "newLanguage";
		
	}
	
	/**
	 * 
	 * Devuelve la vista de actualzación de idiomas.
	 * 
	 * @param id - Id del idioma que será actualizado
	 * @param model
	 * 
	 * @return String - Página de actualizar idioma
	 * 
	 */
	@ApiOperation(
			value = "Devuelve la vista de actualzación de idiomas."
			)
	
	@GetMapping("/updateLanguage/{id}")
	public String updateLanguage(@ApiParam("ID del idioma que se modificará") @PathVariable int id, Model model) {
		log.info("Mostrando vista: update_language.html");
		
		model.addAttribute("language", languageService.searchById(id));
		return "update_language";
	}
	
	/**
	 * 
	 * Actualiza un idioma con los parámetros especificados en el modelo por el usuario
	 * 
	 * @param id - Id del idioma modificado
	 * @param language - Contiene los nuevos datos del idioma a modificar.
	 * @param model
	 * 
	 * @return String - Nos devuelve a la vista de lista de idiomas una vez terminado del proceso
	 * 
	 */
	@ApiOperation(
			value = "Actualiza un idioma con los parámetros especificados en el modelo por el usuario"
			)
	
	@PostMapping("/editLanguage/{id}")
	public String editLanguage(@ApiParam("Id del idioma que se modificará") @PathVariable int id,
			@ModelAttribute("language") Language language,
			Model model) {
		log.info("Consumiendo servicio de actualización de idiomas");
		
		// Recuperamos el idioma de la BDD, modificamos sus parámetros
		Language l = languageService.searchById(id);
		l.setId(language.getId());
		l.setName(language.getName());
		l.setMessage(language.getMessage());
		
		// Almacenamos el idioma actualizado nuevamente en la BDD
		languageService.update(l);
		
		log.info("Servicio consumido satisfactoriamente, mostrando vista: LanaguagesList.html");
				
		return "redirect:/languages/languageList";
		
	}
	
	/**
	 * 
	 * Almacena un idioma dado por el usuario en la BDD
	 * 
	 * @param language
	 * 
	 * @return String - Página de lista de idiomas
	 * 
	 */
	@ApiOperation(
			value = "Almacena un idioma dado por el usuario"
			)
	
	@PostMapping("/saveLanguage")
	public String saveLanguage (@ApiParam("Idioma que se va a almacenar") @ModelAttribute("language") Language language) {
		log.info("Consumiendo servicio de creación de idiomas");
		
		languageService.create(language);
		
		log.info("Servicio consumido satisfactoriamente, mostrando vista: LanguagesList.html");
		
		return "redirect:/languages/languageList";
	}
	
	/**
	 * 
	 * Elimina un idioma de la BDD en base a su ID
	 * 
	 * @param id
	 * 
	 * @return String - Página de lista de idiomas
	 * 
	 */
	@ApiOperation(
			value = "Elimina un idioma de la BDD en base a su ID, pasada por parámetros"
			)
	
	@GetMapping ("/deleteLanguage/{id}")
	public String deleteLanguage(@ApiParam("ID del idioma que va a ser eliminado") @PathVariable int id) {
		log.info("Consumiendo servicios de búsqueda y eliminación de idiomas");
		
		Language l = languageService.searchById(id);
		
		languageService.delete(l);
		
		log.info("Servicios consumidos satisfactoriamente, mostrando vista: LanguagesList.html");
		
		return "redirect:/languages/languageList";
	}

}
