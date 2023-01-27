package com.nttdata.retoinicial.services;

// IMPORTS //
import java.util.List;

import com.nttdata.retoinicial.dto.LanguageDTO;

/**
 * 
 * Interfaz del servicio de gestión de idiomas
 * 
 * @see Language
 * 
 * @author Santiago López
 *
 */
public interface LanguageManagementServiceI {
	// MÉTODOS //
	// CRUD //
	/**
	 * 
	 * Almacena un idioma pasado por parámetro en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void create(LanguageDTO l);
	
	/**
	 * 
	 * Devuelve un idioma con el mismo nombre (pasado
	 * por parámetro) en la BDD
	 * 
	 * @param name
	 * 
	 * @return Language
	 * 
	 */
	public LanguageDTO searchByName (String name);
	
	/**
	 * 
	 * Devuelve un idioma con el mismo mensaje de "hola mundo"
	 * (pasado por parámetros) en la BDD
	 * 
	 * @param mssg - Mensaje
	 * 
	 * @return Language
	 * 
	 */
	public LanguageDTO searchByMessage (String mssg);
	
	/**
	 * 
	 * Devuelve un idioma con el mismo identificador
	 * (pasado por parámetros) en la BDD.
	 * 
	 * @param Id
	 * 
	 * @return Language
	 * 
	 */
	public LanguageDTO searchById(int id);
	
	/**
	 * 
	 * Devuelve una lista de todos los idiomas de la BDD
	 * 
	 * @return List - Lista de idiomas
	 * 
	 */
	public List<LanguageDTO> searchAll();
	
	/**
	 * 
	 * Actualiza un idioma (pasado por parámetros) en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void update (LanguageDTO l);
	
	/**
	 * 
	 * Elimina un idioma (pasado por parámetros) en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void delete (LanguageDTO l);
	
}
