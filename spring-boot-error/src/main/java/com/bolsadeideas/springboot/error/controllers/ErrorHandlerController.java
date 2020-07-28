package com.bolsadeideas.springboot.error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.error.Errores.UserNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generic";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberException(NumberFormatException ex, Model model) {
		model.addAttribute("error","Error de conversion");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("timestamp",new Date());
		return "error/generic";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String numberException(UserNotFoundException ex, Model model) {
		model.addAttribute("error","Error: Usuario no encontrado");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		model.addAttribute("timestamp",new Date());
		return "error/usuario";
	}

}
