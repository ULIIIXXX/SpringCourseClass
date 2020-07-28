package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary //La anotación primari nos sirve para identificar a cual de las dos implementaciones se le dara preferencia ya que las dos implementan el mismo metodo de la interfaz
//@Component("miServicioSimple") //Esto crea el famoso bean de spring framework , ahora pasa a ser una calse desacoplada y es parte de spring (bean)
public class MiServicio implements IService {
		
	@Override  //Indica que el metodo es una im,plementación de un padre 
	public String operacion() {
		return "Ejecutando algún proceso importante simple...";
	}

}
