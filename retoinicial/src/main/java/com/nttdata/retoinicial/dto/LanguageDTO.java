package com.nttdata.retoinicial.dto;

// IMPORTS //
import java.io.Serializable;

/**
 * 
 * Patrón DTO para la entidad "Language"
 * 
 * @see Language
 * 
 * @author Santiago López Arredondo
 *
 */
public class LanguageDTO implements Serializable{
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
		
		// Mapeos //	
		/**
		 * 
		 * Atributo: Nombre del idioma
		 * 
		 */
		private String name;
		
		/**
		 * 
		 * Atributo: Mensaje de 'Hola Mundo' traducido en
		 * su respectivo idioma
		 * 
		 */
		
		private String message;
		
		/**
		 * 
		 * Atributo: Id del idioma
		 * 
		 */
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
