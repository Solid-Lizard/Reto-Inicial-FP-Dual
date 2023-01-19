package repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Languages")
public class Language {
	// ATRIBUTOS //
	
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
	@Column (name="Mesage")
	private String mssg;
	
	/**
	 * 
	 * Atributo: Id del idioma
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	// MÉTODOS //
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
	public String getMssg() {
		return mssg;
	}

	/**
	 * 
	 * Asigna el mensaje traducido
	 * 
	 * @param mssg
	 * 
	 */
	public void setMssg(String mssg) {
		this.mssg = mssg;
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
	
	
}
