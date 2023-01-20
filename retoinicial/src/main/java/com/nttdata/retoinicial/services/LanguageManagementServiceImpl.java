package com.nttdata.retoinicial.services;

// IMPORTS //
import java.util.List;

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
	
	// MÉTODOS //
	/**
	 * 
	 * Repositorio: Repositorio de "idioma"
	 * 
	 */
	@Autowired
	LanguageRepositoryI languageRepo;
	
	// ATRIBUTOS //
	@Override
	public void create(Language l) {
		languageRepo.save(l);
		
	}

	@Override
	public Language searchByName(String name) {
		return languageRepo.findByName(name);
	}

	@Override
	public Language searchByMessage(String mssg) {
		return languageRepo.findByMessage(mssg);
	}

	@Override
	public Language searchById(int Id) {
		return languageRepo.findById(Id);
	}

	@Override
	public List<Language> searchAll() {
		return languageRepo.findAll();
	}

	@Override
	public void update(Language l) {
		languageRepo.save(l);
		
	}

	@Override
	public void delete(Language l) {
		languageRepo.delete(l);
		
	}

}
