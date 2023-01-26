package com.nttdata.retoinicial.services;

// IMPORTS //
import java.util.List;

import com.nttdata.retoinicial.repository.Language;

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
	/**
	 * 
	 * Almacena un idioma pasado por parámetro en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void create(Language l);
	
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
	public Language searchByName (String name);
	
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
	public Language searchByMessage (String mssg);
	
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
	public Language searchById(int Id);
	
	/**
	 * 
	 * Devuelve una lista de todos los idiomas de la BDD
	 * 
	 * @return List - Lista de idiomas
	 * 
	 */
	public List<Language> searchAll();
	
	/**
	 * 
	 * Actualiza un idioma (pasado por parámetros) en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void update (Language l);
	
	/**
	 * 
	 * Elimina un idioma (pasado por parámetros) en la BDD
	 * 
	 * @param l - Idioma
	 * 
	 */
	public void delete (Language l);
}
