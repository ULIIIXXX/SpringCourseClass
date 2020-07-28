package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Siempre se anota los controladores con esa anotacion
@RequestMapping("/params") //URL o endpoint que va a buscar
public class EjemploParamscontroller {
	
	
	@GetMapping("/")
	public String index() {
		
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false, defaultValue="Texto de ejemplo") String texto, Model model) {
		//la idea es pasar parametros tipo get mediante la URL
		model.addAttribute("resultado","El texto enviado mediante get es: " + texto);
		return "params/ver";
	}
	
	//Pasar multiples parametros
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException ex) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo enviado es: '" +  saludo + "' y el número es '" + numero);
		return "params/ver";
	}
	
	
}
