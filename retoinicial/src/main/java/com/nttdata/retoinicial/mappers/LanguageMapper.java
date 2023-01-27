package com.nttdata.retoinicial.mappers;

// IMPORTS //
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nttdata.retoinicial.dto.LanguageDTO;
import com.nttdata.retoinicial.repository.Language;

/**
 * 
 * Interfaz de mapeo para la entidad "Language", transforma entre entidad
 * y DTO de forma sencilla
 * 
 * @author Santiago López Arredondo
 * 
 * @see Language
 * @see LanguageDTO
 *
 */
@Mapper
public interface LanguageMapper {
	// ATRIBUTOS //
	/**
	 * 
	 * Instancia: Nos permite acceder a los métodos de mapeo de entidades y DTO
	 * 
	 */
	LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);
	
	// MÉTODOS //
	/**
	 * 
	 * Transofrma un idioma en un DTO
	 * 
	 * @param language
	 * 
	 * @return LanguageDTO - Idioma transformado a DTO
	 * 
	 */
	LanguageDTO languageToLanguageDto(Language language);
	
	/**
	 * 
	 * Transforma un DTO a un idioma.
	 * 
	 * @param languageDto
	 * 
	 * @return Language - DTO transformado en idioma
	 * 
	 */
	Language languageDtoToLanguage (LanguageDTO languageDto);
	
	/**
	 * 
	 * Transforma una lista de idiomas a una lista de objetos DTO
	 * 
	 * @param languages
	 * 
	 * @return List - Lista de idiomas transformados en instancias DTO
	 * 
	 */
	List<LanguageDTO> languagesToLanguageDto(List<Language> languages);
	
}
