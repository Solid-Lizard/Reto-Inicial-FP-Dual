package com.nttdata.retoinicial.restcontrollers;

// IMPORTS //
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.services.LanguageManagementServiceI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * Controlador REST del servicio de gestión de Idiomas
 * 
 * @author Santiago López Arredondo
 *
 */
@RestController
@RequestMapping("/rest")
public class CrudRestController {
	// ATRIBUTOS //
	/**
	 * 
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 * Inyección del servicio de gestión de idiomas
	 * 
	 */
	@Autowired
	private LanguageManagementServiceI languageService;

	// MÉTODOS //
	
	// CRUD //
	/**
	 * 
	 * Solicitud POST que almacena el idioma dado en la BDD
	 * 
	 * @param l
	 * 
	 * @return Language - Idioma almacenado
	 * 
	 */
	@ApiOperation(
			value = "Crea un idioma pasado por parámetros",
			notes = "Proporciona un Idioma para poder crearlo en la BDD"
			)
	
	@PostMapping("/languages")
	public Language newLanguage(@ApiParam (value = "Idioma que se almacenará en la BDD") @RequestBody Language l) {
		log.info("Consumiendo servicio de creación de clientes");
		languageService.create(l);
		log.info("Servicio consumido satisfactoriamente");
		
		return l;
	}
	
	
	// Read //
	/**
	 * 
	 * Solicitud GET que devuelve una lista con todos los idiomas existentes en la BDD
	 * 
	 * @return List - Todos los idiomas
	 * 
	 */
	@ApiOperation(
			value = "Búsqueda de todos los idiomas",
			notes = "Devuelve todos los idiomas existentes en la BDD"
			)
	
	@GetMapping("/languages")
	public List<Language> all() {
		log.info("Consumiendo servicio de búsqueda de idiomas");
		return languageService.searchAll();
	}
	
	/**
	 * 
	 * Devuelve un idioma con la mism ID
	 * 
	 * @param id
	 * 
	 * @return Language - Idioma encontrado
	 * 
	 */
	@ApiOperation(
			value = "Búsqueda de un idioma en base a la ID",
			notes = "Busca y devuelve un idioma que contenga la misma ID en la base de datos"
			)
	
	@GetMapping("/searchById/{id}")
	public Language findById( @ApiParam (value = "Id del idioma deseado")  @PathVariable int id) {
		log.info("Consumiendo servicio de búsqueda de idiomas");
		return languageService.searchById(id);
	}
	
	/**
	 * 
	 * Devuelve un idioma con el mismo mensaje
	 * 
	 * @param mssg
	 * 
	 * @return Language - Idioma encontrado
	 * 
	 */
	@ApiOperation(
			value = "Búsqueda de un idioma en base a su mensaje",
			notes = "Busca y devuelve un idioma que contenga el mismo mensaje de saludo en la BDD"
			)
	
	@GetMapping("/searchByMssg/{mssg}")
	public Language findByMssg(@ApiParam (value = "Mensaje de saludo del idioma deseado") @PathVariable String mssg) {
		log.info("Consumiendo servicio de búsqueda de idiomas");
		return languageService.searchByMessage(mssg);
	}
	
	// Update //
	/**
	 * 
	 * Actualiza los datos de un idioma en la BDD
	 * 
	 * @param l - Idioma que contiene los datos nuevos.
	 * @param id - Id del idioma que va a ser actualizado
	 * 
	 * @return Language - Idioma con sus datos actualizados
	 * 
	 */
	@ApiOperation(
			value = "Actualiza un idioma en la BDD",
			notes = "Busca un idioma en la BDD en base a la ID pasada por parámetros del usuario, porteriormente actualiza los datos del mismo"
					+ " sacándolos de un objeto idioma también pasado por el usuario."
			)
	
	@PutMapping("/updateLanguage/{id}")
	public Language updateLanguage(@ApiParam (value = "Idioma con los datos actualizados") @RequestBody Language l,
			@ApiParam (value = "ID del idioma que queremos modificar") @PathVariable int id) {
		
		// Busca el idioma a actualizar en la BDD
		log.info("Consumiendo servicio de búsqueda de idiomas");
		Language l2 = languageService.searchById(id);
		log.info("Servicio consumido satisfactoriamente");
		
		if (l2 != null) {
			// Si se ha encontrado ese idioma, se actualizan sus datos
			log.info("Actualizando propiedades del idioma");
			l2.setName(l.getName());
			l2.setMessage(l.getMessage());
			log.info("Propiedades del idioma actualizadas");
			
			log.info("Consumiendo servicio de actualización de idioma");
			languageService.update(l2);
			log.info("Servicio consumido satisfactoriamente");
			
		} else {
			// Si no se ha encontrado el idioma, se almacena el idioma dado en la BDD
			log.error("El idioma que se está intentando actualizar no existe, creando un idioma con los datos proporcionados");
			l.setId(id);
			
			log.info("Consumiendo servicio de creación de idiomas");
			languageService.create(l2);
			log.info("Servicio consumido satisfactoriamente");
			
		}
		
		return l;
		
	}
	
	// Delete //
	/**
	 * 
	 * Elimina un idioma de la BDD que contenga la misma ID 
	 * 
	 * @param id
	 * 
	 */
	@ApiOperation(
			value = "Elimina un idioma de la BDD",
			notes = "Elimina un idioma de la BDD que contenga la misma ID que ha pasado el usuario por parámetros"
			)
	
	@DeleteMapping("/deleteLanguage/{id}")
	public void deleteLanguage(@ApiParam (value = "ID del idioma que se desea eliminar") @PathVariable int id) {
		log.info("Consumiendo servicios de búsqueda y eliminación de idiomas");
		languageService.delete(languageService.searchById(id));
		log.info("Servicios consumidos satisfactoriamente");
	}
	
}
