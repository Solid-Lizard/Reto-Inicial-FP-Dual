package com.nttdata.retoinicial.services;

// IMPORTS //
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.retoinicial.repository.Language;
import com.nttdata.retoinicial.repository.LanguageRepositoryI;

/**
 * 
 * Implementación de la interfaz "LanguageManagementServiceI"
 * 
 * @see LanguageManagementServiceI
 * 
 * @author Santiago López
 *
 */
@Service
public class LanguageManagementServiceImpl implements LanguageManagementServiceI{
	// ATRIBUTOS //
	/**
	 * 
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	// MÉTODOS //
	/**
	 * 
	 * Repositorio: "idioma"
	 * 
	 */
	@Autowired
	LanguageRepositoryI languageRepo;
	
	// ATRIBUTOS //
	@Override
	public void create(Language l) {
		log.info("Almacenando idioma en la BDD: {}", l);
		languageRepo.save(l);
		log.info("Idioma almacenado satisfactoriamente");
		
	}

	@Override
	public Language searchByName(String name) {
		log.info("Buscando idioma por nombre: {}", name);
		if (languageRepo.findByName(name) != null) {
			log.info("Idioma encontrado satisfactoriamente");
			
		} else {
			log.error("No se ha encontrado el idioma deseado");
			
		}
		
		return languageRepo.findByName(name);
	}

	@Override
	public Language searchByMessage(String mssg) {
		log.info("Buscando idioma por mensaje de saludo: {}", mssg);
		if (languageRepo.findByMessage(mssg) != null) {
			log.info("Idioma encontrado satisfactoriamente");
			
		} else {
			log.error("No se ha encontrado el idioma deseado");
			
		}
		
		return languageRepo.findByMessage(mssg);
	}

	@Override
	public Language searchById(int id) {
		log.info("Buscando idioma por ID: {}", id);
		
		if (languageRepo.findById(id) != null) {
			log.info("Idioma encontrado satisfactoriamente");
			
		} else {
			log.error("No se ha encontrado el idioma deseado");
			
		}
		
		return languageRepo.findById(id);
	}

	@Override
	public List<Language> searchAll() {
		log.info("Buscando todos los idiomas");
		return languageRepo.findAll();
	}

	@Override
	public void update(Language l) {
		log.info("Actualizando idioma");
		languageRepo.save(l);
		log.info("Idioma actualizado satisfactoriamente");
		
	}

	@Override
	public void delete(Language l) {
		log.info("Eliminando idioma de la BDD");
		languageRepo.delete(l);
		log.info("Idioma eliminado satisfactoriamente");
		
	}

}
