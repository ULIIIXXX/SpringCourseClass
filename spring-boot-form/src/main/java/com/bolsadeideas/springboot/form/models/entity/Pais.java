package com.bolsadeideas.springboot.form.models.entity;


public class Pais {
	public Integer id;
	public String clave;
	public String pais;
	
	public Pais() {}
	
	public Pais(Integer id,  String clave, String pais) {
		this.id= id;
		this.clave = clave;
		this.pais=pais;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}
	
	

}
