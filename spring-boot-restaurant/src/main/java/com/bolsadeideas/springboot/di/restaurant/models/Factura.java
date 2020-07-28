package com.bolsadeideas.springboot.di.restaurant.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Factura {
	@Value("${factura.descripcion}")
	private String descripcion;
	@Autowired
	private Cliente cliente;
	@Autowired
	private List<ItemOrden> orden;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente= cliente;
	}
	
	public List<ItemOrden> getOrden() {
		return orden;
	}
	
	public void setOrden(List<ItemOrden> orden) {
		this.orden = orden;
	}
	
}
