package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope //Hace que cada objeto se único, se crea y se detsurye en cada peticion HTTP
//@SessionScope //Para trabajar por sesion es decir desde que se inicia hasta que se destruye cuando se cierre el navegador, time out etc ej carrito de compras
				//Debe implemenatr serializable para que se guarden en un contexto de persistencia, 
//@ApplicationScope  //Para tener uno o mas contexto servlet 
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${cliente.nombre}")
	private String nombre;
	@Value("${cliente.apellido}")
	private String apellido;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

}
