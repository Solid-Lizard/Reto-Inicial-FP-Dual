package com.nttdata.retoinicial;

//IMPORTS //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;


/**
 * 
 * Clase principal de la aplicación
 * 
 * @author Santiago Lopez Arredondo
 *
 */
@SpringBootApplication
public class RetoinicialApplication implements CommandLineRunner{
	// ATRIBUTOS //
	/**
	 * 
	 * Servicio de gestion de idiomas
	 * 
	 * @see LanguageManagementServiceI
	 * 
	 */
	@Autowired
	LanguageManagementServiceI languageService;
	
	// MÉTODOS //
	/**
	 * 
	 * Método de etrada a la aplicación.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {		
		SpringApplication.run(RetoinicialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		// Creación de idiomas //
		Language l1 = new Language();
		l1.setId(1);
		l1.setMessage("Hallo Welt!");
		l1.setName("GER");
		
		Language l2 = new Language();
		l2.setId(2);
		l2.setMessage("¡Hola Mundo!");
		l2.setName("ESP");
		
		Language l3 = new Language();
		l3.setId(3);
		l3.setMessage("Hello World!");
		l3.setName("ENG");
		
		Language l4 = new Language();
		l4.setId(4);
		l4.setMessage("Ciao mondo!");
		l4.setName("ITA");

		// Consumimos el servicio de gestión de idiomas //
		languageService.create(l1);	
		languageService.create(l2);
		languageService.create(l3);
		languageService.create(l4);
		
	}
	
	

}
