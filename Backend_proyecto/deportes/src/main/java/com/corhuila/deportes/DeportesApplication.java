package com.corhuila.deportes;

// Importaciones necesarias para iniciar una aplicación Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marca la clase como la aplicación principal de Spring Boot
@SpringBootApplication
public class DeportesApplication {

	// El método main es el punto de entrada de la aplicación
	public static void main(String[] args) {
		// Ejecuta la aplicación Spring Boot, inicializando todo el contexto de la aplicación
		SpringApplication.run(DeportesApplication.class, args);
	}
}
