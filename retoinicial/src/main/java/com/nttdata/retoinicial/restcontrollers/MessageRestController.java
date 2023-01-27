package com.nttdata.retoinicial.restcontrollers;

// IMPORTS //
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * Controlador rest que se comunica con el repositorio github
 * 
 * @author Santiago López Arredondo
 *
 */
@RefreshScope
@RestController
public class MessageRestController {
	
	// ATRIBUTOS //
	/**
	 * 
	 * LOGGER
	 * 
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 * Almacena el mesnaje que se encuentra en el fichero .properties del repositorio
	 * 
	 */
  @Value("${message:Hello default}")
  private String message;

  // MÉTODOS //
  /**
   * 
   * Devuelve el msaludo del fichero .properties
   * 
   * @return String - Mensaje
   * 
   */
  @ApiOperation(
			value = "Devuelve el saludo almacenado en el fichero .properties del repositorio github"
			)
  
  @RequestMapping("/message")
  public String getMessage() {
	  log.info("Mostrando saludo en el fichero .properties del repositorio github");
	  return this.message;
  }
  
}
