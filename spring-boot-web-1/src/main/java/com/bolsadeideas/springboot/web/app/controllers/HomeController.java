package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//estamos cradno un metodo de redireccion al index controller
public class HomeController {
	
	@GetMapping("/")
	public String Home() {
		//return "redirect:/app/index/";
		//si suisiera redireccionar podria ser un ejemplo como este  (Reinicia el request)
		//return "redirect:https://www.google.com";
		// si no quisiera redirigir ya que cambia la URL (No reinicia el request realiza un dispatcher)
		
		return "forward:/app/index";  //(Para una pagina de inicio ya que no redirige hacia otra URL) ejecuta un RequestDispatcher()
	}

}
