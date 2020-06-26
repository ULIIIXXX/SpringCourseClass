package com.bolsadeideas.springboot.app.jpa.models.dao;

import com.bolsadeideas.springboot.app.jpa.models.entity.Cliente;

import java.util.List;

public interface ICliente {

    public List<Cliente> findAll();

}
