package com.bolsadeideas.springboot.web.app.models;

//un pojo es una clase simple que contiene atributos para los metodos 
//puede implementar interfaces de java como serializable pero no de framework
public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}


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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
