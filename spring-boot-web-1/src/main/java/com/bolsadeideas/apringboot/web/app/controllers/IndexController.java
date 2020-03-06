package com.bolsadeideas.apringboot.web.app.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //toda clase controladora se denota por la palabra controller
public class IndexController {
	@GetMapping({"/index", "/", "/home"})
	//@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model) { //Model pasa datos a la vista
		model.addAttribute("titulo", "hola spring");
		return "index";
	}
}
