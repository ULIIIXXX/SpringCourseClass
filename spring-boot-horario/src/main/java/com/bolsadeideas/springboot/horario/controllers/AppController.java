package com.bolsadeideas.springboot.horario.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@RequestMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("index","Bienvenido al horario de apertura");
		return "index";
	}
	
	@RequestMapping("/cerrado")
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visitenos entre las ");
		mensaje.append(apertura);
		mensaje.append("hrs, y las ");
		mensaje.append(cierre);
		mensaje.append("hrs, gracias.");
		
		model.addAttribute("titulo", "Fuera del horario de servicio");
		model.addAttribute("mensaje", mensaje);
		
		return "cerrado";
	}

}
