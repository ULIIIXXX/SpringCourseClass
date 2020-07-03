package com.bolsadeideas.springboot.app.jpa.controllers;

import com.bolsadeideas.springboot.app.jpa.models.dao.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    public ICliente iCliente;

    @GetMapping("/listar")
    public String listarItems(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",iCliente.findAll());
        return "listar";
    }

}
