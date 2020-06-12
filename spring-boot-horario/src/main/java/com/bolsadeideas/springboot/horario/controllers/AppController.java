package com.bolsadeideas.springboot.horario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("index","Bienvenido al horario de apertura");
		return "index";
	}

}
