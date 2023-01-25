package com.nttdata.retoinicial;

import java.util.Collections;

//IMPORTS //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nttdata.retoinicial.repository.Language;
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
	
	/*
	 * Un docket es una instancia de un objeto de este tipo
	 * que contiene todas las configuraciones que swagger va a emplear,
	 * siempre que tengamos un Bean de este tipo, podremos configurar
	 * dentro de esta clase todos los elementos de swagger.
	 */
	
	@Bean
	public Docket swaggerConfiguration() {
		// El método SELECT devuelve un objeto de tipo ApiSelectorBuilder
		// Este constructor tiene métodos que nos permite realizar la configuración
		// de swagger
		
		/*
		 * Una vez hemos realizado la configuración, llamamos al método "Build" para que
		 * construya un objeto de tipo Docket con la configuración deseada
		 */
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				// Esto nos permite seleccionar que controladores van a documentarse
				// en base a su url, usamos "PathSelectors" para definir el patrón que
				// debe seguir la URL de los controladores para no ser excluida
//				.paths(PathSelectors.ant("/home/*"))
				
				// Este método excluye los controladores que no se encuentran debajo del paquete elegido
				// código
				.apis(RequestHandlerSelectors.basePackage("com.nttdata"))
				.build()
				.apiInfo(apiDetails());
	}
	
	// Creamos un método que define los metadatos del proyecto //
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
