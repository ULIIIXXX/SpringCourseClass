
package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

@Controller
@RequestMapping("/factura")   //La ruta mapeada para acceder al endpoint
public class FacturaController {
	
	@Autowired
	private Factura factura;  //Es decir se va a inyectar la fatura desde la clase
	
	@GetMapping("/ver")       //Es un metodo get
	public String factura(Model model) {
		
		model.addAttribute("Titulo", "Factura de compra");
		model.addAttribute("factura", factura);
		return "factura/ver";
		
	}

}
