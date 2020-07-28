package com.bolsadeideas.springboot.form.services;

import java.util.List;

import com.bolsadeideas.springboot.form.models.entity.Role;

public interface RoleService {
	public List<Role> listar();
	public Role obtenerPorId(Integer id);
}
