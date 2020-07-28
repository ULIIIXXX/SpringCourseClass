package com.bolsadeideas.springboot.app.jpa.controllers;

import com.bolsadeideas.springboot.app.jpa.models.dao.ICliente;
import com.bolsadeideas.springboot.app.jpa.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    public ICliente iCliente;

    @GetMapping("/listar")
    public String listarItems(Model model){
        model.addAttribute("titulo","Miembros del equipo");
        model.addAttribute("clientes",iCliente.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crearMiembro(Map<String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente",cliente);
        model.put("titulo","Formulario de registro");
        return "form";
    }

    //aqui se debe habilitar la validacion para que pase en elr egistro
    @PostMapping("/form")
    public String guardarMiembro(@Valid Cliente cliente, BindingResult result, Model model){  //Bindoig result y el pobjeto a validar siempr edeben ir juntos
        if(result.hasErrors()){
            model.addAttribute("titulo","Formulario de Empelados");
            return "form";
        }
            iCliente.save(cliente);
            return "redirect:listar";

    }

    //Editar un registro
    @RequestMapping("/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String,Object> model){
        Cliente cliente = null;
        if(id > 0 ){
            cliente = iCliente.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("cliente",cliente);               //aqui pasa los datos del elemento encontrado a la vista, envia todo el objeto
        model.put("titulo","Editar empleado");
        return "form";
    }

    @RequestMapping("/form/{id}")
    public String eliminar(@PathVariable(value="id") Long id){
        if(id > 0 ){
            iCliente.deleteItem(id);
        }
        return "redirect:/listar";
    }

}
