package com.bolsadeideas.springboot.form.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.models.entity.Usuario;

@Component
public class UsuarioValidator implements Validator{ //Debe implemematr el de spring framework validator

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Usuario.class.isAssignableFrom(clazz);  //asigana la calse que se va a validar
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre", "NotEmpty.usuario.nombre");
		
		/*if(!usuario.getTokenId().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")) {
			errors.rejectValue("tokenId", "patter.usuario.identificador");  //rejectValue indica que el valor no sera aceptado ya que no cumple con losc criterios establecidos
			
		}*/
	} 

}
