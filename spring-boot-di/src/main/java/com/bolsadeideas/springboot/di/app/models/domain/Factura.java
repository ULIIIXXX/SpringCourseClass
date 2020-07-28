package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component  //Es un pojo
@RequestScope  //Hace que cada peticion HTTP sea única, es decir el objeto se crea y destruye para cada cliente
//@SessionScope    //Para que haga el atributo unico pero debe implementar serializable
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired //La inyeccion es directa por que solo es una implementacion
	private List<ItemFactura> items;
	
	                      //Podemos odificar datos del componente o hacer una tarea despues de que se construya el bjeto, es parecido al constructor pero Spring 
	@PostConstruct 			//la maneja  y  nosotors inicializamos lo que queremos
	public void init() {  //Siempre son void para ejecutar algo o modificar algun atributo
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Adolfo"));
		descripcion = descripcion.concat(cliente.getNombre());
	}
	
	@PreDestroy            //Segun el ciclpo de vida la instancia dura hasta que bajemos la aplicacion del servidor
	public void destroy() {
		System.out.println("Se dstruyo la factura de:" .concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	
	
	

}
