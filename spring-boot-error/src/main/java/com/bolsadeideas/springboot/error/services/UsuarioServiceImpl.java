package com.bolsadeideas.springboot.error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		lista = new ArrayList<>();
		lista.add(new Usuario(1,"Ulises","Contreras"));
		lista.add(new Usuario(2,"Miram","Munoz"));
		lista.add(new Usuario(3,"Ana","Lira"));
		lista.add(new Usuario(4,"Claudia","Alejandro"));
		lista.add(new Usuario(5,"Alexis","Sanchez"));
		lista.add(new Usuario(6,"Yairo","Reyes"));
		
	}

	@Override
	public List<Usuario> listar() {
		
		return this.lista;
	}

	@Override
	public Usuario findById(Integer id) {
		
		Usuario user = null;
		
		for(Usuario u : this.lista) {
			if(u.getId().equals(id)){
				user = u;
			}
		}
		
		return user;
	}

	@Override
	public Optional<Usuario> findByIdOptional(Integer Id) {
		Usuario user =  this.findById(Id);
		return Optional.ofNullable(user);
	}

}
