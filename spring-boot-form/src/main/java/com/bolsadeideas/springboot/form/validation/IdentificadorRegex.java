package com.bolsadeideas.springboot.form.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy = IdentificadorRegexValidador.class ) //Agregamos de acuerdo a la anotacion la clase que va a a ctuar como validador
@Retention(RUNTIME) //Valida en tiempo de ejecucion
@Target({ FIELD, METHOD }) //Recibe un campo y un metodo
public @interface IdentificadorRegex { //Esta interface recibira los parametros de los campos para validarlos
	String message() default "El identificador es invalido desde la anotacion";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
