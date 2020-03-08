package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

	@Controller //toda clase controladora se denota por la palabra controller
	@RequestMapping("/app") ///es una ruta de primer nivel las de los metodos de segundo nivel
	public class IndexController {
		@GetMapping({"/index", "/", "","/home"})
		//@RequestMapping(value="/index",method=RequestMethod.GET)
		public String index(Model model) { //Model pasa datos a la vista
			model.addAttribute("titulo", "hola spring");
			return "index";
		}
		
		@RequestMapping("/perfil")
		public String perfil(Model model) {
			Usuario usr = new Usuario();
			usr.setNombre("Ulises");
			usr.setApellido("Contreras");
			usr.setEmail("adolfocontreras59@gmail.com");
			model.addAttribute("Usuario",usr);
			model.addAttribute("titulo", "Perfil de usuario: " .concat(usr.getNombre()));
			return "perfil";
		}
		
		@RequestMapping("/listar")
		public String listar (Model model) {
			List<Usuario> usuarios = new ArrayList<>();
			model.addAttribute("titulo","Listado de usuarios");
			model.addAttribute("usuarios", usuarios);
			
			return "listar";
		}
	}

