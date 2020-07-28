package com.bolsadeideas.springboot.form.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class CampoRequerido implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null  || !StringUtils.hasText(value)) {
			return false;
		}
		return true;
	}

}
