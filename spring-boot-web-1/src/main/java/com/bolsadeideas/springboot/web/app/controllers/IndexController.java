package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

	@Controller //toda clase controladora se denota por la palabra controller
	@RequestMapping("/app") ///es una ruta de primer nivel las de los metodos de segundo nivel
	public class IndexController {
		@Value("${texto.indexcontroller.index.titulo}")
		private String textoIndex;
		
		@Value("${texto.indexcontroller.perfil.titulo}")
		private String textoPerfil;
		
		@Value("${texto.indexcontroller.perfil-usuarios}")
		private String textoListar;
		
		@GetMapping({"/index", "/", "","/home"})
		//@RequestMapping(value="/index",method=RequestMethod.GET)
		public String index(Model model) { //Model pasa datos a la vista
			model.addAttribute("titulo", textoIndex);
			return "index";
		}
		
		@RequestMapping("/perfil")
		public String perfil(Model model) {
			Usuario usr = new Usuario();
			usr.setNombre("Ulises");
			usr.setApellido("Contreras");
			usr.setEmail("adolfocontreras59@gmail.com");
			model.addAttribute("Usuario",usr);
			model.addAttribute("titulo", textoPerfil .concat(usr.getNombre()));
			return "perfil";
		}
		
		@RequestMapping("/listar")
		public String listar (Model model) {
			//List<Usuario> usuarios = new ArrayList<>();
			//usuarios.add(new Usuario("Juan","Valdes","vlades@example.com"));
			//usuarios.add(new Usuario("Ana","Herera","ana@loca.com"));
			//usuarios.add(new Usuario("Jose","Julian","jose.pepe@tesseract.mx"));
			model.addAttribute("titulo",textoListar);
			//model.addAttribute("usuarios", usuarios);
			
			return "listar";
		}
		
		//Otra forma mas simplificada de pasar datos al controlador
		//Se utiliza cuando se hacen SELECT para poblar, tambien se pude usar con botones, mas adelante veremos
		// sera en comun a todos los metodos del controlador , se puede usar en cualquier vista
		@ModelAttribute("usuarios")
		public List<Usuario> poblarUsuarios(){
			List<Usuario> usuarios = Arrays.asList(new Usuario("Ulises","Contreras","ulises.contreras@tesseract.mx"),
					new Usuario("Claudia","Alejandro","claudia.alejandro@tesseract.mx"),
					new Usuario("Gabriel","Garcia","gabriel.garcia@tesseract.mx"));
			return usuarios;
		}
	}

