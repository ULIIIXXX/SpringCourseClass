package com.bolsadeideas.springboot.di.restaurant.models;

public class ItemOrden {
	private Orden orden;
	private Integer cantidad;
	
	public ItemOrden(Orden orden, Integer cantidad) {
		this.orden=orden;
		this.cantidad= cantidad;
	}
	
	public Orden getOrden() {
		return orden;
	}
	
	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
