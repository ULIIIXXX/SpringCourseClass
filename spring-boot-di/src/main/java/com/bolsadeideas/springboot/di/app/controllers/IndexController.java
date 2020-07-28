package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IService;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;

@Controller
public class IndexController {
	
	//@Autowired  //Permite la inyeccion de dependencias
	//@Qualifier("miServicioComplejo")  Tambien sierve para dar preferrencia a uno  otra inyeccion de dependecias
	@Autowired
	@Qualifier("miServicioComplejo")
	private IService servicio;   //Inyectamos a traves de la interfaz
	
	//Inyeccion por constructor
	
	//@Autowired  //No es necesario el atributo autowired ya que al  tener la clase la anotacion
				// component se hace automaticamente, pero es una buena practica ponerlo
	public IndexController(IService servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("opcion", servicio.operacion());
		return "index";
	}
	
	
	//inyeccion de dependecias por set
	
	/*
	@Autowired
	public void setServicio(IService servicio) {
		this.servicio= servicio;
	} */
}

/*
getApplication ()obtiene el usuario
Token cifrados RSA y AES
el usuario le hizo esto al token hizo esta operacion con tal OTP
*/