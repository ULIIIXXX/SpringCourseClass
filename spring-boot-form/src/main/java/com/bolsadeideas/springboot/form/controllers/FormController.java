package com.bolsadeideas.springboot.form.controllers;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.editors.NombreMayusculasEditor;
import com.bolsadeideas.springboot.form.editors.PaisPropertyEditoy;
import com.bolsadeideas.springboot.form.editors.RoleEditor;
import com.bolsadeideas.springboot.form.models.entity.Pais;
import com.bolsadeideas.springboot.form.models.entity.Role;
import com.bolsadeideas.springboot.form.models.entity.Usuario;
import com.bolsadeideas.springboot.form.services.PaisService;
import com.bolsadeideas.springboot.form.services.RoleService;
import com.bolsadeideas.springboot.form.validation.UsuarioValidator;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidator validador;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisPropertyEditoy paisPropertyEditor;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleEditor roleEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		formato.setLenient(false);
		binder.registerCustomEditor(Date.class,"fecha", new CustomDateEditor(formato, false));
		//Para mayusculas y inuculas
		binder.registerCustomEditor(String.class,"nombre", new NombreMayusculasEditor());
		binder.registerCustomEditor(String.class,"apellido", new NombreMayusculasEditor());
		
		//Para validar el objeto pais
		binder.registerCustomEditor(Pais.class,"pais", paisPropertyEditor);
		
		//Para el role Editor
		binder.registerCustomEditor(Role.class,"roles", roleEditor);
		
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setHabilitar(true);
		usuario.setNombre("George");
		usuario.setApellido("Caldero");
		usuario.setTokenId("213485-Ke");
		usuario.setRoles(Arrays.asList(new Role(2,"Usuario","ROLE_USER")));
		usuario.setValorSecreto("Secretamente soy un poco ingenuo ****");
		usuario.setPais(new Pais(2,"MX","México"));
		model.addAttribute("Titulo", "Formulario de usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		//validador.validate(usuario, result);  //BindingResult tambien es de ptipo errors 
		
		if (result.hasErrors()) {
			/*Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(),
						"El campo ".concat(" ").concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
			});
			model.addAttribute("error", errores); */
			model.addAttribute("Titulo", "Datos de usuario");
			return "form";
		}
		
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String redirigir (@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
		if(usuario== null) {
			return "redirect:/form";
		}
		model.addAttribute("Titulo", "Datos de usuario");
		status.setComplete();
		return "resultado";
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("México", "Chile", "Colombia","Estados Unidos", "Canada", "Perú");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("CL", "Chile");
		paises.put("CO", "colombia");
		paises.put("US", "Estados Unidos");
		paises.put("CA", "Canada");
		paises.put("PE", "Perú");
		return paises;
		
	}
	
	@ModelAttribute("paisesObjeto")
	public List<Pais> listaPaises(){
		return paisService.listar();
	}
	
	@ModelAttribute("listaRoles")
	public List<String> roles(){
		List<String> roles = new ArrayList<String>();	
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("mapRoles")
	public Map<String,String> rolesMap(){
		Map<String, String> roles = new HashMap<>();
		
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}
	
	@ModelAttribute("listaObjetoRoles")
	public List<Role> listaObjRoles(){
		return this.roleService.listar();
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre","Mujer","Pan con jamon");
	}
}
