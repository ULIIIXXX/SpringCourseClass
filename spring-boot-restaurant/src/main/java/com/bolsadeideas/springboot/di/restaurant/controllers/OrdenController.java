package com.bolsadeideas.springboot.di.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.restaurant.models.Factura;

@Controller
@RequestMapping("/factura")
public class OrdenController {
	
	@Autowired
	private Factura factura;
	
	@GetMapping("/ver")
	public String verOrden(Model model) {
		model.addAttribute("Titulo", "Restaurante 'Pescaditos' Factura");
		model.addAttribute("factura", factura);
		return "factura/ver";
	}

}
