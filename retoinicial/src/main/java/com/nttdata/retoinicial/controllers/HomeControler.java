package com.nttdata.retoinicial.controllers;

// IMPORTS //
import org.springframework.beans.factory.annotation.Autowired;
// IMPORTS //
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	// ATRIBUTOS //
	/**
	 * 
	 * Servicio de gestión de idiomas
	 * 
	 */
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
	@ApiOperation(
			value = "Devuelve el mensaje de 'hola mundo' traducido a un idioma que se buscará en base a un parámetro pasado por el usuario"
			)
	@GetMapping("/helloWorld")
	public @ResponseBody String helloWorld( @ApiParam("Nombre del idioma que pasará el usuario como parámetro") @RequestParam("language") String language ) {
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
	@ApiOperation(
			value = "Muestra el mensaje de bienvenida a la aplicación"
			)
	@GetMapping("/*")
	public @ResponseBody String welcome() {
		return "¡Bienvenido/a!, si quieres ver el 'hola mundo', dirígete a /helloWorld ";
	}
	
}
