package com.bolsadeideas.springboot.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.models.entity.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> paises;
	
	public PaisServiceImpl() {
		this.paises =  Arrays.asList(
				new Pais(1,"ES","España"),
				new Pais(2,"MX","México"),
				new Pais(3,"CL","Chile"),
				new Pais(4,"CO","Colombia"),
				new Pais(5,"US","Estados Unidos"),
				new Pais(6,"Ca","Canada"),
				new Pais(7,"PE","Perú")
			);
	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return paises;
	}

	@Override
	public Pais findPaisById(Integer id) {
		// TODO Auto-generated method stub
		
		Pais resultado = null;
		for(Pais pais : paises) {
			if(id == pais.getId()) {
				resultado = pais;
			}
		}
		return resultado;
	}

}
