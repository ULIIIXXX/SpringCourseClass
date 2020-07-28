package com.bolsadeideas.springboot.form.models.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.validation.IdentificadorRegex;
import com.bolsadeideas.springboot.form.validation.Requerido;

@Component
public class Usuario {
	//Dos digitos del rango 0-9, seguidos de un punto, seguidos de 3 digitos en un  rango de 0-9, separados por un punto, seguidos de 3 digitos en un rango del 0-9
	//separados por un guion, seguidos de un digitos en un rango A-Z
	//@Pattern(regexp= "[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String tokenId;
	
	@NotNull
	private Pais pais;
	//@NotEmpty
	@Requerido
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	@Size(min=3, max=8)
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private Integer cuenta;
	@NotNull
	@FutureOrPresent
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	private String valorSecreto;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username= username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTokenId() {
		return tokenId;
	}
	
	public void setTokenId(String tokenId) {
		this.tokenId=tokenId;
	}
	
	public Integer getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais=pais;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getValorSecreto() {
		return this.valorSecreto;
	}
	
	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto= valorSecreto;
	}
	
	
	
	

}
