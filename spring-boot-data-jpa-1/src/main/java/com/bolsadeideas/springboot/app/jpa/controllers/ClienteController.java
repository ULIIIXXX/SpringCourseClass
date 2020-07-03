package com.bolsadeideas.springboot.app.jpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/listar")
    public String listarItems(Model model){
        return "";
    }

}
