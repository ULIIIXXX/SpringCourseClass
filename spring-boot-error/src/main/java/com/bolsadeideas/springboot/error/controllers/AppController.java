package com.bolsadeideas.springboot.error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.Errores.UserNotFoundException;
import com.bolsadeideas.springboot.error.models.domain.Usuario;
import com.bolsadeideas.springboot.error.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/index")
	public String index() {
		int numero = 100/0;
		//int numero = Integer.parseInt("borego");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String verUsuario(@PathVariable Integer id, Model model) {
		/*Usuario user = usuarioService.findById(id);
		if(user == null) {
			throw new UserNotFoundException(id.toString());
		}*/
			Usuario user = usuarioService.findByIdOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
		
			model.addAttribute("usuario", user);
			model.addAttribute("titulo","Detalle del usuario:".concat(user.getNombre()));
			return "ver";
		
		
	}
	
}
