package com.nttdata.retoinicial;

// IMPORTS //
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.nttdata.retoinicial.dto.LanguageDTO;

import com.nttdata.retoinicial.services.LanguageManagementServiceI;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * Clase principal de la aplicación
 * 
 * @author Santiago Lopez Arredondo
 *
 */

@SpringBootApplication
@EnableSwagger2
public class RetoinicialApplication implements CommandLineRunner{
	// ATRIBUTOS //
	/**
	 * 
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
		log.trace("--INICIO DE LA APLICACIÓN--");
		
		log.info("--INICIANDO CREACIÓN DE IDIOMAS--");
		// Creación de idiomas //
		LanguageDTO dto1 = new LanguageDTO();
		dto1.setId(1);
		dto1.setMessage("Hallo Welt!");
		dto1.setName("GER");
		
		LanguageDTO dto2 = new LanguageDTO();
		dto2.setId(2);
		dto2.setMessage("¡Hola Mundo!");
		dto2.setName("ESP");
		
		LanguageDTO dto3 = new LanguageDTO();
		dto3.setId(3);
		dto3.setMessage("Hello World!");
		dto3.setName("ENG");
		
		LanguageDTO dto4 = new LanguageDTO();
		dto4.setId(4);
		dto4.setMessage("Ciao mondo!");
		dto4.setName("ITA");
		
		log.info("--IDIOMAS CREADOS SATISFACTORIAMENTE--");		
		
		// Consumimos el servicio de gestión de idiomas //
		log.info("--CONSUMIENDO SERVICIO DE GESTIÓN DE IDIOMAS PARA ALMACENARLOS EN LA BDD--");
		languageService.create(dto1);	
		languageService.create(dto2);
		languageService.create(dto3);
		languageService.create(dto4);
		log.info("--SERVICIO DE GESTIÓN DE IDIMAS CONSUMIDO SATISFACTORIAMENTE--");
		
	}
	
	/**
	 * 
	 * Docket de configuración de springfox
	 * 
	 * @return Docket - Objeto que suministra la configuración de springfox
	 * 
	 */
	@Bean
	public Docket swaggerConfiguration() {
		
		// Definimos la configuración de swagger a través  de la clase
		// API Selector builder
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.nttdata"))
				.build()
				.apiInfo(apiDetails());
	}
	
	/**
	 * 
	 * Asigna los metadatos de la API
	 * 
	 * @return ApiInfo - Objeto que contiene los metadatos de la API
	 * 
	 */
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Reto Inicial", 
				"API para realizar el ejercicio 'Proyecto Inicial' asignado a el alumnado de FP Dual", 
				"1.0", 
				"Uso libre", 
				new springfox.documentation.service.Contact("Santiago López Arredondo", "https://github.com/Solid-Lizard/Reto-Inicial-FP-Dual", "santi.lopar@gmail.com"), 
				"API License", 
				"https://github.com/Solid-Lizard/Reto-Inicial-FP-Dual", 
				Collections.emptyList());
	}
	
	

}
