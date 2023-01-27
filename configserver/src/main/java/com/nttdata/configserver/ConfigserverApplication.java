package com.nttdata.configserver;

// IMPORTS //
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * Clase principal de la aplicación
 * 
 * @author Santiago López Arredondo
 *
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigserverApplication {
	// MÉTODOS //
	/**
	 * 
	 * Método de entrada a la aplicación
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication.class, args);
	}

}
