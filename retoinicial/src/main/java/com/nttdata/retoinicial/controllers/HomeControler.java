package com.nttdata.retoinicial.controllers;

// IMPORT //
import org.springframework.beans.factory.annotation.Autowired;
// IMPORTS //
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;

/**
 * 
 * Controlador de bienvenida
 * 
 * @author Santiago López
 *
 */
@Controller
@RequestMapping("/home")
public class HomeControler {
	@Autowired
	LanguageManagementServiceI languageService;
	
	// MÉTODOS //
	/**
	 * 
	 * Muestra el mensaje de "Hola mundo" en un idioma dependiendo del parámetro
	 * que reciba.
	 * 
	 * @param language - Idioma en el que se va a mostrar el mensaje
	 * @return String - Mensaje
	 * 
	 */
	@GetMapping("/helloWorld")
	public @ResponseBody String helloWorld( @RequestParam("language") String language ) {
		Language l = languageService.searchByName(language);
		
		String mssg = "Lo sentimos, no tenemos ese idioma en nuestra base de datos";
		
		if (l != null) {
			mssg = l.getMessage();			
		}
		
		return mssg;
	}
	
	/**
	 * 
	 * Muestra el mensaje de bienvenida a la aplicación
	 * 
	 * @return String - Mensaje
	 * 
	 */
	@GetMapping("/*")
	public @ResponseBody String welcome() {
		return "¡Bienvenido/a!, si quieres ver el 'hola mundo', dirígete a /helloWorld ";
	}
	
}
