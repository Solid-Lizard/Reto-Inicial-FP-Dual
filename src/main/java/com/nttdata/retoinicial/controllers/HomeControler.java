package com.nttdata.retoinicial.controllers;

// IMPORTS //
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * Controlador principal de bienvenida
 * 
 * @author Santiago López
 *
 */
@Controller
@RequestMapping("/")
public class HomeControler {
	
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
		String mssg = "Por favor introduce un parámetro válido ('ENG', 'ESP' o  'FRAN')";
		
		if (language.equals("EN")) {
			mssg = "Hello World!";
		}
		
		if (language.equals("ESP")) {
			mssg = "¡Hola Mundo!";
		}
		
		if (language.equals("FRAN")) {
			mssg = "Salut Monde!";
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
	@GetMapping("/welcome")
	public @ResponseBody String welcome() {
		return "¡Bienvenido/a!, si quieres ver el 'hola mundo', dirígete a /helloWorld ";
	}
	
}
