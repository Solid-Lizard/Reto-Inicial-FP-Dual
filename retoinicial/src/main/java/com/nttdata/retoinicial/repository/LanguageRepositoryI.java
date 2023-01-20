package com.nttdata.retoinicial.repository;

// IMPORTS //
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Repositorio de la entidad "Idioma"
 * 
 * @see Language
 * 
 * @author Santiago López
 *
 */
@Repository
public interface LanguageRepositoryI extends JpaRepository<Language, Integer>{
	/**
	 * 
	 * Devuelve un idioma según su nombre
	 * 
	 * @param name
	 * 
	 * @return Language
	 * 
	 */
	public Language findByName (String name);
	
	/**
	 * 
	 * Devuelve un idioma en base a su mensaje de "hola mundo"
	 * 
	 * @param mssg
	 * 
	 * @return Language
	 * 
	 */
	public Language findByMessage (String mssg);
	
	/**
	 * 
	 * Devuelve un idioma en base a su identificador
	 * 
	 * @param Id
	 * 
	 * @return Language
	 * 
	 */
	public Language findById(int Id);
	
}
