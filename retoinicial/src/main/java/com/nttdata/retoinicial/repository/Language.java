package com.nttdata.retoinicial.repository;

// IMPORTS //
import java.io.Serializable;

// IMPORTS //
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * Mapeo de la entidad "idioma"
 * 
 * @author Santiago López
 *
 */
@Entity
@Table (name="Languages")
public class Language implements Serializable{
	// ATRIBUTOS //
	/**
	 * 
	 * SERIAL VERSION
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Mapeos //	
	/**
	 * 
	 * Atributo: Nombre del idioma
	 * 
	 */
	@Column (name="Name")
	private String name;
	
	/**
	 * 
	 * Atributo: Mensaje de 'Hola Mundo' traducido en
	 * su respectivo idioma
	 * 
	 */
	@Column (name="Message")
	private String message;
	
	/**
	 * 
	 * Atributo: Id del idioma
	 * 
	 */
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
		this.id = id;
	}

	// To String //
	@Override
	public String toString() {
		return "Language [name=" + name + ", message=" + message + ", id=" + id + "]";
	}
	
	
	
}
