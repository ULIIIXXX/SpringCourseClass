package com.bolsadeideas.springboot.error.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.error.models.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listar();
	
	public Usuario findById(Integer id);
	
	public Optional<Usuario> findByIdOptional(Integer Id);

}
