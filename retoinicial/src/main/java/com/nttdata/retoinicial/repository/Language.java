package com.nttdata.retoinicial.repository;

// IMPORTS //
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Mapeo de la entidad "idioma"
 * 
 * @author Santiago López
 *
 */
@Entity
@Table (name="Languages")
@ApiModel(description = "Información del idioma")
public class Language implements Serializable{
	// ATRIBUTOS //
	/**
	 * 
	 * SERIAL VERSION
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Mapeos //	
	/**
	 * 
	 * Atributo: Nombre del idioma
	 * 
	 */
	@ApiModelProperty(notes = "Nombre del idioma")
	@Column (name="Name")
	private String name;
	
	/**
	 * 
	 * Atributo: Mensaje de 'Hola Mundo' traducido en
	 * su respectivo idioma
	 * 
	 */
	
	@ApiModelProperty(notes = "'Hola mundo' traducido al idioma")
	@Column (name="Message")
	private String message;
	
	/**
	 * 
	 * Atributo: Id del idioma
	 * 
	 */
	@ApiModelProperty(notes = "Número identificador del idioma")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	// MÉTODOS //
	
	// Getters y Setters //
	/**
	 * 
	 * Devuelve el nombre del idioma
	 * 
	 * @return String: Nombre
	 * 
	 */
	public String getName() {
		log.info("Recuperando nombre del idioma: {}", name);
		return name;
	}

	/**
	 * 
	 * Asigna el nombre del idioma
	 * 
	 * @param name
	 * 
	 */
	public void setName(String name) {
		log.info("Asignando nombre al idioma: {}", name);
		this.name = name;
	}

	/**
	 * 
	 * Devuelve el mensaje traducido
	 * 
	 * @return String: Mensaje
	 * 
	 */
	public String getMessage() {
		log.info("Recuperando mensaje de saludo del idioma: {}", message);
		return message;
	}

	/**
	 * 
	 * Asigna el mensaje traducido
	 * 
	 * @param mssg
	 * 
	 */
	public void setMessage(String mssg) {
		log.info("Asignando mensaje de saludo al idioma: {}", mssg);
		this.message = mssg;
	}

	/**
	 * 
	 * Devuelve la ID del idioma
	 * 
	 * @return int Id
	 * 
	 */
	public int getId() {
		log.info("Recuperando ID del idioma: {}", id);
		return id;
	}

	/**
	 * 
	 * Asigna una ID al idioma
	 * 
	 * @param id
	 * 
	 */
	public void setId(int id) {
		log.info("Asignando ID al idioma: {}", id);
		this.id = id;
	}

	// To String //
	@Override
	public String toString() {
		String mssg = "Language [name=" + name + ", message=" + message + ", id=" + id + "]";
		
		log.info("Mostrando toda la información del idioma: {}", mssg);
		
		return mssg;
	}
	
	
	
}
