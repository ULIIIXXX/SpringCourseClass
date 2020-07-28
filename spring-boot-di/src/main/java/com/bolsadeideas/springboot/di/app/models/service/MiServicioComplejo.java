package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary  La anotacipn primary sirve para deiferneciar entre los metodos que se ejecutan ya que los dos tienen elmismo nombre e implementan la mismam interfaz
//@Component("miServicioComplejo")
public class MiServicioComplejo implements IService {
	
	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante complejo";
	}

}
