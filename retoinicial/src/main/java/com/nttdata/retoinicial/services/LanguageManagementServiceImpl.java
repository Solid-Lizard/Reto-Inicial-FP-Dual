package com.nttdata.retoinicial.services;

// IMPORTS //
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.retoinicial.dto.LanguageDTO;
import com.nttdata.retoinicial.mappers.LanguageMapper;
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
	private static final String NO_SE_HA_ENCONTRADO_EL_IDIOMA_DESEADO = "No se ha encontrado el idioma deseado";

	private static final String IDIOMA_ENCONTRADO_SATISFACTORIAMENTE = "Idioma encontrado satisfactoriamente";

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
	public void create(LanguageDTO l) {
		log.info("Almacenando idioma en la BDD: {}", l);
		Language languageEntity = LanguageMapper.INSTANCE.languageDtoToLanguage(l);
		
		languageRepo.save(languageEntity);
		log.info("Idioma almacenado satisfactoriamente");
		
	}

	@Override
	public LanguageDTO searchByName(String name) {
		log.info("Buscando idioma por nombre: {}", name);
		
		if (languageRepo.findByName(name) != null) {
			log.info(IDIOMA_ENCONTRADO_SATISFACTORIAMENTE);
			
		} else {
			log.error(NO_SE_HA_ENCONTRADO_EL_IDIOMA_DESEADO);
			
		}
		
		return LanguageMapper.INSTANCE.languageToLanguageDto(languageRepo.findByName(name));
	}

	@Override
	public LanguageDTO searchByMessage(String mssg) {
		log.info("Buscando idioma por mensaje de saludo: {}", mssg);
		if (languageRepo.findByMessage(mssg) != null) {
			log.info(IDIOMA_ENCONTRADO_SATISFACTORIAMENTE);
			
		} else {
			log.error(NO_SE_HA_ENCONTRADO_EL_IDIOMA_DESEADO);
			
		}
		
		return  LanguageMapper.INSTANCE.languageToLanguageDto(languageRepo.findByMessage(mssg));
	}

	@Override
	public LanguageDTO searchById(int id) {
		log.info("Buscando idioma por ID: {}", id);
		
		if (languageRepo.findById(id) != null) {
			log.info(IDIOMA_ENCONTRADO_SATISFACTORIAMENTE);
			
		} else {
			log.error(NO_SE_HA_ENCONTRADO_EL_IDIOMA_DESEADO);
			
		}
		
		return  LanguageMapper.INSTANCE.languageToLanguageDto(languageRepo.findById(id));
	}

	@Override
	public List<LanguageDTO> searchAll() {
		log.info("Buscando todos los idiomas");
		List<Language> languageList = languageRepo.findAll();
		
		return  LanguageMapper.INSTANCE.languagesToLanguageDto(languageList);
	}

	@Override
	public void update(LanguageDTO l) {
		log.info("Actualizando idioma");
		
		Language languageEntity = LanguageMapper.INSTANCE.languageDtoToLanguage(l);
		
		languageRepo.save(languageEntity);
		log.info("Idioma actualizado satisfactoriamente");
	
		
	}

	@Override
	public void delete(LanguageDTO l) {
		log.info("Eliminando idioma de la BDD");
		Language languageEntity = LanguageMapper.INSTANCE.languageDtoToLanguage(l);
		languageRepo.delete(languageEntity);
		log.info("Idioma eliminado satisfactoriamente");
		
	}

}
