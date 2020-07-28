package com.bolsadeideas.springboot.form.services;

import java.util.List;

import com.bolsadeideas.springboot.form.models.entity.Pais;

public interface PaisService {
	public List<Pais> listar();
	public Pais findPaisById(Integer id);
}
