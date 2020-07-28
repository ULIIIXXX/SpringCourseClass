package com.bolsadeideas.springboot.error.Errores;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String id) {
		super("Usuario con ID: ".concat(id).concat("No existe en el sistema."));
		// TODO Auto-generated constructor stub
	}
	
	

}
