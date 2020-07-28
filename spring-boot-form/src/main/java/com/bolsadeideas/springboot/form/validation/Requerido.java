package com.bolsadeideas.springboot.form.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy= CampoRequerido.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Requerido {
	String message() default "El campo no puede ser vacio ul";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
